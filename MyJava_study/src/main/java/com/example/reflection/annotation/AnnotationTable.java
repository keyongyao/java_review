package com.example.reflection.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注释类
 * Created by Administrator on 2016/8/14.
 */
@Target(value = {ElementType.TYPE})  // 用于表结构和类转换，不能修饰其它
@Retention(RetentionPolicy.RUNTIME)
public @interface AnnotationTable {
    String value();
}
