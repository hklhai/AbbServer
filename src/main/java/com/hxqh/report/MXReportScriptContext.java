 package com.hxqh.report;

 import com.hxqh.report.logging.DefaultReportLogger;
 import com.hxqh.report.logging.ReportLogger;
 import com.hxqh.report.logging.ReportLoggerImpl;

 import java.io.IOException;
 import java.io.InputStream;
 import java.lang.reflect.Method;
 import java.util.*;


 public class MXReportScriptContext
 {
   private static final String HTTPREQUEST = "HTTPREQUEST";
   private static final String MXREPORTCONTEXT = "MXREPORTCONTEXT";
   private static final String REPORT_SCRIPTLOGGER = "com.bjhxqh.main.report.birt.logger.script";
   private static final String REPORT_SCRIPTSQLLOGGER = "com.bjhxqh.main.report.birt.logger.script.sql";
   private static final String REPORT_LANGCODE = "com.bjhxqh.main.report.birt.langcode";
   private static final String REPORT_LOCALE = "com.bjhxqh.main.report.birt.locale";
   private static final String REPORT_TIMEZONE = "com.bjhxqh.main.report.birt.timezone";
   private static final String REPORT_DISPLAY_YES = "com.bjhxqh.main.report.birt.display.yes";
   private static final String REPORT_DISPLAY_NO = "com.bjhxqh.main.report.birt.display.no";
   private static final String REPORT_MODE = "com.bjhxqh.main.report.birt.mode";
   private static final String REPORT_USER_DATE = "com.bjhxqh.main.report.birt.userdate";
   private static final String REPORT_MODE_IMMEDIATE = "IMMEDIATE";
   private static final String REPORT_MODE_SCHEDULE = "SCHEDULE";
   private static final int REPORT_MODE_DESIGN = 0;
   private static final int REPORT_MODE_RUNTIME_IMMEDIATE = 1;
   private static final int REPORT_MODE_RUNTIME_SCHEDULE = 2;
   private static final Map EMPTYMAP = new HashMap();
 
   private Object birtReportContext = null;
   private Map birtAppContext = null;
 
   private Map contextData = new HashMap();
 
   private Map mxReportContext = null;
 
   private ReportLogger reportScriptLogger = null;
 
   private ReportLogger reportScriptSqlLogger = null;
 
   private DefaultReportLogger defaultReportLogger = new DefaultReportLogger();
 
   private HashMap dataSourceInfoMap = null;
 
   private Integer reportMode = null;
 
   private Long reportJobId = null;
 
   private boolean closeCalled = false;
 
   private boolean renderPhaseInitCalled = false;
 
   private static MXReportThreadLocalContext mxReportThreadLocalContext = new MXReportThreadLocalContext();

   public static MXReportScriptContext initialize(Object birtReportContext)
   {
     MXReportScriptContext mxReportScriptContext = get();

     mxReportScriptContext.birtReportContext = null;
     mxReportScriptContext.birtAppContext = null;

     mxReportScriptContext.contextData = new HashMap();

     mxReportScriptContext.mxReportContext = null;

     mxReportScriptContext.reportScriptLogger = null;

     mxReportScriptContext.reportScriptSqlLogger = null;

     mxReportScriptContext.defaultReportLogger = new DefaultReportLogger();

     mxReportScriptContext.dataSourceInfoMap = null;

     mxReportScriptContext.reportMode = null;

     mxReportScriptContext.setBirtReportContext(birtReportContext);

     Integer taskType = (Integer)callMethod(birtReportContext, "getTaskType", new Class[0], new Object[0]);

     if ((taskType != null) && (taskType.intValue() == 2))
     {
       mxReportScriptContext.closeCalled = false;
       return mxReportScriptContext;
     }

     if (mxReportScriptContext.isRuntimeImmediateMode())
     {
       Map mxReportContextMap = mxReportScriptContext.getMXReportContext();
       Object obj = mxReportContextMap.get("ACTIVEREPORTTHREADNOTIFIER");
       if (obj != null)
       {
         try
         {
           Method getAddActiveThreadMethod = obj.getClass().getMethod("addActiveThread", new Class[0]);

           Long reportJobId = (Long)getAddActiveThreadMethod.invoke(obj, new Object[0]);
           mxReportScriptContext.setReportJobId(reportJobId);
         } catch (Exception ex) {
         }
       }
     }
     else if (mxReportScriptContext.isRuntimeScheduleMode())
     {
       Map mxReportContextMap = mxReportScriptContext.getMXReportContext();
       Object obj = mxReportContextMap.get("REPORTJOBID");
       Long reportJobId = (Long)obj;
       mxReportScriptContext.setReportJobId(reportJobId);
     }

     if (!mxReportScriptContext.isDesignMode())
     {
       Map mxReportContextMap = mxReportScriptContext.getMXReportContext();
       Object obj = mxReportContextMap.get("USAGELOGNOTIFIER");
       if (obj != null)
       {
         try
         {
           Method setReportExecutedMethod = obj.getClass().getMethod("setReportExecuted", new Class[0]);

           setReportExecutedMethod.invoke(obj, new Object[0]);
         } catch (Exception ex) {
         }
       }
     }
     mxReportScriptContext.applyDataRestriction();

     mxReportScriptContext.closeCalled = false;

     return mxReportScriptContext;
   }

   public static void close()
   {
     MXReportScriptContext mxReportScriptContext = get();
     if (mxReportScriptContext != null)
     {
       mxReportScriptContext.closeCalled = true;

       MXReportDataSetProvider.clearDataSources();
       mxReportScriptContext.defaultReportLogger.close();
 
       if (mxReportScriptContext.isRuntimeImmediateMode())
       {
         Map mxReportContextMap = mxReportScriptContext.getMXReportContext();
         Object obj = mxReportContextMap.get("ACTIVEREPORTTHREADNOTIFIER");
         if (obj != null)
         {
           try
           {
             Method getAddActiveThreadMethod = obj.getClass().getMethod("removeActiveThread", new Class[0]);
 
             getAddActiveThreadMethod.invoke(obj, new Object[0]);
           } catch (Exception ex) {
           }
         }
       }
       if (mxReportScriptContext.isRuntimeImmediateMode())
       {
         Map mxReportContextMap = mxReportScriptContext.getMXReportContext();
         Object obj = mxReportContextMap.get("USAGELOGNOTIFIER");
         if (obj != null)
         {
           try
           {
             Method createUsageLogMethod = obj.getClass().getMethod("createUsageLog", new Class[0]);
 
             createUsageLogMethod.invoke(obj, new Object[0]);
           }
           catch (Exception ex)
           {
           }
 
         }
 
       }
 
       mxReportScriptContext.birtReportContext = null;
       mxReportScriptContext.birtAppContext = null;
 
       mxReportScriptContext.contextData = new HashMap();
 
       mxReportScriptContext.mxReportContext = null;
 
       mxReportScriptContext.reportScriptLogger = null;
 
       mxReportScriptContext.reportScriptSqlLogger = null;
 
       mxReportScriptContext.defaultReportLogger = new DefaultReportLogger();
 
       mxReportScriptContext.dataSourceInfoMap = null;
 
       mxReportScriptContext.reportMode = null;
     }
   }
 
   public static MXReportScriptContext get()
   {
     MXReportScriptContext mxReportScriptContext = MXReportThreadLocalContext.get();
 
     return mxReportScriptContext;
   }
 
   private void setBirtReportContext(Object birtReportContext)
   {
     this.birtReportContext = birtReportContext;
   }
 
   public Object getBirtReportContext()
   {
     return this.birtReportContext;
   }
 
   public Map getDataSourceInfo(String name)
   {
     String reqDataSource = name;
     getReportScriptLogger().debug("*Requested Data Source: " + reqDataSource);
 
     if (this.dataSourceInfoMap == null)
     {
       loadDataSourceInfo(name);
     }
 
     int index = name.indexOf(".");
     if (index > 0)
     {
       name = name.substring(index + 1);
     }
     getReportScriptLogger().debug("*Checking for Data Source: " + name);
 
     if (this.dataSourceInfoMap != null)
     {
       HashMap dsInfo = (HashMap)this.dataSourceInfoMap.get(name);
 
       if (dsInfo == null)
       {
         return EMPTYMAP;
       }
 
       Iterator dsIterator = this.dataSourceInfoMap.keySet().iterator();
       while (dsIterator.hasNext())
       {
         String nameX = (String)dsIterator.next();
         getReportScriptLogger().debug("loaded Data Source: " + nameX);
       }
 
       return dsInfo;
     }
 
     return EMPTYMAP;
   }
 
   public Map getAppContext()
   {
     if (this.birtAppContext != null)
     {
       return this.birtAppContext;
     }
 
     try
     {
       Method m = this.birtReportContext.getClass().getMethod("getAppContext", new Class[0]);
       this.birtAppContext = ((Map)m.invoke(this.birtReportContext, new Object[0]));
 
       return this.birtAppContext;
     }
     catch (Exception e) {
     }
     return new HashMap();
   }
 
   private Object getHttpRequest()
   {
     Object obj = this.contextData.get("HTTPREQUEST");
     if (obj != null)
     {
       return obj;
     }
 
     try
     {
       Method m = this.birtReportContext.getClass().getMethod("getHttpServletRequest", new Class[0]);
       Object httpRequest = m.invoke(this.birtReportContext, new Object[0]);
 
       this.contextData.put("HTTPREQUEST", httpRequest);
 
       return httpRequest;
     }
     catch (Exception ex) {
     }
     return null;
   }
 
   private Object getHttpRequestAttribute(String attributeName)
   {
     Object httpRequest = getHttpRequest();
     if (httpRequest == null)
     {
       return null;
     }
 
     try
     {
       Method m1 = httpRequest.getClass().getMethod("getAttribute", new Class[] { String.class });
       return m1.invoke(httpRequest, new Object[] { attributeName });
     }
     catch (Exception ex)
     {
     }
     return null;
   }
 
   private Object getHttpRequestParameter(String parameterName)
   {
     Object httpRequest = getHttpRequest();
     if (httpRequest == null)
     {
       return null;
     }
 
     try
     {
       Method m1 = httpRequest.getClass().getMethod("getParameter", new Class[] { String.class });
       return m1.invoke(httpRequest, new Object[] { parameterName });
     }
     catch (Exception ex)
     {
     }
     return null;
   }
 
   public Object getHttpSessionAttribute(String attributeName)
   {
     Object httpRequest = getHttpRequest();
     if (httpRequest == null)
     {
       return null;
     }
 
     try
     {
       Method m1 = httpRequest.getClass().getMethod("getSession", new Class[0]);
       Object sessionObj = m1.invoke(httpRequest, new Object[0]);
 
       Method m2 = sessionObj.getClass().getMethod("getAttribute", new Class[] { String.class });
       return m2.invoke(sessionObj, new Object[] { attributeName });
     }
     catch (Exception ex)
     {
     }
 
     return null;
   }
 
   public void removeHttpSessionAttribute(String attributeName)
   {
     Object httpRequest = getHttpRequest();
     if (httpRequest == null)
     {
       return;
     }
 
     try
     {
       Method m1 = httpRequest.getClass().getMethod("getSession", new Class[0]);
       Object sessionObj = m1.invoke(httpRequest, new Object[0]);
 
       Method m2 = sessionObj.getClass().getMethod("removeAttribute", new Class[] { String.class });
       Object sessionAttrValue = m2.invoke(sessionObj, new Object[] { attributeName });
 
       return;
     }
     catch (Exception ex)
     {
     }
   }
 
   public Map getMXReportContext()
   {
     if (this.birtReportContext == null)
     {
       return EMPTYMAP;
     }
 
     if ((this.mxReportContext != null) && (this.mxReportContext.size() > 0))
     {
       return this.mxReportContext;
     }
     this.contextData = new HashMap();
     Map mxRepContext = null;
 
     mxRepContext = (Map)getAppContext().get("MXREPORTCONTEXT");
     if (mxRepContext == null)
     {
       mxRepContext = (Map)getHttpRequestAttribute("MXREPORTCONTEXT");
       if (mxRepContext == null)
       {
         mxRepContext = EMPTYMAP;
       }
     }
 
     this.mxReportContext = mxRepContext;
 
     return mxRepContext;
   }
 
   public ReportLogger getReportScriptLogger()
   {
     if (this.birtReportContext == null)
     {
       return this.defaultReportLogger;
     }
 
     if (this.reportScriptLogger != null)
     {
       return this.reportScriptLogger;
     }
 
     this.reportScriptLogger = this.defaultReportLogger;
 
     Map mxRepContext = getMXReportContext();
 
     Object mxLogger = mxRepContext.get("com.ibm.tivoli.maximo.report.birt.logger.script");
     if (mxLogger != null)
     {
       this.reportScriptLogger = new ReportLoggerImpl(mxLogger);
     }
 
     return this.reportScriptLogger;
   }
 
   public ReportLogger getReportScriptSqlLogger()
   {
     if (this.birtReportContext == null)
     {
       return this.defaultReportLogger;
     }
 
     if (this.reportScriptSqlLogger != null)
     {
       return this.reportScriptSqlLogger;
     }
 
     this.reportScriptSqlLogger = this.defaultReportLogger;
 
     Map mxRepContext = getMXReportContext();
 
     Object mxLogger = mxRepContext.get("com.ibm.tivoli.maximo.report.birt.logger.script.sql");
     if (mxLogger != null)
     {
       this.reportScriptSqlLogger = new ReportLoggerImpl(mxLogger);
     }
 
     return this.reportScriptSqlLogger;
   }
 
   public String getDisplayYesValue()
   {
     Map mxRepContext = getMXReportContext();
 
     String displayYesValue = (String)mxRepContext.get("com.ibm.tivoli.maximo.report.birt.display.yes");
 
     if (displayYesValue == null)
     {
       displayYesValue = "Y";
     }
 
     return displayYesValue;
   }
 
   String getDisplayNoValue()
   {
     Map mxRepContext = getMXReportContext();
 
     String displayNoValue = (String)mxRepContext.get("com.ibm.tivoli.maximo.report.birt.display.no");
 
     if (displayNoValue == null)
     {
       displayNoValue = "N";
     }
 
     return displayNoValue;
   }
 
   String getLanguageCode()
   {
     Map mxRepContext = getMXReportContext();
 
     String langCode = (String)mxRepContext.get("com.ibm.tivoli.maximo.report.birt.langcode");
 
     if (langCode == null)
     {
       langCode = Locale.getDefault().getLanguage();
     }
 
     return langCode.toUpperCase();
   }
 
   public Locale getLocale()
   {
     Map mxRepContext = getMXReportContext();
 
     Locale locale = (Locale)mxRepContext.get("com.ibm.tivoli.maximo.report.birt.locale");
 
     if (locale == null)
     {
       locale = Locale.getDefault();
     }
 
     return locale;
   }
 
   public TimeZone getTimeZone()
   {
     Map mxRepContext = getMXReportContext();
 
     TimeZone tz = (TimeZone)mxRepContext.get("com.ibm.tivoli.maximo.report.birt.timezone");
 
     if (tz == null)
     {
       tz = TimeZone.getDefault();
     }
 
     return tz;
   }
 
   public String getTimeZoneDisplayName()
   {
     TimeZone tz = getTimeZone();
 
     Locale l = getLocale();
 
     String displayName = tz.getDisplayName(l);
 
     return displayName;
   }
 
   public String getUserDate()
   {
     Map mxRepContext = getMXReportContext();
 
     String userDate = (String)mxRepContext.get("com.ibm.tivoli.maximo.report.birt.userdate");
 
     return userDate;
   }
 
   public void setDefaultLogLevel(String level)
   {
     this.defaultReportLogger.setLogLevel(level);
   }
 
   public void setDefaultLogFile(String fileName)
   {
     this.defaultReportLogger.setLogFileName(fileName);
   }

   private void loadDataSourceInfo(String name){
     if (this.dataSourceInfoMap != null)
     {
       return;
     }
     this.dataSourceInfoMap = new HashMap();
     HashMap hs = (HashMap)ReportDataSourceUtil.getDateSouceMap();
     if(hs.size()>0){
       dataSourceInfoMap.put(name,hs);
     }
     //loadDataSourceInfo();
   }
 
   private void loadDataSourceInfo()
   {
     InputStream is = getClass().getResourceAsStream("/config.properties");
     if (is == null)
     {
       return;
     }
 
     if (this.dataSourceInfoMap != null)
     {
       return;
     }
 
     getReportScriptLogger().info("Using MXReportdatasources.properties file to load Data Sources");
 
     Properties dsProperties = new Properties();
     try
     {
       dsProperties.load(is);
 
       this.dataSourceInfoMap = new HashMap();
 
       Enumeration keyEnum = dsProperties.keys();
       while (keyEnum.hasMoreElements())
       {
         String key = (String)keyEnum.nextElement();
         int dotIndex = key.lastIndexOf(".");
         if (dotIndex > 0)
         {
           String dataSourceName = key.substring(0, dotIndex).trim();
           String propertyName = key.substring(dotIndex + 1).trim();
           String value = dsProperties.getProperty(key).trim();
 
           getReportScriptLogger().info("Adding Data Source: " + dataSourceName);
 
           addDataSourceInfo(this.dataSourceInfoMap, dataSourceName, propertyName, value);
         }
       }
     }
     catch (Exception ex)
     {
       if (getReportScriptLogger().isErrorEnabled())
       {
         getReportScriptLogger().error("Failed to load the mxdatasources.properties information", ex);
       }
     }
   }
 
   private void addDataSourceInfo(HashMap dsInfoMap, String dataSourceName, String property, String value)
   {
     Object obj = dsInfoMap.get(dataSourceName);
     if (obj == null)
     {
       obj = new HashMap();
       dsInfoMap.put(dataSourceName, obj);
     }
 
     HashMap dsInfo = (HashMap)obj;
 
     dsInfo.put(property, value);
   }
 
   public boolean isDesignMode()
   {
     if (this.reportMode != null)
     {
       if (this.reportMode.intValue() == 0)
       {
         return true;
       }
 
       return false;
     }
 
     Map mxReportContext = getMXReportContext();
 
     Object reportMode = mxReportContext.get("com.ibm.tivoli.maximo.report.birt.mode");
 
     if (reportMode == null)
     {
       reportMode = new Integer(0);
       return true;
     }
 
     return false;
   }
 
   public boolean isRuntimeImmediateMode()
   {
     if (this.reportMode != null)
     {
       if (this.reportMode.intValue() == 1)
       {
         return true;
       }
 
       return false;
     }
 
     Map mxReportContext = getMXReportContext();
 
     Object reportMode = mxReportContext.get("com.ibm.tivoli.maximo.report.birt.mode");
 
     if (reportMode == null)
     {
       reportMode = new Integer(0);
       return false;
     }
 
     String reportRuntimeMode = (String)reportMode;
     if (reportRuntimeMode.equalsIgnoreCase("IMMEDIATE"))
     {
       reportMode = new Integer(1);
       return true;
     }
 
     return false;
   }
 
   public boolean isRuntimeScheduleMode()
   {
     if (this.reportMode != null)
     {
       if (this.reportMode.intValue() == 2)
       {
         return true;
       }
 
       return false;
     }
 
     Map mxReportContext = getMXReportContext();
 
     Object reportMode = mxReportContext.get("com.ibm.tivoli.maximo.report.birt.mode");
 
     if (reportMode == null)
     {
       reportMode = new Integer(0);
       return false;
     }
 
     String reportRuntimeMode = (String)reportMode;
     if (reportRuntimeMode.equalsIgnoreCase("SCHEDULE"))
     {
       reportMode = new Integer(2);
       return true;
     }
 
     return false;
   }
 
   public void renewActiveThread()
   {
     MXReportScriptContext mxReportScriptContext = get();
     if (!mxReportScriptContext.isDesignMode())
     {
       Map mxReportContextMap = mxReportScriptContext.getMXReportContext();
       Object obj = mxReportContextMap.get("ACTIVEREPORTTHREADNOTIFIER");
       if (obj != null)
       {
         try
         {
           Method getAddActiveThreadMethod = obj.getClass().getMethod("renewActiveThread", new Class[0]);
 
           getAddActiveThreadMethod.invoke(obj, new Object[0]);
         } catch (Exception ex) {
         }
       }
     }
   }
 
   public void markReportFailed() {
     MXReportScriptContext mxReportScriptContext = get();
     if (!mxReportScriptContext.isDesignMode())
     {
       Map mxReportContextMap = mxReportScriptContext.getMXReportContext();
       Object obj = mxReportContextMap.get("USAGELOGNOTIFIER");
       if (obj != null)
       {
         try
         {
           Method setReportFailedMethod = obj.getClass().getMethod("setReportFailed", new Class[0]);
 
           setReportFailedMethod.invoke(obj, new Object[0]);
         }
         catch (Exception ex) {
         }
       }
     }
   }
 
   private void applyDataRestriction() {
     MXReportScriptContext mxReportScriptContext = get();
     Map mxReportContextMap = mxReportScriptContext.getMXReportContext();
     Object obj = mxReportContextMap.get("DATARESTRICTIONPROVIDER");
     if (obj != null)
     {
       try
       {
         Method getDataRestrictionWhereMethod = obj.getClass().getMethod("getDataRestrictionWhere", new Class[0]);
 
         String dataRestriction = (String)getDataRestrictionWhereMethod.invoke(obj, new Object[0]);
 
         if ((dataRestriction == null) || (dataRestriction.trim().length() == 0))
         {
           return;
         }
 
         Method m = this.birtReportContext.getClass().getMethod("getParameterValue", new Class[] { String.class });
         String paramWhere = (String)m.invoke(this.birtReportContext, new Object[] { "where" });
 
         if ((paramWhere == null) || (paramWhere.trim().length() == 0))
         {
           Method m1 = this.birtReportContext.getClass().getMethod("setParameterValue", new Class[] { String.class, Object.class });
           m1.invoke(this.birtReportContext, new Object[] { "where", dataRestriction });
         }
         else
         {
           String newDataRestriction = null;
 
           if (paramWhere.indexOf(dataRestriction) >= 0)
           {
             newDataRestriction = paramWhere;
           }
           else if (paramWhere.trim().equalsIgnoreCase("1=1"))
           {
             newDataRestriction = dataRestriction;
           }
           else
           {
             newDataRestriction = paramWhere + " and (" + dataRestriction + ")";
           }
 
           Method m1 = this.birtReportContext.getClass().getMethod("setParameterValue", new Class[] { String.class, Object.class });
           m1.invoke(this.birtReportContext, new Object[] { "where", newDataRestriction });
         }
       }
       catch (Exception ex)
       {
       }
     }
   }
 
   public boolean isReportJobCancelled()
   {
     MXReportScriptContext mxReportScriptContext = get();
     if (!mxReportScriptContext.isDesignMode())
     {
       try
       {
         String key = (String)getMXReportContext().get("REPORTRUNINFOKEY");
         Object objRunInfo = getHttpSessionAttribute(key);
         if (objRunInfo != null)
         {
           Method m = objRunInfo.getClass().getMethod("isCancelled", new Class[0]);
           Boolean isCancelled = (Boolean)m.invoke(objRunInfo, new Object[0]);
           if (isCancelled.booleanValue())
           {
             return true;
           }
         }
       }
       catch (Exception ex)
       {
         ex.printStackTrace();
       }
 
       Map mxReportContextMap = mxReportScriptContext.getMXReportContext();
       Object obj = mxReportContextMap.get("ACTIVEREPORTTHREADNOTIFIER");
       if (obj != null)
       {
         try
         {
           Method getAddActiveThreadMethod = obj.getClass().getMethod("isReportJobCancelled", new Class[] { Long.class });
 
           Boolean isCancelled = (Boolean)getAddActiveThreadMethod.invoke(obj, new Object[] { getReportJobId() });
           return isCancelled.booleanValue();
         }
         catch (Exception ex)
         {
         }
       }
 
     }
 
     return false;
   }
 
   public Long getReportJobId()
   {
     if (this.reportJobId == null)
     {
       return new Long(0L);
     }
 
     return this.reportJobId;
   }
 
   public void setReportJobId(Long reportJobId)
   {
     this.reportJobId = reportJobId;
   }
 
   public void cancelReportJob()
   {
     MXReportScriptContext mxReportScriptContext = get();
     if (!mxReportScriptContext.isDesignMode())
     {
       Map mxReportContextMap = mxReportScriptContext.getMXReportContext();
       Object obj = mxReportContextMap.get("ACTIVEREPORTTHREADNOTIFIER");
       if (obj != null)
       {
         try
         {
           Method getAddActiveThreadMethod = obj.getClass().getMethod("cancelReportJob", new Class[] { Long.class });
 
           getAddActiveThreadMethod.invoke(obj, new Object[] { getReportJobId() });
         }
         catch (Exception ex)
         {
         }
 
       }
 
       Object objUsageLogNotifier = mxReportContextMap.get("USAGELOGNOTIFIER");
       if (objUsageLogNotifier != null)
       {
         try
         {
           Method setReportFailedMethod = objUsageLogNotifier.getClass().getMethod("setReportCancelled", new Class[0]);
 
           setReportFailedMethod.invoke(objUsageLogNotifier, new Object[0]);
         }
         catch (Exception ex)
         {
         }
       }
     }
   }
 
   private static Object callMethod(Object obj, String methodName, Class[] paramTypeArray, Object[] paramArray)
   {
     Object retValue = null;
     try
     {
       Method method = obj.getClass().getMethod(methodName, paramTypeArray);
       retValue = method.invoke(obj, paramArray);
     }
     catch (Exception e)
     {
       System.out.println(e);
       e.printStackTrace();
       ReportLogger rptLogger = get().getReportScriptLogger();
       if (rptLogger != null)
       {
         rptLogger.error("Error while calling " + obj.getClass().getName() + "." + methodName, e);
       }
     }
     return retValue;
   }
 }

