package com.hxqh.report;

public class MXReportDataSourceThreadLocalProvider
{
	private static ThreadLocal<MXReportDataSourceProvider> dataSourceProvider = new ThreadLocal()
	{
		protected synchronized MXReportDataSourceProvider initialValue()
		{
			return new MXReportDataSourceProvider();
		}
	};

	public static MXReportDataSourceProvider get()
	{
		return (MXReportDataSourceProvider)dataSourceProvider.get();
	}
}
