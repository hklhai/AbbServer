 package com.hxqh.report;

 public class MXReportThreadLocalContext
 {
   private static ThreadLocal<MXReportScriptContext> scriptContext = new ThreadLocal()
   {
     protected synchronized MXReportScriptContext initialValue()
     {
       return new MXReportScriptContext();
     }
   };

   public static MXReportScriptContext get()
   {
     return (MXReportScriptContext)scriptContext.get();
   }
 }

