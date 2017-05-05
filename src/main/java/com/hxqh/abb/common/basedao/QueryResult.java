package com.hxqh.abb.common.basedao;

import java.io.ByteArrayOutputStream;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import com.hxqh.abb.common.ZIP;
import com.hxqh.abb.webservice.base.DatagridResult;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

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

	public DatagridResult getDatagridResult(String[] fields) throws Exception {
		return this.getDatagridResult(fields, null);
	}

	public DatagridResult getDatagridResult(
			Map<String, Object> fieldMap) throws Exception {
		return this.getDatagridResult(fieldMap.keySet().toArray(new String[1]),
				fieldMap);
	}

	private DatagridResult getDatagridResult(String[] fields,
			Map<String, Object> fieldMap) throws Exception {
		DatagridResult result = new DatagridResult();
		String tableschema = "";
		String resulttable = "";

		try {
			// 使用 DocumentHelper 类创建一个文档实例。 DocumentHelper 是生成 XML 文档节点的 dom4j
			// API
			// 工厂类

			Document document = DocumentHelper.createDocument();
			document.setXMLEncoding("UTF-8");
			// 使用 addElement() 方法创建根元素 catalog 。 addElement() 用于向 XML 文档中增加元素

			Element rootDataElement = document.addElement("xs:schema");
			rootDataElement.addNamespace("", "");
			rootDataElement.addNamespace("xs",
					"http://www.w3.org/2001/XMLSchema");
			rootDataElement.addNamespace("msdata",
					"urn:schemas- microsoft-com:xml-msdata");
			Element element = rootDataElement.addElement("xs:element");
			element.addAttribute("name", "NewDataSet");
			element.addAttribute("msdata:IsDataSet", "true");
			element.addAttribute("msdata:MainDataTable", "Table1");
			element.addAttribute("msdata:UseCurrentLocale", "true");
			Element complexType = element.addElement("xs:complexType");
			Element choice = complexType.addElement("xs:choice");
			choice.addAttribute("minOccurs", "0");
			choice.addAttribute("maxOccurs", "unbounded");
			Element sElement = choice.addElement("xs:element");
			sElement.addAttribute("name", "Table1");
			Element sComplexType = sElement.addElement("xs:complexType");
			Element sequence = sComplexType.addElement("xs:sequence");
			for (String field : fields) {
				if (fieldMap != null) {
					Object fieldItem = fieldMap.get(field);
					if (fieldItem != null
							&& String.class.isAssignableFrom(fieldItem
									.getClass())) {
						if ("hide".equals(fieldItem))
							continue;
					}
				}
				Element elementItem = sequence.addElement("xs:element");
				elementItem.addAttribute("name", field);
				elementItem.addAttribute("type", "xs:string");
				elementItem.addAttribute("minOccurs", "0");

			}

			// 格式化输出

			OutputFormat outFmt = new OutputFormat("    ", true);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			XMLWriter xmlWriter = new XMLWriter(baos, outFmt);
			xmlWriter.write(document);
			xmlWriter.close();
			tableschema = baos.toString("UTF-8");

			document.clearContent();
			// 使用 addElement() 方法创建根元素 catalog 。 addElement() 用于向 XML 文档中增加元素

			rootDataElement = document.addElement("DocumentElement");

			// 生成列表单元格的显示内容
			for (T record : resultlist) {
				element = rootDataElement.addElement("Table1");
				addData(fields, fieldMap, element, record);
			}

			// 格式化输出

			outFmt = new OutputFormat("    ", true);
			baos = new ByteArrayOutputStream();
			xmlWriter = new XMLWriter(baos, outFmt);
			xmlWriter.write(document);
			xmlWriter.close();
			resulttable = baos.toString("UTF-8");
			baos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		result.setTableschema(ZIP.zip(tableschema));
		result.setResulttable(ZIP.zip(resulttable));
		result.setRecordtotal(((Long) recordtotal).toString());
		return result;
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
