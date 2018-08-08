package com.hxqh.report;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class MXReportSqlFormat
{
  private static final String[] EXPRLIST = { "<=", "<", ">=", ">", "!=", "=" };

  public static String getCurrentDateFunction()
  {
    Date d = new Date(System.currentTimeMillis());
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    df.setTimeZone(TimeZone.getDefault());
    String dateString = df.format(d);

    return "{ d '" + dateString + "' }";
  }

  public static String getDateFunction(Date d)
  {
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    df.setTimeZone(TimeZone.getDefault());
    String dateString = df.format(d);

    return "{ d '" + dateString + "' }";
  }

  public static String getTimeFunction(Date d)
  {
    DateFormat df = new SimpleDateFormat("HH:mm:ss");
    df.setTimeZone(TimeZone.getDefault());
    String timeString = df.format(d);

    return "{ t '" + timeString + "' }";
  }

  public static String getCurrentTimestampFunction()
  {
    Date d = new Date(System.currentTimeMillis());

    DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    df.setTimeZone(TimeZone.getDefault());
    String dateString = df.format(d);

    return "{ ts '" + dateString + "' }";
  }

  public static String getTimestampFunction(Date d)
  {
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    df.setTimeZone(TimeZone.getDefault());
    String dateString = df.format(d);

    return "{ ts '" + dateString + "' }";
  }

  public static Date getStartDayTimestamp(Date d)
  {
    MXReportScriptContext sc = MXReportScriptContext.get();

    Locale l = sc.getLocale();
    TimeZone tz = sc.getTimeZone();

    Calendar c = Calendar.getInstance(l);
    c.setTimeZone(tz);
    c.setLenient(false);
    c.setTime(d);
    c.set(11, 0);
    c.set(12, 0);
    c.set(13, 0);
    c.set(14, 0);

    d = c.getTime();

    return d;
  }

  public static String getStartDayTimestampFunction(Date d)
  {
    MXReportScriptContext sc = MXReportScriptContext.get();

    Locale l = sc.getLocale();
    TimeZone tz = sc.getTimeZone();

    Calendar c = Calendar.getInstance(l);
    c.setTimeZone(tz);
    c.setLenient(false);
    c.setTime(d);
    c.set(11, 0);
    c.set(12, 0);
    c.set(13, 0);
    c.set(14, 0);

    d = c.getTime();

    return getTimestampFunction(d);
  }

  public static Date getEndDayTimestamp(Date d)
  {
    MXReportScriptContext sc = MXReportScriptContext.get();

    Locale l = sc.getLocale();
    TimeZone tz = sc.getTimeZone();

    Calendar c = Calendar.getInstance(l);
    c.setTimeZone(tz);
    c.setLenient(false);
    c.setTime(d);
    c.set(11, 23);
    c.set(12, 59);
    c.set(13, 50);
    c.set(14, 999);

    d = c.getTime();

    return d;
  }

  public static Date getCombinedDateAndTime(Date date, Date time)
  {
    MXReportScriptContext sc = MXReportScriptContext.get();

    Locale l = sc.getLocale();
    TimeZone tz = sc.getTimeZone();

    Calendar c = Calendar.getInstance(l);
    c.setTimeZone(tz);
    c.setLenient(false);
    c.setTime(date);

    Calendar timeCalendar = Calendar.getInstance(l);
    timeCalendar.setTimeZone(tz);
    timeCalendar.setLenient(false);
    timeCalendar.setTime(time);
    c.set(11, timeCalendar.get(11));
    c.set(12, timeCalendar.get(12));
    c.set(13, timeCalendar.get(13));
    c.set(14, timeCalendar.get(14));

    Date d = c.getTime();

    return d;
  }

  public static String getEndDayTimestampFunction(Date d)
  {
    MXReportScriptContext sc = MXReportScriptContext.get();

    Locale l = sc.getLocale();
    TimeZone tz = sc.getTimeZone();

    Calendar c = Calendar.getInstance(l);
    c.setTimeZone(tz);
    c.setLenient(false);
    c.setTime(d);
    c.set(11, 23);
    c.set(12, 59);
    c.set(13, 50);
    c.set(14, 999);

    d = c.getTime();

    return getTimestampFunction(d);
  }

  public static String getScalarFunction(String functionName, String[] params)
  {
    StringBuffer buf = new StringBuffer();
    buf.append("{ ");
    buf.append("fn ");
    buf.append(functionName);
    buf.append("(");

    for (int i = 0; i < params.length; i++)
    {
      String param = params[i];
      if (i > 0)
      {
        buf.append(",");
      }

      buf.append(param);
    }

    buf.append(")");

    return buf.toString();
  }

  public static String createParamWhereClause(String columnName, String paramValue)
  {
    StringTokenizer stk = new StringTokenizer(paramValue, ",");

    ArrayList orTokens = new ArrayList();
    ArrayList andTokens = new ArrayList();

    while (stk.hasMoreTokens())
    {
      String token = stk.nextToken();
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
      String value = orTokenVal[1];

      value = fixSingleQuotes(value);

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
      String value = andTokenVal[1];

      value = fixSingleQuotes(value);

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

    if (noOfAndTokens > 0) {
      buf.append("(");
      buf.append(andBuf.toString());
      buf.append(")");
    }

    if ((buf.length() > 0) &&
      (noOfOrTokens > 0)) {
      buf.append(" or ");
    }

    if (noOfOrTokens > 0) {
      buf.append("(");
      buf.append(orBuf.toString());
      buf.append(")");
    }

    return buf.toString();
  }

  public static String fixSingleQuotes(String s)
  {
    StringBuffer buf = new StringBuffer(s);
    StringBuffer newBuf = new StringBuffer();
    int bufLength = buf.length();
    for (int i = 0; i < bufLength; i++)
    {
      if (buf.charAt(i) == '\'')
        newBuf.append('\'');
      newBuf.append(buf.charAt(i));
    }

    return newBuf.toString();
  }
}

