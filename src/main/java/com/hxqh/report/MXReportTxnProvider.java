 package com.hxqh.report;

 public class MXReportTxnProvider
 {
   public static MXReportTxn create(String dataSourceName)
   {
     MXReportDataSourceImpl ds = MXReportDataSourceProvider.create(dataSourceName);
 
     MXReportTxn txn = new MXReportTxnImpl(ds);
 
     return txn;
   }
 }

