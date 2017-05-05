package com.hxqh.abb.common.util;

import com.thoughtworks.xstream.converters.basic.LongConverter;

public class NullLongConverter extends LongConverter {
	
	@Override
	public boolean canConvert(Class type) {
		
		return super.canConvert(type);
	}

	@Override
	public Object fromString(String str) {
		
		if(null==str||"".equals(str))
			return null;
		return super.fromString(str);
	}
}
