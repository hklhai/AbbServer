package com.hxqh.abb.common.util;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.WeakHashMap;

import sun.misc.Unsafe;

import com.thoughtworks.xstream.converters.reflection.FieldDictionary;
import com.thoughtworks.xstream.converters.reflection.ObjectAccessException;
import com.thoughtworks.xstream.converters.reflection.PureJavaReflectionProvider;

public class LocalReflectionProvider extends PureJavaReflectionProvider {

	private final static Unsafe unsafe;
	private final static Exception exception;
	// references to the Field key are kept in the FieldDictionary
	private transient Map fieldOffsetCache;
	static {
		Unsafe u = null;
		Exception ex = null;
		try {
			Field unsafeField = Unsafe.class.getDeclaredField("theUnsafe");
			unsafeField.setAccessible(true);
			u = (Unsafe) unsafeField.get(null);
		} catch (SecurityException e) {
			ex = e;
		} catch (NoSuchFieldException e) {
			ex = e;
		} catch (IllegalArgumentException e) {
			ex = e;
		} catch (IllegalAccessException e) {
			ex = e;
		}
		exception = ex;
		unsafe = u;
	}

	public LocalReflectionProvider() {
		super();
	}

	public LocalReflectionProvider(FieldDictionary dic) {
		super(dic);
	}

	public Object newInstance(Class type) {
		if (exception != null) {
			throw new ObjectAccessException("Cannot construct "
					+ type.getName(), exception);
		}
		try {
			return unsafe.allocateInstance(type);
		} catch (SecurityException e) {
			throw new ObjectAccessException("Cannot construct "
					+ type.getName(), e);
		} catch (InstantiationException e) {
			throw new ObjectAccessException("Cannot construct "
					+ type.getName(), e);
		} catch (IllegalArgumentException e) {
			throw new ObjectAccessException("Cannot construct "
					+ type.getName(), e);
		}
	}

	public void writeField(Object object, String fieldName, Object value,
			Class definedIn) {
		write(fieldDictionary.field(object.getClass(), fieldName, definedIn),
				object, value);
	}

	private void write(Field field, Object object, Object value) {
		if (exception != null) {
			throw new ObjectAccessException("Could not set field "
					+ object.getClass() + "." + field.getName(), exception);
		}
		try {
			long offset = getFieldOffset(field);
			Class type = field.getType();
			if (type.isPrimitive()) {
				if (value == null)
					unsafe.putObject(object, offset, null);
				else {
					if (type.equals(Integer.TYPE)) {
						unsafe.putInt(object, offset,
								((Integer) value).intValue());
					} else if (type.equals(Long.TYPE)) {
						unsafe.putLong(object, offset,
								((Long) value).longValue());
					} else if (type.equals(Short.TYPE)) {

						unsafe.putShort(object, offset,
								((Short) value).shortValue());
					} else if (type.equals(Character.TYPE)) {

						unsafe.putChar(object, offset,
								((Character) value).charValue());
					} else if (type.equals(Byte.TYPE)) {

						unsafe.putByte(object, offset,
								((Byte) value).byteValue());
					} else if (type.equals(Float.TYPE)) {

						unsafe.putFloat(object, offset,
								((Float) value).floatValue());
					} else if (type.equals(Double.TYPE)) {

						unsafe.putDouble(object, offset,
								((Double) value).doubleValue());
					} else if (type.equals(Boolean.TYPE)) {
						unsafe.putBoolean(object, offset,
								((Boolean) value).booleanValue());
					} else {
						throw new ObjectAccessException("Could not set field "
								+ object.getClass() + "." + field.getName()
								+ ": Unknown type " + type);
					}
				}
			} else {
				unsafe.putObject(object, offset, value);
			}

		} catch (IllegalArgumentException e) {
			throw new ObjectAccessException("Could not set field "
					+ object.getClass() + "." + field.getName(), e);
		}
	}

	private synchronized long getFieldOffset(Field f) {
		Long l = (Long) fieldOffsetCache.get(f);
		if (l == null) {
			l = new Long(unsafe.objectFieldOffset(f));
			fieldOffsetCache.put(f, l);
		}

		return l.longValue();
	}

	protected void validateFieldAccess(Field field) {
		// (overriden) don't mind final fields.
	}

	private Object readResolve() {
		init();
		return this;
	}

	protected void init() {
		super.init();
		fieldOffsetCache = new WeakHashMap();
	}
}
