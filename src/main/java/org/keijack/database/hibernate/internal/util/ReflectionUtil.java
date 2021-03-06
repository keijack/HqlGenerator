package org.keijack.database.hibernate.internal.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.keijack.database.hibernate.HqlGeneratException;

/**
 * Util Class
 * 
 * @author keijack.wu
 * 
 */
public final class ReflectionUtil {

	/**
	 * Util, cannot be instanced.
	 */
	private ReflectionUtil() {
		super();
	}

	/**
	 * 获得一个类给定类型的标注
	 * 
	 * @param <T>                获取一个标注
	 * @param object           需要获取标注的对象
	 * @param requiredAnnoType 需要获取的标注的类型
	 * @return 返回标注或者 Null
	 */
	public static <T extends Annotation> T getClassAnnotationRecursively(
			Object object, Class<T> requiredAnnoType) {
		Class<?> currentClass = object.getClass();
		while (!currentClass.equals(Object.class)) {
			T anno = currentClass.getAnnotation(requiredAnnoType);
			if (anno != null) {
				return anno;
			}
			currentClass = currentClass.getSuperclass();
		}
		return null;
	}

	public static List<Field> getFieldsWithGivenAnnotationRecursively(
			Class<?> objectClass, Class<? extends Annotation> givenAnnotation) {
		final List<Field> fields = new ArrayList<>();
		Class<?> currentClass = objectClass;
		while (!currentClass.equals(Object.class)) {
			final Field[] declaredFields = currentClass.getDeclaredFields();
			for (Field field : declaredFields) {
				if (field.getAnnotation(givenAnnotation) != null) {
					fields.add(field);
				}
			}
			currentClass = currentClass.getSuperclass();
		}
		return fields;
	}

	/**
	 * @param obj   对象
	 * @param field 域
	 * @return 通过 get 方法获取的值
	 */
	public static Object getFieldValueViaGetMethod(Object obj, String field) {
		String fildName = field;
		fildName = fildName.substring(0, 1).toUpperCase()
				+ fildName.substring(1);
		Method getMethod;
		try {
			getMethod = obj.getClass().getMethod("get" + fildName);
			return getMethod.invoke(obj);
		} catch (Exception e) {
			throw new HqlGeneratException(e);
		}
	}
}
