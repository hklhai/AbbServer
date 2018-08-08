 package com.hxqh.report.logging;

 public class ReportLoggerFactory
 {
   private static ReportLoggerProvider loggerProvider = null;

   public static ReportLogger getLogger(String name)
   {
     return loggerProvider.getLogger(name);
   }

   public static void setReportLoggerProvider(ReportLoggerProvider provider)
   {
     loggerProvider = provider;
   }
 }
