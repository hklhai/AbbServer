package com.hxqh.abb.common.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

import javax.persistence.Entity;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class FindXmlDoc {

	/**
	 * 
	 * @Description 鍒涘缓xml鏂囦欢
	 * @param filename
	 * @param rootElement
	 *            void
	 * @throws 鎶涘嚭寮傚父璇存槑
	 */
	public void createXMLFile(String filename, String rootElement) {

		/** 寤虹珛document瀵硅薄 */
		Document document = DocumentHelper.createDocument();

		document.addElement(rootElement);
		try {

			/** 灏哾ocument涓殑鍐呭鍐欏叆鏂囦欢涓�*/

			XMLWriter writer = new XMLWriter(new FileWriter(new File(filename)));

			writer.write(document);

			writer.close();

		} catch (Exception ex) {

		}

	}

	/**
	 * 
	 * @Description 淇濆瓨缂栬緫鐨刋ML鏂囦欢
	 * @param document
	 * @param filepath
	 * @return boolean
	 * @throws 鎶涘嚭寮傚父璇存槑
	 */
	public boolean saveDocument(Document document, String filepath) {
		boolean isOk = false;
		Writer writer = null;
		XMLWriter xmlWriter = null;
		try {
			writer = new OutputStreamWriter(new FileOutputStream(filepath),
					"utf-8");
			OutputFormat format = OutputFormat.createPrettyPrint();
			format.setEncoding("utf-8");
			xmlWriter = new XMLWriter(writer, format);
			xmlWriter.write(document);
			writer.close();
			isOk = true;
		} catch (IOException e) {

			return false;
		}
		return isOk;
	}

	/**
	 * 
	 * @Description 鑾峰彇XML鏂囦欢涓殑淇℃伅,濡傛灉鏂囦欢瀛樺湪,杩斿洖document锛屽鏋滀笉瀛樺湪,杩斿洖null
	 * @param filepath
	 * @return Document
	 * @throws 鎶涘嚭寮傚父璇存槑
	 */
	public Document getDocument(String filepath) {
		Document document = null;
		SAXReader reader = new SAXReader();
		try {
			File file = new File(filepath);
			if (file.exists()) {
				document = reader.read(file);// 涓嶆槸浠TF-8鏉ヨ鍙栥�瑕佹崲鎴愪互UTF鈥斺�8鏉ヨ鍙�

			} else {
				return null;
			}
		} catch (Exception e) {

		}
		return document;
	}
}