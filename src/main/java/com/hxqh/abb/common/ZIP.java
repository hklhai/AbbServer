package com.hxqh.abb.common;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import org.apache.commons.codec.binary.Base64;

public class ZIP {

	public static byte[] byteZip(String srtZip) {
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			GZIPOutputStream gos = new GZIPOutputStream(baos);
			gos.write(srtZip.getBytes("UTF-8"));
			gos.flush();
			gos.close();
			return baos.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static String zip(String srtZip) {
		byte[] bytes = Security.encrypt(byteZip(srtZip));
		return Base64.encodeBase64String(bytes);
	}

	public static String unZip(String data) throws Exception {// 解码解压缩（zcx)
		byte[] ZipData;
		ByteArrayOutputStream baos;
		try {
			ZipData = Security.decrypt(Base64.decodeBase64(data));// BASE64解码
			baos = new ByteArrayOutputStream();
			InputStream is = new ByteArrayInputStream(ZipData);
			GZIPInputStream gzis = new GZIPInputStream(is);
			int num = -1;
			byte[] buf = new byte[1024];
			while ((num = gzis.read(buf, 0, buf.length)) != -1) { // 如果文件未读完
				baos.write(buf, 0, num); // 写入缓冲数据到输出流
			}
			return baos.toString("UTF-8");
		} catch (IOException e) {
			throw new Exception("数据解压缩失败");
		}
	}

}