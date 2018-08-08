 package com.hxqh.report;

 import java.util.ArrayList;
 import java.util.Iterator;

 public class PMCOMReportSqlFormat
 {
   private static final String[] EXPRLIST = { "<=", "<", ">=", ">", "!=", "=" };
   private static final boolean DEBUG = false;
 
   public static void debug(String msg)
   {
   }
 
   public static boolean isNull(String t)
   {
     return (t == null) || (t.trim().equals(""));
   }
 
   public static String doubleEmbeddedSingleQuotes(String t)
   {
     if ((isNull(t)) || (t.indexOf("'") < 0)) return t;
 
     String ret = t.replaceAll("'", "''");
 
     return ret.toString();
   }
 
   public static String createParamWhereClause(String columnName, String paramValue)
   {
     String[] tokens = paramValue.split(",");
 
     ArrayList orTokens = new ArrayList();
     ArrayList andTokens = new ArrayList();
 
     for (int v = 0; v < tokens.length; v++)
     {
       String token = tokens[v];
 
       token = token.trim();
       if (token.length() != 0)
       {
         String operator = "";
         for (int i = 0; i < EXPRLIST.length; i++)
         {
           if (token.startsWith(EXPRLIST[i]))
           {
             operator = EXPRLIST[i];
             break;
           }
         }
 
         String value = token;
 
         if (operator.length() > 0)
         {
           value = token.substring(operator.length());
         }
 
         if (operator.length() == 0)
         {
           operator = "like";
         }
 
         if (operator.equals("!="))
         {
           andTokens.add(new String[] { operator, value });
         }
         else
         {
           orTokens.add(new String[] { operator, value });
         }
       }
     }
     StringBuffer orBuf = new StringBuffer();
     int noOfOrTokens = 0;
     Iterator orTokenIterator = orTokens.iterator();
     while (orTokenIterator.hasNext())
     {
       String[] orTokenVal = (String[])orTokenIterator.next();
 
       String operator = orTokenVal[0];
       String value = doubleEmbeddedSingleQuotes(orTokenVal[1]);
 
       if (noOfOrTokens > 0)
       {
         orBuf.append(" or ");
       }
 
       orBuf.append("(");
       orBuf.append(columnName);
       orBuf.append(" ");
       orBuf.append(operator);
       orBuf.append(" ");
       orBuf.append("'");
       if (operator.equalsIgnoreCase("like"))
       {
         orBuf.append("%");
       }
       orBuf.append(value);
       if (operator.equalsIgnoreCase("like"))
       {
         orBuf.append("%");
       }
       orBuf.append("'");
       orBuf.append(")");
 
       noOfOrTokens++;
     }
 
     StringBuffer andBuf = new StringBuffer();
     int noOfAndTokens = 0;
     Iterator andTokenIterator = andTokens.iterator();
     while (andTokenIterator.hasNext())
     {
       String[] andTokenVal = (String[])andTokenIterator.next();
 
       String operator = andTokenVal[0];
       String value = doubleEmbeddedSingleQuotes(andTokenVal[1]);
 
       if (noOfAndTokens > 0)
       {
         andBuf.append(" and ");
       }
 
       andBuf.append("(");
       andBuf.append(columnName);
       andBuf.append(" ");
       andBuf.append(operator);
       andBuf.append(" ");
       andBuf.append("'");
       if (operator.equalsIgnoreCase("like"))
       {
         andBuf.append("%");
       }
       andBuf.append(value);
       if (operator.equalsIgnoreCase("like"))
       {
         andBuf.append("%");
       }
       andBuf.append("'");
       andBuf.append(")");
 
       noOfAndTokens++;
     }
 
     StringBuffer buf = new StringBuffer();
 
     if (noOfAndTokens > 0)
     {
       buf.append("(");
       buf.append(andBuf.toString());
       buf.append(")");
     }
 
     if (buf.length() > 0)
     {
       buf.append(" or ");
     }
 
     if (noOfOrTokens > 0)
     {
       buf.append("(");
       buf.append(orBuf.toString());
       buf.append(")");
     }
 
     return buf.toString();
   }
 }


