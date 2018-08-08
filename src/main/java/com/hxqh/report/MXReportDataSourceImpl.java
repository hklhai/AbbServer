package com.hxqh.report;

import com.hxqh.report.logging.ReportLogger;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Map;


public class MXReportDataSourceImpl
implements MXReportDataSource
{
	private String name = null;
	private boolean initialized = false;
	private String url;
	private String driver;
	private String userName;
	private String password;
	private Connection connection = null;

	private boolean runtimeDataSourceInUse = false;
	private Object runtimeDataSourceObject = null;
	private Object runtimeDataSourceConnection = null;

	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public boolean isInitialized()
	{
		return this.initialized;
	}

	public void setInitialized(boolean initialized)
	{
		this.initialized = initialized;
	}

	public String getDriver()
	{
		return this.driver;
	}

	public void setDriver(String driver)
	{
		this.driver = driver;
	}

	public String getPassword()
	{
		return this.password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getUrl()
	{
		return this.url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}

	public String getUserName()
	{
		return this.userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public MXReportDataSet getDataSet(String name)
	{
		MXReportDataSetImpl ds = new MXReportDataSetImpl(this);
		ds.setName(name);

		return ds;
	}

	public Connection getConnection()
			throws Exception
			{
		if (this.connection != null)
		{
			return this.connection;
		}

		MXReportScriptContext mxReportScriptContext = MXReportScriptContext.get();
		ReportLogger logger = mxReportScriptContext.getReportScriptLogger();

		if (logger.isInfoEnabled())
		{
			logger.info("DataSource [" + this.name + "] getConnection called");
			logger.info("DataSource MXReportScriptContext = " + mxReportScriptContext);
		}

		Map mxReportContextMap = mxReportScriptContext.getMXReportContext();
		Object obj = mxReportContextMap.get("REPORTDATASOURCEPROVIDER");
		if (obj != null)
		{
			this.runtimeDataSourceInUse = true;
		}

		if (this.runtimeDataSourceInUse)
		{
			this.connection = getRuntimeConnection();
		}
		else
		{
			this.connection = getDesigntimeConnection();
		}
		if (logger.isInfoEnabled())
		{
			logger.info("DataSource [" + this.name + "] is connected to the URL " + this.connection.getMetaData().getURL());
		}
		return this.connection;
			}

	private Connection getRuntimeConnection() throws Exception
	{
		MXReportScriptContext mxReportScriptContext = MXReportScriptContext.get();
		ReportLogger logger = mxReportScriptContext.getReportScriptLogger();

		Map mxReportContextMap = mxReportScriptContext.getMXReportContext();
		Object obj = mxReportContextMap.get("REPORTDATASOURCEPROVIDER");

		Method getDSMethod = obj.getClass().getMethod("getDataSource", new Class[] { String.class });

		Object dsObj = getDSMethod.invoke(obj, new Object[] { getName() });
		this.runtimeDataSourceObject = dsObj;

		Method getDSConMethod = dsObj.getClass().getMethod("getNewConnection", new Class[0]);

		Object dsConnection = getDSConMethod.invoke(dsObj, new Object[0]);
		this.runtimeDataSourceConnection = dsConnection;

		Method getConMethod = dsConnection.getClass().getMethod("getConnection", new Class[0]);
		this.connection = ((Connection)getConMethod.invoke(dsConnection, new Object[0]));

		if (logger.isInfoEnabled())
		{
			logger.info("Runtime DataSource [" + this.name + "] connection = " + this.connection);
		}

		return this.connection;
	}

	private Connection getDesigntimeConnection() throws Exception
	{
		MXReportScriptContext mxReportScriptContext = MXReportScriptContext.get();
		ReportLogger logger = mxReportScriptContext.getReportScriptLogger();

		Map dsInfo = mxReportScriptContext.getDataSourceInfo(this.name);

		String driver = (String)dsInfo.get("driver");
		String url = (String)dsInfo.get("url");
		String userName = (String)dsInfo.get("username");
		String password = (String)dsInfo.get("password");
		String schemaOwner = (String)dsInfo.get("schemaowner");

		if (logger.isDebugEnabled())
		{
			logger.debug("Designtime DataSource [" + this.name + "] = " + getName());
			logger.debug("Designtime DataSource [" + getName() + "] [driver] = " + driver);
			logger.debug("Designtime DataSource [" + getName() + "] [url] = " + url);
			logger.debug("Designtime DataSource [" + getName() + "] [username] = " + userName);
			logger.debug("Designtime DataSource [" + getName() + "] [schemaowner] = " + schemaOwner);
		}

		Class.forName(driver);

		this.connection = DriverManager.getConnection(url, userName, password);

		if (logger.isInfoEnabled())
		{
			logger.info("Designtime DataSource [" + this.name + "] connection = " + this.connection);
		}

		setupDefaultConnectionProperties(this.connection, schemaOwner);

		return this.connection;
	}

	private void setupDefaultConnectionProperties(Connection connection, String schemaOwner)
	{
		Statement s = null;
		try
		{
			if (schemaOwner != null)
			{
				schemaOwner = schemaOwner.trim();

				s = connection.createStatement();

				String dbProductName = connection.getMetaData().getDatabaseProductName();
				if (dbProductName.toUpperCase().indexOf("ORACLE") >= 0)
				{
					s.execute("alter session set current_schema=" + schemaOwner);
				}
				else if (dbProductName.toUpperCase().indexOf("MICROSOFT") < 0)
				{
					if (dbProductName.toUpperCase().indexOf("DB2") >= 0)
					{
						s.execute("SET SCHEMA " + schemaOwner);
					}
				}
			}

			connection.setAutoCommit(false);
		}
		catch (Throwable t)
		{
			MXReportScriptContext mxReportScriptContext = MXReportScriptContext.get();
			ReportLogger logger = mxReportScriptContext.getReportScriptLogger();

			if (logger.isErrorEnabled())
			{
				logger.error("Failed to set the default connection properties like SchemaOwner and auto commit.", t);
			}
		}
		finally
		{
			try {
				if (s != null)
				{
					s.close();
				}
			} catch (Throwable t) {
			}
		}
	}

	public void close() {
		if (this.connection != null)
		{
			MXReportScriptContext mxReportScriptContext = MXReportScriptContext.get();
			ReportLogger logger = mxReportScriptContext.getReportScriptLogger();
			try
			{
				if (this.runtimeDataSourceInUse)
				{
					Method freeConMethod = this.runtimeDataSourceObject.getClass().getMethod("freeConnection", new Class[] { this.runtimeDataSourceConnection.getClass().getInterfaces()[0] });

					freeConMethod.invoke(this.runtimeDataSourceObject, new Object[] { this.runtimeDataSourceConnection });
				}
				else
				{
					this.connection.close();
				}

				if (logger.isInfoEnabled())
				{
					logger.info("DataSource [" + this.name + "] connection = " + this.connection + "  - CLOSED");
				}
			}
			catch (Throwable e)
			{
				if (logger.isErrorEnabled())
				{
					logger.error("DataSource [" + this.name + "] failed to close connection: " + this.connection);
				}
			}

			this.connection = null;
		}
	}
}

