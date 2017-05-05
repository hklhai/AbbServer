package com.hxqh.abb.common.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ObjectHelper {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static <T> T beanClone(Class fromClass, Object fromObj,
			Class toClass) throws Exception {
		T toObj = (T) toClass.newInstance();
		beanClone(fromClass, fromObj, toClass, toObj);
		return toObj;
	}
	
	public static void beanClone(Class<?> fromClass, Object fromObj,
			Class<?> toClass, Object toObj) throws Exception {
		Field[] fields = fromClass.getDeclaredFields();

		for (Field field : fields) {
			Class<?>[] cla = new Class<?>[0];
			String filedName = field.getName();
			String ufilename = filedName.substring(0, 1).toUpperCase()
					+ filedName.substring(1);
			String getfiledMethodName = "get" + ufilename;
			String setfiledMethodName = "set" + ufilename;
			try {
				Method getMethod = fromClass.getMethod(getfiledMethodName, cla);
				Object f = getMethod.invoke(fromObj);
				if (f != null) {
					Class<?> type = getMethod.getReturnType();
					Method setMethod = toClass.getMethod(setfiledMethodName,
							new Class[] { type });
					setMethod.invoke(toObj, new Object[] { f });
				}
			} catch (NoSuchMethodException e) {
			}

		}
	}

	public static <T extends Serializable> byte[] getBytes(T value)
			throws IOException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(out);
		oos.writeObject(value);
		return out.toByteArray();
	}
	
	@SuppressWarnings("unchecked")
	public static <T extends Serializable> T getObject(byte[] bytes)
			throws IOException, ClassNotFoundException {
		ByteArrayInputStream in = new ByteArrayInputStream(bytes);
		ObjectInputStream ois = new ObjectInputStream(in);
		return (T) ois.readObject();
	}

}
