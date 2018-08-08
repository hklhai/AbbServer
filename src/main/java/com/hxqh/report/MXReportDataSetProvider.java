package com.hxqh.report;

public class MXReportDataSetProvider
{
	public static MXReportDataSet create(String dataSourceName, String dataSetName)
	{
		MXReportDataSourceImpl ds = null;

		ds = MXReportDataSourceProvider.create(dataSourceName);
		return ds.getDataSet(dataSetName);
	}

	static void clearDataSources()
	{
		MXReportDataSourceProvider.clearDataSources();
	}
}
