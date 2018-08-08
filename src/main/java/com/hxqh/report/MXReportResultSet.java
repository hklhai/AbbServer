package com.hxqh.report;

import com.hxqh.report.logging.ReportLogger;

import java.math.BigDecimal;
import java.sql.*;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;


public class MXReportResultSet
{
	private MXReportDataSource dataSource = null;
	private MXReportDataSet dataSet = null;

	private ResultSet originalResultSet = null;
	private MXReportScriptContext mxReportScriptContext = null;
	Locale clientLocale = null;
	TimeZone clientTimeZone = null;

	private ReportLogger logger = null;

	public MXReportResultSet(ResultSet originalResultSet)
	{
		this.originalResultSet = originalResultSet;

		this.mxReportScriptContext = MXReportScriptContext.get();
		this.logger = this.mxReportScriptContext.getReportScriptLogger();

		if (this.mxReportScriptContext != null)
		{
			this.clientLocale = this.mxReportScriptContext.getLocale();
			this.clientTimeZone = this.mxReportScriptContext.getTimeZone();
		}
	}

	public void setDataSource(MXReportDataSource dataSource)
	{
		this.dataSource = dataSource;
	}

	public void setDataSet(MXReportDataSet dataSet)
	{
		this.dataSet = dataSet;
	}

	public void close() throws SQLException
	{
		this.originalResultSet.close();
	}

	public int findColumn(String columnName) throws SQLException
	{
		return this.originalResultSet.findColumn(columnName);
	}

	public BigDecimal getBigDecimal(int columnIndex) throws SQLException
	{
		return this.originalResultSet.getBigDecimal(columnIndex);
	}

	public BigDecimal getBigDecimal(String columnName) throws SQLException
	{
		return this.originalResultSet.getBigDecimal(columnName);
	}

	public Blob getBlob(int i) throws SQLException
	{
		return this.originalResultSet.getBlob(i);
	}

	public Blob getBlob(String colName) throws SQLException
	{
		return this.originalResultSet.getBlob(colName);
	}

	public boolean getBoolean(int columnIndex) throws SQLException
	{
		return this.originalResultSet.getBoolean(columnIndex);
	}

	public boolean getBoolean(String columnName) throws SQLException
	{
		return this.originalResultSet.getBoolean(columnName);
	}

	public Clob getClob(int i) throws SQLException
	{
		return this.originalResultSet.getClob(i);
	}

	public Clob getClob(String colName) throws SQLException
	{
		return this.originalResultSet.getClob(colName);
	}

	public Date getDate(int columnIndex)
			throws SQLException
			{
		Date d = this.originalResultSet.getDate(columnIndex);
		if (d == null)
		{
			return null;
		}

		String columnName = this.originalResultSet.getMetaData().getColumnName(columnIndex);

		Timestamp originalTimeStamp = new Timestamp(d.getTime());

		Timestamp newTimeStamp = getTimeStampInternal(columnName, originalTimeStamp);
		if (newTimeStamp == null)
		{
			return null;
		}

		return new Date(newTimeStamp.getTime());
			}

	public Date getDate(String columnName)
			throws SQLException
			{
		Date d = this.originalResultSet.getDate(columnName);
		if (d == null)
		{
			return null;
		}

		Timestamp originalTimeStamp = new Timestamp(d.getTime());

		Timestamp newTimeStamp = getTimeStampInternal(columnName, originalTimeStamp);
		if (newTimeStamp == null)
		{
			return null;
		}

		return new Date(newTimeStamp.getTime());
			}

	public double getDouble(int columnIndex) throws SQLException
	{
		return this.originalResultSet.getDouble(columnIndex);
	}

	public double getDouble(String columnName) throws SQLException
	{
		return this.originalResultSet.getDouble(columnName);
	}

	public float getFloat(int columnIndex) throws SQLException
	{
		return this.originalResultSet.getFloat(columnIndex);
	}

	public float getFloat(String columnName) throws SQLException
	{
		return this.originalResultSet.getFloat(columnName);
	}

	public int getInt(int columnIndex) throws SQLException
	{
		return this.originalResultSet.getInt(columnIndex);
	}

	public int getInt(String columnName) throws SQLException
	{
		return this.originalResultSet.getInt(columnName);
	}

	public long getLong(int columnIndex) throws SQLException
	{
		return this.originalResultSet.getLong(columnIndex);
	}

	public long getLong(String columnName) throws SQLException
	{
		return this.originalResultSet.getLong(columnName);
	}

	public ResultSetMetaData getMetaData() throws SQLException
	{
		return this.originalResultSet.getMetaData();
	}

	public Object getObject(int columnIndex) throws SQLException
	{
		return this.originalResultSet.getObject(columnIndex);
	}

	public Object getObject(String columnName) throws SQLException
	{
		return this.originalResultSet.getObject(columnName);
	}

	public Object getObject(int i, Map map) throws SQLException
	{
		return this.originalResultSet.getObject(i, map);
	}

	public Object getObject(String colName, Map map) throws SQLException
	{
		return this.originalResultSet.getObject(colName, map);
	}

	public int getRow() throws SQLException
	{
		return this.originalResultSet.getRow();
	}

	public short getShort(int columnIndex) throws SQLException
	{
		return this.originalResultSet.getShort(columnIndex);
	}

	public short getShort(String columnName) throws SQLException
	{
		return this.originalResultSet.getShort(columnName);
	}

	public String getString(int columnIndex) throws SQLException
	{
		return this.originalResultSet.getString(columnIndex);
	}

	public String getString(String columnName) throws SQLException
	{
		return this.originalResultSet.getString(columnName);
	}

	public Time getTime(int columnIndex)
			throws SQLException
			{
		Time t = this.originalResultSet.getTime(columnIndex);
		if (t == null)
		{
			return null;
		}

		String columnName = this.originalResultSet.getMetaData().getColumnName(columnIndex);

		Timestamp originalTimeStamp = new Timestamp(t.getTime());

		Timestamp newTimeStamp = getTimeStampInternal(columnName, originalTimeStamp);
		if (newTimeStamp == null)
		{
			return null;
		}

		return new Time(newTimeStamp.getTime());
			}

	public Time getTime(String columnName)
			throws SQLException
			{
		Time t = this.originalResultSet.getTime(columnName);
		if (t == null)
		{
			return null;
		}

		Timestamp originalTimeStamp = new Timestamp(t.getTime());

		Timestamp newTimeStamp = getTimeStampInternal(columnName, originalTimeStamp);
		if (newTimeStamp == null)
		{
			return null;
		}

		return new Time(newTimeStamp.getTime());
			}

	public Timestamp getTimestamp(int columnIndex)
			throws SQLException
			{
		Timestamp originalTimeStamp = this.originalResultSet.getTimestamp(columnIndex);
		if (originalTimeStamp == null)
		{
			return null;
		}

		String columnName = this.originalResultSet.getMetaData().getColumnName(columnIndex);

		return getTimeStampInternal(columnName, originalTimeStamp);
			}

	public Timestamp getTimestamp(String columnName)
			throws SQLException
			{
		Timestamp originalTimeStamp = this.originalResultSet.getTimestamp(columnName);
		if (originalTimeStamp == null)
		{
			return null;
		}

		return getTimeStampInternal(columnName, originalTimeStamp);
			}

	private Timestamp getTimeStampInternal(String columnName, Timestamp originalTimeStamp)
	{
		if (originalTimeStamp == null)
		{
			return null;
		}

		long originalTimeInMillis = originalTimeStamp.getTime();

		TimeZone serverTimeZone = TimeZone.getDefault();
		Locale serverLocale = Locale.getDefault();

		int dstSavings = 0;

		if (this.clientLocale == null)
		{
			this.clientLocale = serverLocale;
		}
		if (this.clientTimeZone == null)
		{
			this.clientTimeZone = serverTimeZone;
		}

		long serverClientDiff = this.clientTimeZone.getRawOffset() - serverTimeZone.getRawOffset();
		long adjustmentTime = dstSavings + (this.clientTimeZone.getRawOffset() - serverTimeZone.getRawOffset());

		return new Timestamp(originalTimeInMillis + (this.clientTimeZone.getOffset(originalTimeInMillis) - serverTimeZone.getOffset(originalTimeInMillis)));
	}

	public boolean next()
			throws SQLException
			{
		return this.originalResultSet.next();
			}

	public boolean wasNull() throws SQLException
	{
		return this.originalResultSet.wasNull();
	}
}
