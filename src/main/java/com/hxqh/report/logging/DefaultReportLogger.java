 package com.hxqh.report.logging;

 import java.io.FileOutputStream;
 import java.io.PrintStream;
 import java.util.Date;

 public class DefaultReportLogger implements ReportLogger
 {
   private static final int LOGLEVEL_DEBUG = 5;
   private static final int LOGLEVEL_INFO = 4;
   private static final int LOGLEVEL_WARN = 3;
   private static final int LOGLEVEL_ERROR = 2;
   private static final int LOGLEVEL_FATAL = 1;
   private static final int LOGLEVEL_NONE = 0;
   private static final String DEBUG = "DEBUG";
   private static final String INFO = "INFO";
   private static final String WARN = "WARN";
   private static final String ERROR = "ERROR";
   private static final String FATAL = "FATAL";
   private int currentLogLevel = 0;
 
   private String logFileName = "c:/temp/myreport.txt";
 
   private PrintStream logFileStream = null;
 
   public void setLogLevel(String logLevel)
   {
     if (logLevel == null)
     {
       this.currentLogLevel = 0;
       return;
     }
 
     if (logLevel.equalsIgnoreCase("DEBUG"))
     {
       this.currentLogLevel = 5;
     }
     else if (logLevel.equalsIgnoreCase("INFO"))
     {
       this.currentLogLevel = 4;
     }
     else if (logLevel.equalsIgnoreCase("WARN"))
     {
       this.currentLogLevel = 3;
     }
     else if (logLevel.equalsIgnoreCase("ERROR"))
     {
       this.currentLogLevel = 2;
     }
     else if (logLevel.equalsIgnoreCase("FATAL"))
     {
       this.currentLogLevel = 1;
     }
     else
     {
       this.currentLogLevel = 0;
     }
   }
 
   public void setLogFileName(String fileName)
   {
     this.logFileName = fileName;
     if (this.logFileStream != null)
     {
       this.logFileStream.close();
       this.logFileStream = null;
     }
   }
 
   public void close()
   {
     if (this.logFileStream != null)
     {
       this.logFileStream.close();
       this.logFileStream = null;
     }
   }
 
   public void debug(Object message)
   {
     if (isDebugEnabled())
     {
       logMessage("DEBUG", message);
     }
   }
 
   public void debug(Object message, Throwable t)
   {
     if (isDebugEnabled())
     {
       logMessage("DEBUG", message, t);
     }
   }
 
   public void error(Object message)
   {
     if (isErrorEnabled())
     {
       logMessage("ERROR", message);
     }
   }
 
   public void error(Object message, Throwable t)
   {
     if (isErrorEnabled())
     {
       logMessage("ERROR", message, t);
     }
   }
 
   public void fatal(Object message)
   {
     if (isFatalEnabled())
     {
       logMessage("FATAL", message);
     }
   }
 
   public void fatal(Object message, Throwable t)
   {
     if (isFatalEnabled())
     {
       logMessage("FATAL", message, t);
     }
   }
 
   public void info(Object message)
   {
     if (isInfoEnabled())
     {
       logMessage("INFO", message);
     }
   }
 
   public void info(Object message, Throwable t)
   {
     if (isInfoEnabled())
     {
       logMessage("INFO", message, t);
     }
   }
 
   public void warn(Object message)
   {
     if (isWarnEnabled())
     {
       logMessage("WARN", message);
     }
   }
 
   public void warn(Object message, Throwable t)
   {
     if (isWarnEnabled())
     {
       logMessage("WARN", message, t);
     }
   }
 
   public boolean isDebugEnabled()
   {
     if (this.currentLogLevel >= 5)
     {
       return true;
     }
 
     return false;
   }
 
   public boolean isErrorEnabled()
   {
     if (this.currentLogLevel >= 2)
     {
       return true;
     }
 
     return false;
   }
 
   public boolean isFatalEnabled()
   {
     if (this.currentLogLevel >= 1)
     {
       return true;
     }
 
     return false;
   }
 
   public boolean isInfoEnabled()
   {
     if (this.currentLogLevel >= 4)
     {
       return true;
     }
 
     return false;
   }
 
   public boolean isWarnEnabled()
   {
     if (this.currentLogLevel >= 3)
     {
       return true;
     }
 
     return false;
   }
 
   private void logMessage(String level, Object message)
   {
     logMessage(level, message, null);
   }
 
   private void logMessage(String level, Object message, Throwable t)
   {
     if (this.logFileName == null)
     {
       System.out.print(new Date().toString());
       System.out.print("  ");
       System.out.print(level);
       System.out.print("  ");
       System.out.println(message);
       if (t != null)
       {
         t.printStackTrace(System.out);
         System.out.println();
       }
 
       return;
     }
 
     try
     {
       if (this.logFileStream == null)
       {
         FileOutputStream fos = new FileOutputStream(this.logFileName, false);
         this.logFileStream = new PrintStream(fos);
       }
 
       this.logFileStream.print(new Date().toString());
       this.logFileStream.print("  ");
       this.logFileStream.print(level);
       this.logFileStream.print("  ");
       this.logFileStream.println(message);
       if (t != null)
       {
         t.printStackTrace(this.logFileStream);
         this.logFileStream.println();
       }
       this.logFileStream.flush();
     }
     catch (Exception ex)
     {
       this.logFileName = null;
     }
   }
 }


