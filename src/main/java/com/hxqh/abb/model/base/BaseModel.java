package com.hxqh.abb.model.base;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;

import com.hxqh.abb.common.ZIP;
import com.hxqh.abb.common.util.DateTimeConverter;
import com.hxqh.abb.common.util.LocalReflectionProvider;
import com.hxqh.abb.common.util.NullBigDecimalConverter;
import com.hxqh.abb.common.util.NullLongConverter;
import org.apache.log4j.Logger;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.mapper.MapperWrapper;


public abstract class BaseModel implements Serializable {
	private static final long serialVersionUID = 2387253001746505718L;
	
	private final static Logger logger = Logger.getLogger(BaseModel.class);
	// date formats
	protected static final String DATE_FORMAT = "yyyy-MM-dd";

	protected static final String TIME_FORMAT = "HH:mm:ss";

	protected static final String DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";

	protected static final String TIMESTAMP_FORMAT = "yyyy-MM-dd HH:mm:ss.S";

	/**
	 * convert this object to it`s xml description
	 * 
	 * @param needCompress
	 *            true String should be compressed compress
	 * 
	 * @return String xml string converted no need to save as xml
	 * @throws UnsupportedEncodingException
	 */
	public String asXML(boolean needCompress) {
		XStream xstream = new XStream(new DomDriver("UTF-8"));
		xstream.registerConverter(new DateTimeConverter(DATE_TIME_FORMAT, null));
		xstream.registerConverter(new NullBigDecimalConverter());
		xstream.registerConverter(new NullLongConverter());
		xstream.autodetectAnnotations(true);    
		setConvertRules(xstream);
		String s = xstream.toXML(this);

		if (needCompress) {
			s = ZIP.zip(s);
		}
		logger.trace(this.getClass().getName() + "-->序列化为---->" + s);
		return s;
	}

	/**
	 * build the object from the xml input stream
	 * 
	 * @param input
	 *            xml format String
	 * @return obj no need to restore from xml
	 * @throws Exception
	 */
	public Object fromXML(String input) throws Exception {
		return fromXML(input, true);
	}

	/**
	 * build the object from the xml input stream
	 * 
	 * @param input
	 *            xml format String
	 * @param needUnCompress
	 *            true String need compress
	 * @return
	 * @throws Exception
	 */
	public Object fromXML(String input, boolean needUnCompress)
			throws Exception {
		XStream xstream = new XStream(new LocalReflectionProvider(),new DomDriver("UTF-8")) {
			protected MapperWrapper wrapMapper(MapperWrapper next) {
				return new MapperWrapper(next) {
					@SuppressWarnings("rawtypes")
					public boolean shouldSerializeMember(Class definedIn,
							String fieldName) {
						return definedIn != Object.class ? super
								.shouldSerializeMember(definedIn, fieldName)
								: false;
					}
				};
			}
		};

		xstream.registerConverter(new DateTimeConverter(DATE_TIME_FORMAT, null));
		xstream.registerConverter(new NullBigDecimalConverter());
		xstream.registerConverter(new NullLongConverter());
		xstream.autodetectAnnotations(true);
		setConvertRules(xstream);
		Object obj = null;
		if (needUnCompress) {
			input = ZIP.unZip(input);
		}
		obj = xstream.fromXML(input);
		return obj;
	}
	/**
	 * set convert rules
	 * 
	 * @param xstream
	 */
	
	protected abstract  void setConvertRules(XStream xstream);

	/**
	 * set convert rules
	 * 
	 * @param xstream
	 */
	

}
