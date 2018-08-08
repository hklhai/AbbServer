package com.hxqh.report;
 
 public class MXReportUtil
 {
   private static final double MINSPERHOUR = 60.0D;
   private static final double SECSPERMIN = 60.0D;
   public static final int HHMM = 0;
   public static final int HHMMSS = 1;
 
   public static String getDuration(double d)
   {
     return getDuration(d, 0);
   }
 
   public static String getDuration(double d, int format)
   {
     boolean minus = false;
 
     if (d < 0.0D)
     {
       d = Math.abs(d);
       minus = true;
     }
 
     String retStr = null;
     int hours = (int)d;
     int mins = 0;
     int secs = 0;
     double fractionalHours = d - hours;
 
     if (format == 0)
     {
       mins = (int)Math.round(fractionalHours * 60.0D);
     }
     else
     {
       double fractionalMins = fractionalHours * 60.0D;
       mins = (int)fractionalMins;
       secs = (int)Math.round((fractionalMins - mins) * 60.0D);
     }
 
     if (hours < 10)
     {
       retStr = "0" + hours;
     }
     else
     {
       retStr = "" + hours;
     }
 
     if (mins < 10)
     {
       retStr = retStr + ":0" + mins;
     }
     else
     {
       retStr = retStr + ":" + mins;
     }
 
     if (format == 1)
     {
       if (secs < 10)
       {
         retStr = retStr + ":0" + secs;
       }
       else
       {
         retStr = retStr + ":" + secs;
       }
     }
 
     if (minus)
     {
       retStr = "-" + retStr;
     }
 
     return retStr;
   }
 }

