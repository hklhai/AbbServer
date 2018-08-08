package com.hxqh.report;

import java.text.*;
import java.util.*;

public class MXReportDataFormatter
{
	public static final int UNLIMITEDPLACES = 8;
	public static final double MINSPERHOUR = 60.0D;
	public static final String TIMESEP = ":";
	public static final String DATESEP = "/";
	public static final char YEARCHAR = 'y';
	public static final char MONTHCHAR = 'M';
	public static final char DAYCHAR = 'd';
	public static final char AMCHAR = 'a';
	public static final char MINCHAR = 'm';
	public static final char HOUR24CHAR = 'H';
	public static final char HOUR12CHAR = 'h';
	public static final char SECONDCHAR = 's';
	public static final String SEPERATORS = " /-.:";

	public static int stringToInt(String s)	throws MXReportDataFormatException
	{
		return stringToInt(s, getLocale());
	}

	public static int stringToInt(String s, Locale l)
			throws MXReportDataFormatException
	{
		if (s == null) {
			throw new MXReportDataFormatException("Invalid Number");
		}
		Number num = null;
		try
		{
			if (isZero(s, l)) {
				return 0;
			}
			NumberFormat fmt = NumberFormat.getInstance(l);
			fmt.setParseIntegerOnly(true);

			ParsePosition parsePosition = new ParsePosition(0);
			num = fmt.parse(s, parsePosition);

			if (parsePosition.getIndex() != s.length())
			{
				throw new ParseException("Parse Error", 0);
			}

			return num.intValue();
		}
		catch (Exception e) {
		}
		throw new MXReportDataFormatException("Invalid Number");
	}

	public static String longToString(long longValue, Locale l)
			throws MXReportDataFormatException
	{
		try
		{
			NumberFormat fmt = NumberFormat.getInstance(l);
			return fmt.format(longValue);
		}
		catch (Exception ex) {
		}
		throw new MXReportDataFormatException("Invalid Number");
	}

	public static long stringToLong(String s, Locale l)
			throws MXReportDataFormatException
	{
		if (s == null) {
			throw new MXReportDataFormatException("Invalid Number");
		}

		if (isZero(s, l)) {
			return 0L;
		}
		Number num = null;
		try
		{
			NumberFormat fmt = NumberFormat.getInstance(l);
			fmt.setParseIntegerOnly(true);

			ParsePosition parsePosition = new ParsePosition(0);
			num = fmt.parse(s, parsePosition);

			if (parsePosition.getIndex() != s.length())
			{
				throw new ParseException("Parse Error", 0);
			}

			return num.longValue();
		}
		catch (Exception e) {
		}
		throw new MXReportDataFormatException("Invalid Number");
	}

	public static String doubleToString(double d, int places, Locale l)
			throws MXReportDataFormatException
	{
		try
		{
			NumberFormat fmt = NumberFormat.getInstance(l);
			fmt.setMaximumFractionDigits(places);
			if (places != 8)
			{
				fmt.setMinimumFractionDigits(places);
			}
			return fmt.format(d);
		}
		catch (Exception e) {
		}
		throw new MXReportDataFormatException("Invalid Number");
	}

	public static String doubleToInternalString(double d, int places, Locale l)
			throws MXReportDataFormatException
	{
		try
		{
			NumberFormat fmt = NumberFormat.getInstance(l);
			fmt.setGroupingUsed(false);
			fmt.setMaximumFractionDigits(places);
			if (places != 8)
			{
				fmt.setMinimumFractionDigits(places);
			}
			return fmt.format(d);
		}
		catch (Exception e) {
		}
		throw new MXReportDataFormatException("Invalid Number");
	}

	public static double stringToDouble(String s)
			throws MXReportDataFormatException
	{
		return stringToDouble(s, getLocale());
	}

	public static double stringToDouble(String s, Locale l)
			throws MXReportDataFormatException
	{
		if (s == null) {
			throw new MXReportDataFormatException("Invalid Number");
		}

		if (isZero(s, l)) {
			return 0.0D;
		}
		try
		{
			NumberFormat fmt = NumberFormat.getInstance(l);
			Number num = null;

			ParsePosition parsePosition = new ParsePosition(0);
			num = fmt.parse(s, parsePosition);

			if (parsePosition.getIndex() != s.length())
			{
				throw new ParseException("Parse Error", 0);
			}

			return num.doubleValue();
		}
		catch (Exception e) {
		}
		throw new MXReportDataFormatException("Invalid Number");
	}

	public static double durationToDouble(String s)
			throws MXReportDataFormatException
	{
		return durationToDouble(s, getLocale());
	}

	public static double durationToDouble(String s, Locale l)
			throws MXReportDataFormatException
	{
		int hours = 0;
		int mins = 0;
		boolean minus = false;

		char DECIMALSEP = new DecimalFormatSymbols(l).getDecimalSeparator();
		try
		{
			if (s.indexOf(":") == -1)
				return stringToDouble(s, l);
		}
		catch (Exception ex)
		{
			throw new MXReportDataFormatException("Invalid Duration");
		}

		if (s.indexOf(DECIMALSEP) != -1) {
			throw new MXReportDataFormatException("Invalid Duration");
		}

		if (s.startsWith("-"))
		{
			s = s.substring(1);
			minus = true;
		}

		StringTokenizer st = new StringTokenizer(s, ":");
		if (st.hasMoreTokens())
		{
			hours = stringToInt(st.nextToken(), l);
			if (st.hasMoreTokens()) {
				mins = stringToInt(st.nextToken(), l);
			} else if (s.startsWith(":"))
			{
				mins = hours;
				hours = 0;
			}
		}

		double dl = 0.0D;
		if (minus)
		{
			double tmpDl = hours + mins / 60.0D;
			String tmpStr = "-" + new Double(tmpDl).toString();
			dl = new Double(tmpStr).doubleValue();
		}
		else
		{
			dl = hours + mins / 60.0D;
		}
		return dl;
	}

	public static String doubleToDuration(double d)
	{
		return doubleToDuration(d, getLocale());
	}

	public static String doubleToDuration(double d, Locale l)
	{
		boolean minus = false;

		if (d < 0.0D)
		{
			d = Math.abs(d);
			minus = true;
		}

		int hours = (int)d;
		int mins = (int)Math.round((d - hours) * 60.0D);

		String retStr = null;
		if (mins < 10)
			retStr = hours + ":" + "0" + mins;
		else {
			retStr = hours + ":" + mins;
		}
		if (minus) {
			retStr = "-" + retStr;
		}
		return retStr;
	}

	public static String dateToString(Date d)
			throws MXReportDataFormatException
	{
		return dateToString(d, getLocale(), getTimeZone());
	}

	public static String dateToString(Date d, Locale l, TimeZone tz) throws MXReportDataFormatException
	{
		try
		{
			Calendar c = Calendar.getInstance(tz, l);
			c.setLenient(false);
			c.setTime(d);
			String dateFormat = null;
			dateFormat = ((SimpleDateFormat)DateFormat.getDateInstance(3, l)).toPattern();
			SimpleDateFormat df = new SimpleDateFormat(dateFormat, l);

			df.setTimeZone(tz);
			return df.format(c.getTime());
		}
		catch (Exception e) {
		}
		throw buildInvalidDateException();
	}

	public static Date stringToDate(String s)
			throws MXReportDataFormatException
	{
		return stringToDate(s, getLocale(), getTimeZone());
	}

	public static Date stringToDate(String s, Locale l, TimeZone tz)
			throws MXReportDataFormatException
	{
		if (s == null) {
			throw buildInvalidDateException();
		}
		try
		{
			String dateFormat = null;
			dateFormat = ((SimpleDateFormat)DateFormat.getDateInstance(3, l)).toPattern();
			SimpleDateFormat df = new SimpleDateFormat(dateFormat, l);

			int[] value = parseDateTime(s, l, df.toPattern());

			Calendar c = Calendar.getInstance(tz, l);
			c.setLenient(false);
			c.set(value[2], value[1] - 1, value[0], 0, 0, 0);
			c.set(14, 0);
			return c.getTime();
		}
		catch (Exception e) {
		}
		throw buildInvalidDateException();
	}

	public static String dateTimeToString(Date d)
			throws MXReportDataFormatException
	{
		return dateTimeToString(d, getLocale(), getTimeZone());
	}

	public static String dateTimeToString(Date d, Locale l, TimeZone tz) throws MXReportDataFormatException
	{
		try
		{
			String timeFormat = null;
			String dateFormat = null;

			dateFormat = ((SimpleDateFormat)DateFormat.getDateInstance(3, l)).toPattern();
			timeFormat = ((SimpleDateFormat)DateFormat.getTimeInstance(3, l)).toPattern();

			SimpleDateFormat df = new SimpleDateFormat(dateFormat + " " + timeFormat, l);

			df.setTimeZone(tz);
			return df.format(d);
		}
		catch (Exception e) {
		}
		throw buildInvalidDateTimeException();
	}

	public static Date stringToDateTime(String s)
			throws MXReportDataFormatException
	{
		return stringToDateTime(s, getLocale(), getTimeZone());
	}

	public static Date stringToDateTime(String s, Locale l, TimeZone tz) throws MXReportDataFormatException
	{
		try
		{
			String timeFormat = null;
			String dateFormat = null;
			dateFormat = ((SimpleDateFormat)DateFormat.getDateInstance(3, l)).toPattern();
			timeFormat = ((SimpleDateFormat)DateFormat.getTimeInstance(2, l)).toPattern();
			SimpleDateFormat df = new SimpleDateFormat(dateFormat + " " + timeFormat, l);

			int[] value = parseDateTime(s, l, df.toPattern());

			Calendar c = Calendar.getInstance(l);
			c.setTimeZone(tz);
			c.setLenient(false);
			c.set(5, value[0]);
			c.set(2, value[1] - 1);
			c.set(1, value[2]);
			c.set(11, value[3]);
			c.set(12, value[4]);
			c.set(13, 0);

			c.set(14, 0);

			return c.getTime();
		}
		catch (Exception e) {
		}
		throw buildInvalidDateTimeException();
	}

	public static String timeToString(Date d, Locale l, TimeZone tz)
			throws MXReportDataFormatException
	{
		try
		{
			String timeFormat = null;
			timeFormat = ((SimpleDateFormat)DateFormat.getTimeInstance(3, l)).toPattern();
			SimpleDateFormat df = new SimpleDateFormat(timeFormat, l);

			df.setTimeZone(tz);
			return df.format(d);
		}
		catch (Exception e) {
		}
		throw buildInvalidTimeException();
	}

	private static MXReportDataFormatException buildInvalidTimeException()
	{
		try
		{
			String exampleTime = timeToString(new Date(), getLocale(), getTimeZone());
			return new MXReportDataFormatException("Invalid Time parameter: " + exampleTime);
		}
		catch (Exception ex)
		{
		}

		return new MXReportDataFormatException("Invalid Time");
	}

	private static MXReportDataFormatException buildInvalidDateException()
	{
		try
		{
			String exampleDate = dateToString(new Date(), getLocale(), getTimeZone());
			return new MXReportDataFormatException("Invalid Date parameter: " + exampleDate);
		}
		catch (Exception ex)
		{
		}

		return new MXReportDataFormatException("Invalid Date");
	}

	private static MXReportDataFormatException buildInvalidDateTimeException()
	{
		try
		{
			String exampleDateTime = dateTimeToString(new Date(), getLocale(), getTimeZone());
			return new MXReportDataFormatException("Invalid Date/Time parameter:" + exampleDateTime);
		}
		catch (Exception ex)
		{
		}

		return new MXReportDataFormatException("Invalid Date/Time");
	}

	public static Date stringToTime(String s) throws MXReportDataFormatException
	{
		return stringToTime(s, getLocale(), getTimeZone());
	}

	public static Date stringToTime(String s, Locale l, TimeZone tz) throws MXReportDataFormatException
	{
		boolean isError = false;

		DecimalFormatSymbols symb = new DecimalFormatSymbols(l);
		Character minusSign = new Character(symb.getMinusSign());

		if (minusSign != null)
		{
			if (s.startsWith(minusSign.toString()))
			{
				isError = true;
				throw buildInvalidTimeException();
			}
		}

		try
		{
			String timeFormat = null;
			timeFormat = ((SimpleDateFormat)DateFormat.getTimeInstance(2, l)).toPattern();

			SimpleDateFormat df = new SimpleDateFormat(timeFormat, l);

			int[] value = parseDateTime(s, l, df.toPattern());

			if (value[3] > 24) {
				isError = true;
			}
			Calendar c = Calendar.getInstance(l);
			c.setTimeZone(tz);

			c.setLenient(false);
			c.set(5, 1);
			c.set(2, 0);
			c.set(1, 1970);
			c.set(11, value[3]);
			c.set(12, value[4]);
			c.set(13, 0);

			c.set(14, 0);

			return c.getTime();
		}
		catch (Exception e) {
		}
		throw buildInvalidTimeException();
	}

	private static int[] parseDateTime(String s, Locale l, String pattern)
			throws MXReportDataFormatException
	{
		boolean yearentered = false;
		boolean ampmValidate = false;

		int[] value = { 0, 0, 0, 0, 0, 0 };
		int tokencount = 0;

		String ampm = null;

		DateFormatSymbols df = new DateFormatSymbols(l);
		String[] pm = df.getAmPmStrings();

		for (int i = 0; i < pm.length; i++)
		{
			if ((s.indexOf(pm[i].toUpperCase()) > -1) || (s.indexOf(pm[i].toLowerCase()) > -1)) {
				ampm = pm[i];
			}
		}
		StringBuffer tmpStr = new StringBuffer(s);
		if (ampm != null)
		{
			int index = s.indexOf(ampm);
			if ((index > -1) && (tmpStr.charAt(index + 1) != ' ') && (index + ampm.length() < s.length()))
			{
				tmpStr.insert(index + ampm.length(), ' ');
			}
		}
		StringTokenizer st = new StringTokenizer(tmpStr.toString(), " /-.:");

		while (st.hasMoreTokens())
		{
			String token = st.nextToken();
			try
			{
				int pos = tokenToPosition(tokencount, pattern);
				value[pos] = stringToInt(token, l);

				if (pos == 2)
					yearentered = true;
			}
			catch (MXReportDataFormatException e)
			{
				int am;
				if ((am = stringToAmPm(token, l)) != -1)
				{
					ampmValidate = true;

					if ((value[3] > 0) && (value[3] <= 12))
					{
						if (value[3] == 12)
							value[3] -= 12;
						value[3] += am * 12;
					}
					else
					{
						throw buildInvalidDateException();
					}
				}
				else
				{
					int m;
					if ((m = stringToMonth(token, l)) != -1)
					{
						if (value[1] != 0)
							value[0] = value[1];
						value[1] = m;
					}
					else {
						throw buildInvalidDateException();
					}
				}
			}
			tokencount++;
		}

		if ((ampm != null) && (!ampmValidate)) {
			throw buildInvalidDateException();
		}

		Calendar c = Calendar.getInstance(l);
		c.setTime(new Date());

		if ((value[1] != 0) && (value[0] == 0) && (value[2] == 0))
		{
			value[0] = value[1];
			value[1] = 0;
		}
		else if ((value[2] != 0) && (value[0] == 0) && (value[1] == 0))
		{
			value[0] = value[2];
			value[2] = 0;
			yearentered = false;
		}

		if (value[1] == 0) {
			value[1] = (c.get(2) + 1);
		}
		if (!yearentered) {
			value[2] = c.get(1);
		} else if (value[2] < 100)
		{
			int currYear = c.get(1) % 100;
			int currCentury = c.get(1) / 100 * 100;

			if ((currYear >= 0) && (currYear <= 49) && (value[2] >= 0) && (value[2] <= 49))
			{
				value[2] += currCentury;
			} else if ((currYear >= 50) && (currYear <= 99) && (value[2] >= 0) && (value[2] <= 49))
			{
				value[2] += currCentury + 100;
			} else if ((currYear >= 0) && (currYear <= 49) && (value[2] >= 50) && (value[2] <= 99))
			{
				value[2] += currCentury - 100;
			} else if ((currYear >= 50) && (currYear <= 99) && (value[2] >= 50) && (value[2] <= 99))
			{
				value[2] += currCentury;
			}
		} else if ((value[2] > 9999) || (value[2] <= 999)) {
			throw buildInvalidDateException();
		}
		return value;
	}

	private static int stringToAmPm(String s, Locale l)
	{
		DateFormatSymbols df = new DateFormatSymbols(l);

		s = s.toUpperCase();
		String[] pm = df.getAmPmStrings();

		for (int i = 0; i < pm.length; i++) {
			if (s.equals(pm[i].toUpperCase()))
				return i;
		}
		return -1;
	}

	public static int stringToMonth(String s)
	{
		return stringToMonth(s, getLocale());
	}

	private static int stringToMonth(String s, Locale l)
	{
		DateFormatSymbols df = new DateFormatSymbols(l);

		s = s.toUpperCase();
		String[] shortmnths = df.getShortMonths();
		for (int i = 0; i < shortmnths.length; i++) {
			if (s.equals(shortmnths[i].toUpperCase()))
				return i + 1;
		}
		String[] mnths = df.getMonths();
		for (int i = 0; i < mnths.length; i++) {
			if (s.equals(mnths[i].toUpperCase()))
				return i + 1;
		}
		return -1;
	}

	private static int tokenToPosition(int tokennum, String pattern)
	{
		StringTokenizer st = new StringTokenizer(pattern, " /-.:");
		int i = 0;

		while (st.hasMoreTokens())
		{
			String s = st.nextToken();
			if ((s.indexOf('d') != -1) && (i == tokennum))
				return 0;
			if ((s.indexOf('M') != -1) && (i == tokennum))
				return 1;
			if ((s.indexOf('y') != -1) && (i == tokennum))
				return 2;
			if ((s.indexOf('H') != -1) && (i == tokennum))
				return 3;
			if ((s.indexOf('h') != -1) && (i == tokennum))
				return 3;
			if ((s.indexOf('m') != -1) && (i == tokennum))
				return 4;
			if ((s.indexOf('s') != -1) && (i == tokennum))
				return 5;
			i++;
		}

		return -1;
	}

	private static boolean isZero(String s, Locale l)
	{
		DecimalFormatSymbols symb = new DecimalFormatSymbols(l);

		for (int i = 0; i < s.length(); i++)
		{
			if ((s.charAt(i) != symb.getDecimalSeparator()) && (s.charAt(i) != symb.getGroupingSeparator()) && (s.charAt(i) != '0') && (s.charAt(i) != symb.getMinusSign()))
			{
				return false;
			}
		}
		return true;
	}

	private static Locale getLocale()
	{
		MXReportScriptContext reportScriptContext = MXReportScriptContext.get();

		Locale l = reportScriptContext.getLocale();

		return l;
	}

	private static TimeZone getTimeZone()
	{
		MXReportScriptContext reportScriptContext = MXReportScriptContext.get();

		TimeZone tz = reportScriptContext.getTimeZone();

		return tz;
	}
}

