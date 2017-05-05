package com.hxqh.abb.webservice.base;


import com.hxqh.abb.model.base.BaseModel;
import com.thoughtworks.xstream.XStream;

public class DatagridResult extends BaseModel implements java.io.Serializable {

	private static final long serialVersionUID = -4321668359074804261L;
	
	private String recordtotal;
	private String resulttable;
	private String tableschema;

	public String getTableschema() {
		return tableschema;
	}

	public void setTableschema(String tableschema) {
		this.tableschema = tableschema;
	}

	@Override
	protected void setConvertRules(XStream xstream) {
		xstream.alias("DatagridResult", DatagridResult.class);
		xstream.setMode(XStream.NO_REFERENCES);
	}
	
	public void initResultTable() {
		
	}

	public String getRecordtotal() {
		return recordtotal;
	}

	public void setRecordtotal(String recordtotal) {
		this.recordtotal = recordtotal;
	}

	public String getResulttable() {
		return resulttable;
	}

	public void setResulttable(String resulttable) {
		this.resulttable = resulttable;
	}

}
