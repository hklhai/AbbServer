package com.hxqh.report.logging;

public abstract interface ReportLogger
{
  public abstract boolean isDebugEnabled();

  public abstract boolean isErrorEnabled();

  public abstract boolean isFatalEnabled();

  public abstract boolean isInfoEnabled();

  public abstract boolean isWarnEnabled();

  public abstract void debug(Object paramObject);

  public abstract void debug(Object paramObject, Throwable paramThrowable);

  public abstract void info(Object paramObject);

  public abstract void info(Object paramObject, Throwable paramThrowable);

  public abstract void warn(Object paramObject);

  public abstract void warn(Object paramObject, Throwable paramThrowable);

  public abstract void error(Object paramObject);

  public abstract void error(Object paramObject, Throwable paramThrowable);

  public abstract void fatal(Object paramObject);

  public abstract void fatal(Object paramObject, Throwable paramThrowable);
}


