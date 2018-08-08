package com.hxqh.report;

import com.hxqh.report.logging.ReportLogger;

import java.sql.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;


public class MXReportDataSetImpl  implements MXReportDataSet
{
    private String name = null;

    private String query = null;

    private TreeMap<Integer, Object> queryParametersMap = new TreeMap();

    private MXReportDataSourceImpl dataSource = null;

    private Connection connection = null;
    private PreparedStatement statement = null;
    private MXReportResultSet resultSet = null;

    private ReportLogger logger = null;
    private ReportLogger sqlLogger = null;

    private String displayYesValue = null;
    private String displayNoValue = null;

    private boolean closed = false;

    private long lastRenewTime = 0L;
    private static final long RENEW_INTERVAL = 120000L;
    private HashMap dataTranslationMap = new HashMap();

    public MXReportDataSetImpl(MXReportDataSourceImpl dataSource)
    {
        this.dataSource = dataSource;

        MXReportScriptContext mxReportScriptContext = MXReportScriptContext.get();
        this.logger = mxReportScriptContext.getReportScriptLogger();
        this.sqlLogger = mxReportScriptContext.getReportScriptSqlLogger();
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getQuery()
    {
        return this.query;
    }

    public void setQuery(String query)
    {
        this.query = query;
    }

    public Object getQueryParameterValue(int index)
    {
        if (this.queryParametersMap == null)
        {
            return null;
        }

        return this.queryParametersMap.get(new Integer(index));
    }

    public void setQueryParameterValue(int index, Object value)
    {
        if (this.queryParametersMap == null)
        {
            this.queryParametersMap = new TreeMap();
        }

        this.queryParametersMap.put(new Integer(index), value);
    }

    public void open()
    {
        MXReportScriptContext mxReportScriptContext = MXReportScriptContext.get();
        if (mxReportScriptContext.isReportJobCancelled())
        {
            mxReportScriptContext.cancelReportJob();
            return;
        }

        if (this.logger.isInfoEnabled())
        {
            this.logger.info("DataSet [" + this.name + "] open called.");
        }

        if (this.connection != null)
        {
            return;
        }

        try
        {
            this.connection = this.dataSource.getConnection();
        }
        catch (Exception ex)
        {
            if (this.logger.isErrorEnabled())
            {
                this.logger.error("DataSet [" + this.name + "] " + ex.getMessage(), ex);
            }
            close();

            mxReportScriptContext.markReportFailed();
            throw new MXReportRuntimeException(ex);
        }
    }

    public void close()
    {
        if (this.closed)
        {
            return;
        }

        if (this.logger.isInfoEnabled())
        {
            this.logger.info("DataSet [" + this.name + "] close called.");
        }

        this.closed = true;
        try
        {
            if (this.resultSet != null)
            {
                this.resultSet.close();
                this.resultSet = null;
            }
        }
        catch (Exception ex)
        {
            if (this.logger.isErrorEnabled())
            {
                this.logger.error("close() failed to close resultSet.", ex);
            }
        }
        try
        {
            if (this.statement != null)
            {
                this.statement.close();
                this.statement = null;
            }
        }
        catch (Exception ex)
        {
            if (this.logger.isErrorEnabled())
            {
                this.logger.error("close() failed to close statement.", ex);
            }
        }
    }

    public boolean fetch()
    {
        MXReportScriptContext mxReportScriptContext = MXReportScriptContext.get();
        if (mxReportScriptContext.isReportJobCancelled())
        {
            mxReportScriptContext.cancelReportJob();
            return false;
        }

        if (isClosed())
        {
            return false;
        }

        if (this.connection == null)
        {
            open();

            if (this.connection == null)
            {
                return false;
            }
        }

        try
        {
            if (this.resultSet == null)
            {
                if (this.sqlLogger.isInfoEnabled())
                {
                    this.sqlLogger.info("DataSet [" + this.name + "]: " + this.query);
                }

                this.statement = this.connection.prepareStatement(this.query);

                int currentIndex = 1;
                Iterator keyIterator = this.queryParametersMap.keySet().iterator();
                while (keyIterator.hasNext())
                {
                    Integer key = (Integer)keyIterator.next();
                    if (key.intValue() != currentIndex)
                    {
                        throw new Exception("Query parameter " + currentIndex + " not set.");
                    }

                    if (this.sqlLogger.isInfoEnabled())
                    {
                        this.sqlLogger.info("DataSet [" + this.name + "] Bind index [" + currentIndex + "] = " + this.queryParametersMap.get(key));
                    }

                    this.statement.setObject(currentIndex, this.queryParametersMap.get(key));

                    currentIndex++;
                }

                renewActiveThread();

                ResultSet rs = this.statement.executeQuery();

                renewActiveThread();

                this.resultSet = new MXReportResultSet(rs);
                this.resultSet.setDataSource(this.dataSource);
                this.resultSet.setDataSet(this);
            }

            if (this.resultSet != null)
            {
                boolean fetchResult = this.resultSet.next();
                if (!fetchResult)
                {
                    close();
                }

                if (mxReportScriptContext.isReportJobCancelled())
                {
                    mxReportScriptContext.cancelReportJob();
                    close();
                    return false;
                }

                renewActiveThread();

                return fetchResult;
            }
        }
        catch (Exception ex)
        {
            if (this.logger.isErrorEnabled())
            {
                this.logger.error("DataSet [" + this.name + "] fetch failed: ", ex);
            }
            close();
            return false;
        }

        return true;
    }

    private void renewActiveThread()
    {
        if (this.lastRenewTime == 0L)
        {
            MXReportScriptContext mxReportScriptContext = MXReportScriptContext.get();
            mxReportScriptContext.renewActiveThread();
            this.lastRenewTime = System.currentTimeMillis();
            return;
        }

        long currentTime = System.currentTimeMillis();
        if (currentTime - this.lastRenewTime > 120000L)
        {
            MXReportScriptContext mxReportScriptContext = MXReportScriptContext.get();
            mxReportScriptContext.renewActiveThread();
            this.lastRenewTime = currentTime;
        }
    }

    public boolean isClosed()
    {
        return this.closed;
    }

    public String getString(String attributeName)
    {
        try
        {
            String value = null;

            if (isAttributeRequireTranslatedData(attributeName))
            {
                value = getTranslatedString(attributeName, this.resultSet);
                if ((value != null) && (value.trim().length() > 0))
                {
                    return value;
                }
            }

            return this.resultSet.getString(attributeName);
        }
        catch (Exception ex)
        {
            if (this.logger.isErrorEnabled())
            {
                this.logger.error("getString(" + attributeName + ") failed.", ex);
            }

            MXReportScriptContext mxReportScriptContext = MXReportScriptContext.get();
            mxReportScriptContext.markReportFailed();
            throw new MXReportRuntimeException(ex);
        }
    }

    public String getBooleanString(String attributeName)
    {
        try
        {
            int intValue = 0;

            intValue = this.resultSet.getInt(attributeName);
            return getBooleanString(intValue);
        }
        catch (Exception ex)
        {
            if (this.logger.isErrorEnabled())
            {
                this.logger.error("getBooleanString(" + attributeName + ") failed.", ex);
            }

            MXReportScriptContext mxReportScriptContext = MXReportScriptContext.get();
            mxReportScriptContext.markReportFailed();
            throw new MXReportRuntimeException(ex);
        }
    }

    public String getBooleanString(int intValue)
    {
        try
        {
            String textValue = null;
            MXReportScriptContext mxReportScriptContext = MXReportScriptContext.get();

            if (intValue == 1)
            {
                if (this.displayYesValue == null)
                {
                    this.displayYesValue = determineDisplayYesValue(mxReportScriptContext.getLocale().getLanguage());
                }

                textValue = this.displayYesValue;
            }
            else if (intValue == 0)
            {
                if (this.displayNoValue == null)
                {
                    this.displayNoValue = determineDisplayNoValue(mxReportScriptContext.getLocale().getLanguage());
                }
            }
            return this.displayNoValue;
        }
        catch (Exception ex)
        {
            if (this.logger.isErrorEnabled())
            {
                this.logger.error("getBooleanString(" + intValue + ") failed.", ex);
            }

            MXReportScriptContext mxReportScriptContext = MXReportScriptContext.get();
            mxReportScriptContext.markReportFailed();
            throw new MXReportRuntimeException(ex);
        }
    }

    public Integer getBooleanInteger(String booleanDisplayValue)
    {
        try
        {
            MXReportScriptContext mxReportScriptContext = MXReportScriptContext.get();

            if (booleanDisplayValue.equalsIgnoreCase("true"))
            {
                return Integer.valueOf(1);
            }

            if (booleanDisplayValue.equalsIgnoreCase("false"))
            {
                return Integer.valueOf(0);
            }

            if (booleanDisplayValue.equalsIgnoreCase("1"))
            {
                return Integer.valueOf(1);
            }

            if (booleanDisplayValue.equalsIgnoreCase("0"))
            {
                return Integer.valueOf(0);
            }

            if (this.displayYesValue == null)
            {
                this.displayYesValue = determineDisplayYesValue(mxReportScriptContext.getLocale().getLanguage());
            }

            if (this.displayNoValue == null)
            {
                this.displayNoValue = determineDisplayNoValue(mxReportScriptContext.getLocale().getLanguage());
            }

            if (booleanDisplayValue.equalsIgnoreCase(this.displayYesValue))
            {
                return Integer.valueOf(1);
            }

            return Integer.valueOf(0);
        }
        catch (Exception ex)
        {
            if (this.logger.isErrorEnabled())
            {
                this.logger.error("getBooleanInteger(" + booleanDisplayValue + ") failed.", ex);
            }

            MXReportScriptContext mxReportScriptContext = MXReportScriptContext.get();
            mxReportScriptContext.markReportFailed();
            throw new MXReportRuntimeException(ex);
        }
    }

    public String determineDisplayYesValue(String languageCode)
    {
        Connection dtConnection = null;
        PreparedStatement propValueStatement = null;
        ResultSet propValueResultSet = null;
        try
        {
            dtConnection = this.dataSource.getConnection();

            String propLangQuery = "select propvalue from maxpropvalue where servername = 'COMMON' and propname = ?";

            propValueStatement = dtConnection.prepareStatement(propLangQuery);
            propValueStatement.setString(1, "setting.YES_" + languageCode.toUpperCase());

            if (this.sqlLogger.isInfoEnabled())
            {
                this.sqlLogger.info("DataSet [" + this.name + "]: " + propLangQuery);
                this.sqlLogger.info("DataSet [" + this.name + "] Bind index [1] = " + "setting.YES_" + languageCode.toUpperCase());
            }

            propValueResultSet = propValueStatement.executeQuery();
            MXReportScriptContext mxReportScriptContext;
            if (!propValueResultSet.next())
            {
                propValueResultSet.close();
                propValueStatement.close();

                String propQuery = "select propvalue from maxpropvalue where servername = 'COMMON' and propname = ?";

                propValueStatement = dtConnection.prepareStatement(propQuery);
                propValueStatement.setString(1, "setting.YES");

                if (this.sqlLogger.isInfoEnabled())
                {
                    this.sqlLogger.info("DataSet [" + this.name + "]: " + propQuery);
                    this.sqlLogger.info("DataSet [" + this.name + "] Bind index [1] = " + "setting.YES");
                }

                propValueResultSet = propValueStatement.executeQuery();
                if (!propValueResultSet.next())
                {
                    mxReportScriptContext = MXReportScriptContext.get();
                    return mxReportScriptContext.getDisplayYesValue();
                }
            }

            String translatedValue = propValueResultSet.getString("propvalue");
            return translatedValue;
        }
        catch (Exception ex)
        {
            if (this.sqlLogger.isErrorEnabled())
            {
                this.sqlLogger.info("DataSet [" + this.name + "]: " + ex.getMessage(), ex);
            }
        }
        finally
        {
            try {
                if (propValueResultSet != null) propValueResultSet.close();
            }
            catch (Exception ex) {
            }
            try { if (propValueStatement != null) propValueStatement.close();
            }
            catch (Exception ex)
            {
            }
        }
        MXReportScriptContext mxReportScriptContext = MXReportScriptContext.get();
        return mxReportScriptContext.getDisplayYesValue();
    }

    public String determineDisplayNoValue(String languageCode)
    {
        Connection dtConnection = null;
        PreparedStatement propValueStatement = null;
        ResultSet propValueResultSet = null;
        try
        {
            dtConnection = this.dataSource.getConnection();

            String propLangQuery = "select propvalue from maxpropvalue where servername = 'COMMON' and propname = ?";

            propValueStatement = dtConnection.prepareStatement(propLangQuery);
            propValueStatement.setString(1, "setting.NO_" + languageCode.toUpperCase());

            if (this.sqlLogger.isInfoEnabled())
            {
                this.sqlLogger.info("DataSet [" + this.name + "]: " + propLangQuery);
                this.sqlLogger.info("DataSet [" + this.name + "] Bind index [1] = " + "setting.NO_" + languageCode.toUpperCase());
            }

            propValueResultSet = propValueStatement.executeQuery();
            MXReportScriptContext mxReportScriptContext;
            if (!propValueResultSet.next())
            {
                propValueResultSet.close();
                propValueStatement.close();

                String propQuery = "select propvalue from maxpropvalue where servername = 'COMMON' and propname = ?";

                propValueStatement = dtConnection.prepareStatement(propQuery);
                propValueStatement.setString(1, "setting.NO");

                if (this.sqlLogger.isInfoEnabled())
                {
                    this.sqlLogger.info("DataSet [" + this.name + "]: " + propQuery);
                    this.sqlLogger.info("DataSet [" + this.name + "] Bind index [1] = " + "setting.NO");
                }

                propValueResultSet = propValueStatement.executeQuery();
                if (!propValueResultSet.next())
                {
                    mxReportScriptContext = MXReportScriptContext.get();
                    return mxReportScriptContext.getDisplayNoValue();
                }
            }

            String translatedValue = propValueResultSet.getString("propvalue");
            return translatedValue;
        }
        catch (Exception ex)
        {
            if (this.sqlLogger.isErrorEnabled())
            {
                this.sqlLogger.info("DataSet [" + this.name + "]: " + ex.getMessage(), ex);
            }
        }
        finally
        {
            try {
                if (propValueResultSet != null) propValueResultSet.close();
            }
            catch (Exception ex) {
            }
            try { if (propValueStatement != null) propValueStatement.close();
            }
            catch (Exception ex)
            {
            }
        }
        MXReportScriptContext mxReportScriptContext = MXReportScriptContext.get();
        return mxReportScriptContext.getDisplayNoValue();
    }

    public double getDouble(String attributeName)
    {
        try
        {
            double value = 0.0D;
            return this.resultSet.getDouble(attributeName);
        }
        catch (Exception ex)
        {
            if (this.logger.isErrorEnabled())
            {
                this.logger.error("getDouble(" + attributeName + ") failed.", ex);
            }

            MXReportScriptContext mxReportScriptContext = MXReportScriptContext.get();
            mxReportScriptContext.markReportFailed();
            throw new MXReportRuntimeException(ex);
        }
    }

    public Double getDoubleObject(String attributeName)
    {
        double d = getDouble(attributeName);
        return new Double(d);
    }

    public float getFloat(String attributeName)
    {
        try
        {
            float value = 0.0F;
            return this.resultSet.getFloat(attributeName);
        }
        catch (Exception ex)
        {
            if (this.logger.isErrorEnabled())
            {
                this.logger.error("getFloat(" + attributeName + ") failed.", ex);
            }

            MXReportScriptContext mxReportScriptContext = MXReportScriptContext.get();
            mxReportScriptContext.markReportFailed();
            throw new MXReportRuntimeException(ex);
        }
    }

    public Float getFloatObject(String attributeName)
    {
        float f = getFloat(attributeName);
        return new Float(f);
    }

    public int getInteger(String attributeName)
    {
        try
        {
            int value = 0;
            return this.resultSet.getInt(attributeName);
        }
        catch (Exception ex)
        {
            if (this.logger.isErrorEnabled())
            {
                this.logger.error("getInteger(" + attributeName + ") failed.", ex);
            }

            MXReportScriptContext mxReportScriptContext = MXReportScriptContext.get();
            mxReportScriptContext.markReportFailed();
            throw new MXReportRuntimeException(ex);
        }
    }

    public String getDuration(String attributeName)
    {
        double d = getDouble(attributeName);
        return MXReportUtil.getDuration(d);
    }

    public String getDurationWithSeconds(String attributeName)
    {
        double d = getDouble(attributeName);
        return MXReportUtil.getDuration(d, 1);
    }

    public Integer getIntegerObject(String attributeName)
    {
        int i = getInteger(attributeName);
        return new Integer(i);
    }

    private String getTranslatedString(String attributeName, MXReportResultSet resultSet)
    {
        MXReportScriptContext mxReportScriptContext = MXReportScriptContext.get();
        String languageCode = mxReportScriptContext.getLanguageCode();
        if (languageCode == null)
        {
            return null;
        }

        Object obj = this.dataTranslationMap.get(attributeName.toLowerCase());
        if (obj == null)
        {
            return null;
        }

        Connection dtConnection = null;
        PreparedStatement langTableStatement = null;
        ResultSet langTableResultSet = null;
        try
        {
            DataTranslationInfo dtInfo = (DataTranslationInfo)obj;

            String queryUIDColumnName = dtInfo.getQueryUIDColumnName();
            String languageTableName = dtInfo.getLanguageTableName();
            String languageColumnName = dtInfo.getLanguageColumnName();
            String languageCodeColumnName = dtInfo.getLanguageCodeColumnName();

            String uid = resultSet.getString(queryUIDColumnName);

            dtConnection = this.dataSource.getConnection();

            String langQuery = "select " + languageColumnName + " from " + languageTableName + " where " + languageCodeColumnName + " = ? and ownerid = ?";

            langTableStatement = dtConnection.prepareStatement(langQuery);
            langTableStatement.setString(1, languageCode.toUpperCase());
            langTableStatement.setLong(2, new Long(uid).longValue());

            if (this.sqlLogger.isInfoEnabled())
            {
                this.sqlLogger.info("DataSet [" + this.name + "]: " + langQuery);
                this.sqlLogger.info("DataSet [" + this.name + "] Bind index [1] = " + languageCode.toUpperCase());
                this.sqlLogger.info("DataSet [" + this.name + "] Bind index [2] = " + uid);
            }

            langTableResultSet = langTableStatement.executeQuery();

            if (!langTableResultSet.next())
            {
                return null;
            }

            String translatedValue = langTableResultSet.getString(languageColumnName);
            return translatedValue;
        }
        catch (Exception ex)
        {
            if (this.sqlLogger.isErrorEnabled())
            {
                this.sqlLogger.info("DataSet [" + this.name + "]: " + ex.getMessage(), ex);
            }
        }
        finally
        {
            try {
                if (langTableResultSet != null) langTableResultSet.close();
            }
            catch (Exception ex) {
            }
            try { if (langTableStatement != null) langTableStatement.close();  } catch (Exception ex)
            {
            }
        }
        return null;
    }

    private boolean isAttributeRequireTranslatedData(String attributeName)
    {
        MXReportScriptContext mxReportScriptContext = MXReportScriptContext.get();
        String languageCode = mxReportScriptContext.getLanguageCode();
        if (languageCode == null)
        {
            return false;
        }

        Object obj = this.dataTranslationMap.get(attributeName.toLowerCase());

        if (obj == null)
        {
            return false;
        }

        return true;
    }

    public Timestamp getTimestamp(String attributeName)
    {
        try
        {
            return this.resultSet.getTimestamp(attributeName);
        }
        catch (Exception ex)
        {
            if (this.logger.isErrorEnabled())
            {
                this.logger.error("getTimestamp(" + attributeName + ") failed.", ex);
            }

            MXReportScriptContext mxReportScriptContext = MXReportScriptContext.get();
            mxReportScriptContext.markReportFailed();
            throw new MXReportRuntimeException(ex);
        }
    }

    public String getNullValueFunction(String param, String nullVal)
    {
        if (this.connection == null)
        {
            if (this.logger.isErrorEnabled())
            {
                this.logger.error("getNullValueFunction called without opening the dataset.");
            }

            return "#invalid#";
        }

        try
        {
            String dbProductName = this.connection.getMetaData().getDatabaseProductName();

            if (dbProductName.toUpperCase().indexOf("ORACLE") >= 0)
            {
                return "nvl(" + param + ", " + nullVal + ")";
            }
            if (dbProductName.toUpperCase().indexOf("MICROSOFT") >= 0)
            {
                return "isnull(" + param + ", " + nullVal + ")";
            }
            if (dbProductName.toUpperCase().indexOf("DB2") >= 0)
            {
                return "coalesce(" + param + ", " + nullVal + ")";
            }

            return "#invalid#";
        }
        catch (Throwable t)
        {
            if (this.logger.isErrorEnabled())
            {
                this.logger.error("getNullValueFunction failed.", t);
            }
        }
        return "#invalid#";
    }

    public String getDatabaseProductName()
    {
        try
        {
            return this.connection.getMetaData().getDatabaseProductName();
        }
        catch (Throwable t)
        {
            if (this.logger.isErrorEnabled())
            {
                this.logger.error("getDatabaseProductName failed.", t);
            }
        }
        return "#invalid#";
    }

    public boolean isOracle()
    {
        String dbProductName = getDatabaseProductName();
        if (dbProductName.toUpperCase().indexOf("ORACLE") >= 0)
        {
            return true;
        }

        return false;
    }

    public boolean isSQLServer()
    {
        String dbProductName = getDatabaseProductName();
        if (dbProductName.toUpperCase().indexOf("MICROSOFT") >= 0)
        {
            return true;
        }

        return false;
    }

    public boolean isDB2()
    {
        String dbProductName = getDatabaseProductName();
        if (dbProductName.toUpperCase().indexOf("DB2") >= 0)
        {
            return true;
        }

        return false;
    }

    public void registerDataTranslation(String queryColumnName, String queryUIDColumnName, String mboName, String mboAttributeName)
    {
        MXReportScriptContext mxReportScriptContext = MXReportScriptContext.get();
        String languageCode = mxReportScriptContext.getLanguageCode();
        if (languageCode == null)
        {
            return;
        }

        String languageTableName = null;
        String languageCodeColumnName = null;
        String languageColumnName = null;

        Connection dtConnection = null;

        Statement maxVarsStatement1 = null;
        ResultSet maxVarsResultSet1 = null;
        Statement maxVarsStatement2 = null;
        ResultSet maxVarsResultSet2 = null;

        PreparedStatement maxAttrStatement1 = null;
        ResultSet maxAttrResultSet1 = null;

        PreparedStatement maxObjStatement1 = null;
        ResultSet maxObjResultSet1 = null;

        PreparedStatement maxTableStatement1 = null;
        ResultSet maxTableResultSet1 = null;
        try
        {
            dtConnection = this.dataSource.getConnection();

            maxVarsStatement1 = dtConnection.createStatement();

            String mlSuppQuery = "select varvalue from maxvars where varname = 'MLSUPPORTED'";
            if (this.sqlLogger.isInfoEnabled())
            {
                this.sqlLogger.info("DataSet [" + this.name + "]: " + mlSuppQuery);
            }

            maxVarsResultSet1 = maxVarsStatement1.executeQuery(mlSuppQuery);
            if (!maxVarsResultSet1.next())
            {
                return;
            }

            String varValue = maxVarsResultSet1.getString("varvalue");
            if ((varValue == null) || (!varValue.equalsIgnoreCase("1")))
            {
                return;
            }

            if (this.logger.isDebugEnabled())
            {
                this.logger.debug("MLSUPPORTED = " + varValue);
            }

            maxVarsResultSet1.close();
            maxVarsResultSet1 = null;
            maxVarsStatement1.close();
            maxVarsStatement1 = null;

            maxVarsStatement2 = dtConnection.createStatement();

            String baseLangQuery = "select varvalue from maxvars where varname = 'BASELANGUAGE'";
            if (this.sqlLogger.isInfoEnabled())
            {
                this.sqlLogger.info("DataSet [" + this.name + "]: " + baseLangQuery);
            }

            maxVarsResultSet2 = maxVarsStatement2.executeQuery(baseLangQuery);
            if (!maxVarsResultSet2.next())
            {
                return;
            }

            String baseLanguageCode = maxVarsResultSet2.getString("varvalue");
            if ((baseLanguageCode == null) || (baseLanguageCode.equalsIgnoreCase(languageCode)))
            {
                return;
            }

            if (this.logger.isDebugEnabled())
            {
                this.logger.debug("BASELANGUAGE = " + baseLanguageCode);
            }

            maxVarsResultSet2.close();
            maxVarsResultSet2 = null;
            maxVarsStatement2.close();
            maxVarsStatement2 = null;

            String attrMLUseQuery = "select entityname, columnname  from maxattribute where objectname = ? and attributename = ? and mlinuse = 1";

            if (this.sqlLogger.isInfoEnabled())
            {
                this.sqlLogger.info("DataSet [" + this.name + "]: " + attrMLUseQuery);
                this.sqlLogger.info("DataSet [" + this.name + "] Bind index [1] = " + mboName.toUpperCase());
                this.sqlLogger.info("DataSet [" + this.name + "] Bind index [2] = " + mboAttributeName.toUpperCase());
            }

            maxAttrStatement1 = dtConnection.prepareStatement(attrMLUseQuery);
            maxAttrStatement1.setString(1, mboName.toUpperCase());
            maxAttrStatement1.setString(2, mboAttributeName.toUpperCase());

            maxAttrResultSet1 = maxAttrStatement1.executeQuery();
            if (!maxAttrResultSet1.next())
            {
                return;
            }

            String entityName = maxAttrResultSet1.getString("entityname");
            languageColumnName = maxAttrResultSet1.getString("columnname");

            if ((entityName == null) || (languageColumnName == null))
            {
                return;
            }

            maxAttrResultSet1.close();
            maxAttrResultSet1 = null;
            maxAttrStatement1.close();
            maxAttrStatement1 = null;

            String isViewQuery = "select isview from maxobject  where objectname = ? and entityname = ?";

            if (this.sqlLogger.isInfoEnabled())
            {
                this.sqlLogger.info("DataSet [" + this.name + "]: " + isViewQuery);
                this.sqlLogger.info("DataSet [" + this.name + "] Bind index [1] = " + mboName.toUpperCase());
                this.sqlLogger.info("DataSet [" + this.name + "] Bind index [2] = " + entityName);
            }

            maxObjStatement1 = dtConnection.prepareStatement(isViewQuery);
            maxObjStatement1.setString(1, mboName.toUpperCase());
            maxObjStatement1.setString(2, entityName);

            maxObjResultSet1 = maxObjStatement1.executeQuery();

            if (!maxObjResultSet1.next())
            {
                return;
            }

            String isViewS = maxObjResultSet1.getString("isview");
            if (isViewS == null)
            {
                return;
            }

            boolean isView = isViewS.equalsIgnoreCase("1");

            maxObjResultSet1.close();
            maxObjResultSet1 = null;
            maxObjStatement1.close();
            maxObjStatement1 = null;

            if (isView)
            {
                String maxTableQuery = "select langtablename, langcolumnname  from maxtable where tablename = (select tablename from maxviewcolumn  where viewname = ? and viewcolumnname = ?)";

                if (this.sqlLogger.isInfoEnabled())
                {
                    this.sqlLogger.info("DataSet [" + this.name + "]: " + maxTableQuery);
                    this.sqlLogger.info("DataSet [" + this.name + "] Bind index [1] = " + entityName);
                    this.sqlLogger.info("DataSet [" + this.name + "] Bind index [2] = " + languageColumnName);
                }

                maxTableStatement1 = dtConnection.prepareStatement(maxTableQuery);
                maxTableStatement1.setString(1, entityName);
                maxTableStatement1.setString(2, languageColumnName);

                maxTableResultSet1 = maxTableStatement1.executeQuery();
                if (!maxTableResultSet1.next())
                {
                    return;
                }

                languageTableName = maxTableResultSet1.getString("langtablename");
                languageCodeColumnName = maxTableResultSet1.getString("langcolumnname");

                maxTableResultSet1.close();
                maxTableResultSet1 = null;
                maxTableStatement1.close();
                maxTableStatement1 = null;
            }
            else
            {
                String maxTableQuery = "select langtablename, langcolumnname  from maxtable where tablename = ?";

                if (this.sqlLogger.isInfoEnabled())
                {
                    this.sqlLogger.info("DataSet [" + this.name + "]: " + maxTableQuery);
                    this.sqlLogger.info("DataSet [" + this.name + "] Bind index [1] = " + entityName);
                }

                maxTableStatement1 = dtConnection.prepareStatement(maxTableQuery);
                maxTableStatement1.setString(1, entityName);

                maxTableResultSet1 = maxTableStatement1.executeQuery();
                if (!maxTableResultSet1.next())
                {
                    return;
                }

                languageTableName = maxTableResultSet1.getString("langtablename");
                languageCodeColumnName = maxTableResultSet1.getString("langcolumnname");

                maxTableResultSet1.close();
                maxTableResultSet1 = null;
                maxTableStatement1.close();
                maxTableStatement1 = null;
            }

            if (this.logger.isDebugEnabled())
            {
                this.logger.debug("DataSet [" + this.name + "] languageTableName = " + languageTableName);
                this.logger.debug("DataSet [" + this.name + "] languageCodeColumnName = " + languageCodeColumnName);
                this.logger.debug("DataSet [" + this.name + "] languageColumnName = " + languageColumnName);
            }

        }
        catch (Exception ex)
        {
            if (this.logger.isErrorEnabled())
            {
                this.logger.error("registerDataTranslation(" + queryColumnName + ", " + queryUIDColumnName + ", " + mboName + ", " + mboAttributeName + ") failed.", ex);
            }

            return;
        }
        finally
        {
            try {
                if (maxVarsResultSet1 != null) maxVarsResultSet1.close();
            }
            catch (Exception ex) {
            }
            try { if (maxVarsStatement1 != null) maxVarsStatement1.close();  } catch (Exception ex)
            {
            }
            try {
                if (maxVarsResultSet2 != null) maxVarsResultSet2.close();
            }
            catch (Exception ex) {
            }
            try { if (maxVarsStatement2 != null) maxVarsStatement2.close();  } catch (Exception ex)
            {
            }
            try {
                if (maxAttrResultSet1 != null) maxAttrResultSet1.close();
            }
            catch (Exception ex) {
            }
            try { if (maxAttrStatement1 != null) maxAttrStatement1.close();  } catch (Exception ex)
            {
            }
            try {
                if (maxObjResultSet1 != null) maxObjResultSet1.close();
            }
            catch (Exception ex) {
            }
            try { if (maxObjStatement1 != null) maxObjStatement1.close();  } catch (Exception ex)
            {
            }
            try {
                if (maxTableResultSet1 != null) maxTableResultSet1.close();
            }
            catch (Exception ex) {
            }
            try { if (maxTableStatement1 != null) maxTableStatement1.close();  } catch (Exception ex)
            {
            }
        }
        DataTranslationInfo dtInfo = new DataTranslationInfo();
        dtInfo.setQueryColumnName(queryColumnName.toLowerCase());
        dtInfo.setQueryUIDColumnName(queryUIDColumnName.toLowerCase());
        dtInfo.setMboName(mboName);
        dtInfo.setMboAttributeName(mboAttributeName);
        dtInfo.setLanguageTableName(languageTableName);
        dtInfo.setLanguageColumnName(languageColumnName);
        dtInfo.setLanguageCodeColumnName(languageCodeColumnName);

        this.dataTranslationMap.put(queryColumnName.toLowerCase(), dtInfo); }
    class DataTranslationInfo { private String queryColumnName;
        private String queryUIDColumnName;
        private String mboName;
        private String mboAttributeName;
        private String languageTableName;
        private String languageColumnName;
        private String languageCodeColumnName;

        DataTranslationInfo() {  }
        public String getQueryColumnName() { return this.queryColumnName; }


        public void setQueryColumnName(String queryColumnName)
        {
            this.queryColumnName = queryColumnName;
        }

        public String getQueryUIDColumnName()
        {
            return this.queryUIDColumnName;
        }

        public void setQueryUIDColumnName(String queryUIDColumnName)
        {
            this.queryUIDColumnName = queryUIDColumnName;
        }

        public String getMboAttributeName()
        {
            return this.mboAttributeName;
        }

        public void setMboAttributeName(String mboAttributeName)
        {
            this.mboAttributeName = mboAttributeName;
        }

        public String getMboName()
        {
            return this.mboName;
        }

        public void setMboName(String mboName)
        {
            this.mboName = mboName;
        }

        public String getLanguageColumnName()
        {
            return this.languageColumnName;
        }

        public void setLanguageColumnName(String languageColumnName)
        {
            this.languageColumnName = languageColumnName;
        }

        public String getLanguageTableName()
        {
            return this.languageTableName;
        }

        public void setLanguageTableName(String languageTableName)
        {
            this.languageTableName = languageTableName;
        }

        public String getLanguageCodeColumnName()
        {
            return this.languageCodeColumnName;
        }

        public void setLanguageCodeColumnName(String languageCodeColumnname)
        {
            this.languageCodeColumnName = languageCodeColumnname;
        }
    }
}
