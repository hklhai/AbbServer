package com.hxqh.report;

public abstract interface MXReportDataSource
{
  public abstract String getDriver();

  public abstract void setDriver(String paramString);

  public abstract String getUrl();

  public abstract void setUrl(String paramString);

  public abstract String getUserName();

  public abstract void setUserName(String paramString);

  public abstract String getPassword();

  public abstract void setPassword(String paramString);

  public abstract MXReportDataSet getDataSet(String paramString);
}
