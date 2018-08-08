package com.hxqh.report.logging;

import java.lang.reflect.Method;

public class ReportLoggerImpl
	implements ReportLogger
{

	private Object hxLogger;
	private boolean debugEnabled;
	private boolean errorEnabled;
	private boolean fatalEnabled;
	private boolean infoEnabled;
	private boolean warnEnabled;
	private Method debugMethod1;
	private Method debugMethod2;
	private Method errorMethod1;
	private Method errorMethod2;
	private Method fatalMethod1;
	private Method fatalMethod2;
	private Method infoMethod1;
	private Method infoMethod2;
	private Method warnMethod1;
	private Method warnMethod2;

	public ReportLoggerImpl(Object hxLogger)
	{
		this.hxLogger = null;
		debugEnabled = false;
		errorEnabled = false;
		fatalEnabled = false;
		infoEnabled = false;
		warnEnabled = false;
		debugMethod1 = null;
		debugMethod2 = null;
		errorMethod1 = null;
		errorMethod2 = null;
		fatalMethod1 = null;
		fatalMethod2 = null;
		infoMethod1 = null;
		infoMethod2 = null;
		warnMethod1 = null;
		warnMethod2 = null;
		this.hxLogger = hxLogger;
		initLogging();
	}

	private void initLogging()
	{
		try
		{
			Method m = hxLogger.getClass().getMethod("isDebugEnabled", new Class[0]);
			Boolean isDebug = (Boolean)m.invoke(hxLogger, new Object[0]);
			debugEnabled = isDebug.booleanValue();
			m = hxLogger.getClass().getMethod("isErrorEnabled", new Class[0]);
			Boolean isError = (Boolean)m.invoke(hxLogger, new Object[0]);
			errorEnabled = isError.booleanValue();
			m = hxLogger.getClass().getMethod("isFatalEnabled", new Class[0]);
			Boolean isFatal = (Boolean)m.invoke(hxLogger, new Object[0]);
			fatalEnabled = isFatal.booleanValue();
			m = hxLogger.getClass().getMethod("isInfoEnabled", new Class[0]);
			Boolean isInfo = (Boolean)m.invoke(hxLogger, new Object[0]);
			infoEnabled = isInfo.booleanValue();
			m = hxLogger.getClass().getMethod("isWarnEnabled", new Class[0]);
			Boolean isWarn = (Boolean)m.invoke(hxLogger, new Object[0]);
			warnEnabled = isWarn.booleanValue();
			debugMethod1 = hxLogger.getClass().getMethod("debug", new Class[] {Object.class});
			debugMethod2 = hxLogger.getClass().getMethod("debug", new Class[] {
					Object.class, Throwable.class
			});
			errorMethod1 = hxLogger.getClass().getMethod("error", new Class[] {
					Object.class
			});
			errorMethod2 = hxLogger.getClass().getMethod("error", new Class[] {
				Object.class, Throwable.class
			});
			fatalMethod1 = hxLogger.getClass().getMethod("fatal", new Class[] {
				Object.class
			});
			fatalMethod2 = hxLogger.getClass().getMethod("fatal", new Class[] {
				Object.class, Throwable.class
			});
			infoMethod1 = hxLogger.getClass().getMethod("info", new Class[] {
				Object.class
			});
			infoMethod2 = hxLogger.getClass().getMethod("info", new Class[] {
				Object.class, Throwable.class
			});
			warnMethod1 = hxLogger.getClass().getMethod("warn", new Class[] {
				Object.class
			});
			warnMethod2 = hxLogger.getClass().getMethod("warn", new Class[] {
				Object.class, Throwable.class
			});
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}

	public void debug(Object message)
	{
		if (debugEnabled && debugMethod1 != null)
			try
			{
				debugMethod1.invoke(hxLogger, new Object[] {
					message
				});
			}
			catch (Exception e) { }
	}

	public void debug(Object message, Throwable t)
	{
		if (debugEnabled)
			try
			{
				debugMethod2.invoke(hxLogger, new Object[] {
					message, t
				});
			}
			catch (Exception e) { }
	}

	public void error(Object message)
	{
		if (errorEnabled)
			try
			{
				errorMethod1.invoke(hxLogger, new Object[] {
					message
				});
			}
			catch (Exception e) { }
	}

	public void error(Object message, Throwable t)
	{
		if (errorEnabled)
			try
			{
				errorMethod2.invoke(hxLogger, new Object[] {
					message, t
				});
			}
			catch (Exception e) { }
	}

	public void fatal(Object message)
	{
		if (fatalEnabled)
			try
			{
				fatalMethod1.invoke(hxLogger, new Object[] {
					message
				});
			}
			catch (Exception e) { }
	}

	public void fatal(Object message, Throwable t)
	{
		if (fatalEnabled)
			try
			{
				fatalMethod2.invoke(hxLogger, new Object[] {
					message, t
				});
			}
			catch (Exception e) { }
	}

	public void info(Object message)
	{
		if (infoEnabled)
			try
			{
				infoMethod1.invoke(hxLogger, new Object[] {
					message
				});
			}
			catch (Exception e) { }
	}

	public void info(Object message, Throwable t)
	{
		if (infoEnabled)
			try
			{
				infoMethod2.invoke(hxLogger, new Object[] {
					message, t
				});
			}
			catch (Exception e) { }
	}

	public boolean isDebugEnabled()
	{
		return debugEnabled;
	}

	public boolean isErrorEnabled()
	{
		return errorEnabled;
	}

	public boolean isFatalEnabled()
	{
		return fatalEnabled;
	}

	public boolean isInfoEnabled()
	{
		return infoEnabled;
	}

	public boolean isWarnEnabled()
	{
		return warnEnabled;
	}

	public void warn(Object message)
	{
		if (warnEnabled)
			try
			{
				warnMethod1.invoke(hxLogger, new Object[] {
					message
				});
			}
			catch (Exception e) { }
	}

	public void warn(Object message, Throwable t)
	{
		if (warnEnabled)
			try
			{
				warnMethod2.invoke(hxLogger, new Object[] {
					message, t
				});
			}
			catch (Exception e) { }
	}
}
