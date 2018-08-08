package com.hxqh.report;

import java.util.HashMap;
import java.util.Iterator;

public class MXReportDataSourceProvider
{
	private static MXReportDataSourceThreadLocalProvider threadLocalDataSourceProvider = new MXReportDataSourceThreadLocalProvider();

	private static HashMap<String, MXReportDataSourceImpl> dataSourcesMap = new HashMap();

	HashMap<String, MXReportDataSourceImpl> getDataSourcesMap()
	{
		return dataSourcesMap;
	}

	static MXReportDataSourceImpl create(String dataSourceName)
	{
		MXReportDataSourceImpl ds = null;

		MXReportDataSourceProvider dataSourceProvider = MXReportDataSourceThreadLocalProvider.get();

		HashMap dsMap = dataSourceProvider.getDataSourcesMap();

		Object obj = dsMap.get(dataSourceName);
		if (obj == null)
		{
			ds = new MXReportDataSourceImpl();
			dsMap.put(dataSourceName, ds);
		}
		else
		{
			ds = (MXReportDataSourceImpl)obj;
		}

		ds.setName(dataSourceName);

		return ds;
	}

	static void clearDataSources()
	{
		MXReportDataSourceProvider dataSourceProvider = MXReportDataSourceThreadLocalProvider.get();

		HashMap dsMap = dataSourceProvider.getDataSourcesMap();
		Iterator dataSourceIterator = dsMap.values().iterator();
		while (dataSourceIterator.hasNext())
		{
			MXReportDataSourceImpl ds = (MXReportDataSourceImpl)dataSourceIterator.next();
			ds.close();
		}

		dsMap.clear();
	}
}

