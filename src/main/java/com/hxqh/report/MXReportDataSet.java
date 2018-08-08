package com.hxqh.report;

import java.sql.Timestamp;

public abstract interface MXReportDataSet
{
  public abstract String getName();

  public abstract void open();

  public abstract String getQuery();

  public abstract void setQuery(String paramString);

  public abstract Object getQueryParameterValue(int paramInt);

  public abstract void setQueryParameterValue(int paramInt, Object paramObject);

  public abstract boolean fetch();

  public abstract void close();

  public abstract boolean isClosed();

  public abstract void registerDataTranslation(String paramString1, String paramString2, String paramString3, String paramString4);

  public abstract String getString(String paramString);

  public abstract String getBooleanString(String paramString);

  public abstract Timestamp getTimestamp(String paramString);

  public abstract double getDouble(String paramString);

  public abstract Double getDoubleObject(String paramString);

  public abstract float getFloat(String paramString);

  public abstract Float getFloatObject(String paramString);

  public abstract String getDuration(String paramString);

  public abstract int getInteger(String paramString);

  public abstract Integer getIntegerObject(String paramString);

  public abstract String getNullValueFunction(String paramString1, String paramString2);

  public abstract Integer getBooleanInteger(String paramString);

  public abstract String getDatabaseProductName();

  public abstract boolean isOracle();

  public abstract boolean isSQLServer();

  public abstract boolean isDB2();
}
