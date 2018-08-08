package com.hxqh.report;

public abstract interface MXReportTxn
{
  public abstract MXReportTxnStatement createStatement();

  public abstract void save();
}
