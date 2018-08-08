package com.hxqh.report;

public abstract interface MXReportTxnStatement
{
  public abstract String getQuery();

  public abstract void setQuery(String paramString);

  public abstract Object getQueryParameterValue(int paramInt);

  public abstract void setQueryParameterValue(int paramInt, Object paramObject);

  public abstract int getQueryParameterSize();
}

