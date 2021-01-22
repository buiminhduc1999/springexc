package com.example.demo.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Converter {
    public static Object getMethod(Object object, Field field) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String fieldName = field.getName();
        fieldName = fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);

        String getMethodName = "get" + fieldName;

        Method method = object.getClass().getMethod(getMethodName);

        return method.invoke(object);
    }

    public static void setMethod(Object object, Field field, Object fieldData) throws IllegalAccessException {
        field.setAccessible(true);
        field.set(object, fieldData);
    }

    public static Field getFieldByName(Class clazz, String fieldName) throws NoSuchFieldException {
        return clazz.getDeclaredField(fieldName);
    }

    public static void copyProperties(Object source, Object destination) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Field[] fields = source.getClass().getDeclaredFields();
        Field[] fieldsDestination = destination.getClass().getDeclaredFields();

        for (int i = 0; i < fields.length; i++) {
            for (int j = 0; j < fieldsDestination.length; j++) {
                if (fields[i].getName().equals(fieldsDestination[j].getName())) {
                    Object fieldData = getMethod(source, fields[i]);
                    setMethod(destination, fieldsDestination[j], fieldData);
                }
            }
        }
    }
}
