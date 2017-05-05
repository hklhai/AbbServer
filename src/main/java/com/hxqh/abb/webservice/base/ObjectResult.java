package com.hxqh.abb.webservice.base;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

public class ObjectResult<T> extends Result implements Serializable {

	private static final long serialVersionUID = 1420807289982550746L;

	@XStreamOmitField
	private Map<String, String> mapClass;

	@Override
	protected void setConvertRules(XStream xstream) {
		xstream.alias("ObjectResult", ObjectResult.class);

		if (resultObject != null) {
			xstream.alias(resultObject.getClass().getSimpleName(),
					resultObject.getClass());
		}
		if (mapClass != null) {
			for (String name : mapClass.keySet()) {
				try {
					xstream.alias(mapClass.get(name), Class.forName(name));
				} catch (ClassNotFoundException e) {
				}
			}
			xstream.autodetectAnnotations(true);

		}
		if (resultObject instanceof List && ((List<?>) resultObject).size() > 0) {
			List<?> list = (List<?>) resultObject;
			xstream.alias(list.get(0).getClass().getSimpleName(), list.get(0)
					.getClass());
		}
		xstream.alias("string", String.class);
		xstream.alias("map", LinkedHashMap.class);

		//TODO   暂时添加
//		if (resultObject instanceof ProductInfoAssistantObj) {
//			xstream.alias("ProductistcObj", ProductistcObj.class);
//			xstream.alias("TransferuserObj", TransferuserObj.class);
//			xstream.alias("PrefixinfoObj", PrefixinfoObj.class);
//		}
		
		xstream.setMode(XStream.NO_REFERENCES);
	}

	private T resultObject;

	public void setMapClass(Map<String, String> mapClass) {
		this.mapClass = mapClass;
	}

	public T getResultObject() {
		return resultObject;
	}

	public void setResultObject(T resultObject) {
		this.resultObject = resultObject;
	}
}
