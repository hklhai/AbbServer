package com.hxqh.abb.webservice.base;

import java.util.Map;


import com.hxqh.abb.model.base.BaseModel;
import com.thoughtworks.xstream.XStream;

public class BaseParameters<T> extends BaseModel implements java.io.Serializable {
	
	private static final long serialVersionUID = 6155671816200239554L;
	
	private Map<String, String> paras;
	private String userId;
	private String password;
	private String modelId;
	private T dataObject;

	@Override
	protected void setConvertRules(XStream xstream) {
		xstream.alias("BaseParameters", BaseParameters.class);
		xstream.setMode(XStream.NO_REFERENCES);
	}

	public Map<String, String> getParams() {
		return paras;
	}

	public void setParams(Map<String, String> params) {
		this.paras = params;
	}	

	public T getDataObject() {
		return dataObject;
	}

	public void setDataObject(T dataObject) {
		this.dataObject = dataObject;
	}

	public Map<String, String> getParas() {
		return paras;
	}

	public void setParas(Map<String, String> paras) {
		this.paras = paras;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getModelId() {
		return modelId;
	}

	public void setModelId(String modelId) {
		this.modelId = modelId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
