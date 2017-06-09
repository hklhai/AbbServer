package com.hxqh.abb.common.basedao;

import org.apache.log4j.Logger;
import org.dom4j.Element;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

public class QueryResult<T> {
	
	private final static Logger logger = Logger
			.getLogger(QueryResult.class);
	
	private List<T> resultlist;
	private long recordtotal;

	public void setResultlist(List<T> resultlist) {
		this.resultlist = resultlist;
	}

	public List<T> getResultlist() {
		return resultlist;
	}

	public void setRecordtotal(long recordtotal) {
		this.recordtotal = recordtotal;
	}

	public long getRecordtotal() {
		return recordtotal;
	}


	@SuppressWarnings("unchecked")
	private void addData(String[] fields,
                         Map<String, Object> fieldMap, Element element, T record)
			throws Exception {
		Class<T> cla = (Class<T>) resultlist.get(0).getClass();

		for (String field : fields) {
			Object fieldItem = null;
			if (fieldMap != null) {
				fieldItem = fieldMap.get(field);
				if (fieldItem != null
						&& String.class.isAssignableFrom(fieldItem
								.getClass())) {
					if ("hide".equals(fieldItem))
						continue;
				}
			}
			
			Object obj;
			if (Map.class.isAssignableFrom(cla)) {
				if(field.lastIndexOf(".")>=0)
					field=field.substring(field.lastIndexOf(".")+1);
				obj = ((Map<String, Object>) record).get(field);
			} else {
				String methodName = "get" + field.substring(0, 1).toUpperCase()
						+ field.substring(1).toLowerCase();
				Method m = cla.getMethod(methodName);
				obj = m.invoke(record, new Object[] {});
			}

			String text = buildData(field, fieldItem, obj, record);

			element.addElement(field).addText(text);
		}
	}
	
	@SuppressWarnings("unchecked")
	private String buildData(String field,
                             Object fieldItem, Object data, T record) {
		if(field.lastIndexOf(".")>=0)
			field=field.substring(field.lastIndexOf(".")+1);
		if (data == null) return "";
		String text = "";
		if (fieldItem != null){
			if(Map.class.isAssignableFrom(fieldItem.getClass())){
				Map<Object, String> map = (Map<Object, String>) fieldItem;
				text = map.get(data);
			}else if((Method.class.isAssignableFrom(fieldItem.getClass()))){
				Method method = (Method) fieldItem;
				try {
					text = (String) method.invoke(null, data, record);
				} catch (Exception e) {
					logger.error(e);
				}
			}
		} else {
			text = data.toString();
		}
		return text;
	}
}
