package com.example.SORM.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2016/8/24.
 */
public class ReflectUtils {
    /**
     * @param fieldName
     * @param o
     * @return
     */
    public static Object getMethodGetValue(String fieldName, Object o) {
        Object invoke = null;

        try {
            Class<?> aClass = o.getClass();
            Method method = aClass.getMethod("get" + StringUtils.toUpperLetter(fieldName), null);
            invoke = method.invoke(o, null);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return invoke;
    }

    public static void setMethodsetVlaue(Object beanObject, String fieldName, Object valueObject) {
        try {
            Method setMethod = beanObject.getClass().getDeclaredMethod("set" + StringUtils.toUpperLetter(fieldName), valueObject.getClass());
            setMethod.invoke(beanObject, new Object[]{valueObject});
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
