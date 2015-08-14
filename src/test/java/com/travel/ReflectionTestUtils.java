package com.travel;


import java.lang.reflect.Field;

import org.unitils.util.ReflectionUtils;

public class ReflectionTestUtils {

	public static void setField(Object target, String fieldName, Object value){
		Field field = ReflectionUtils.getFieldWithName(target.getClass(), fieldName, false);
		if(field == null) throw new RuntimeException("Field not found " + fieldName);
		ReflectionUtils.setFieldValue(target, field, value);
	}
}
