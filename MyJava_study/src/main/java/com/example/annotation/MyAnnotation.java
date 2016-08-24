package com.example.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解，给编译器看
 * Created by Administrator on 2016/8/14.
 */
@Target(value = {ElementType.METHOD, ElementType.PACKAGE, ElementType.TYPE})  //annotation生效的方位
@Retention(value = RetentionPolicy.RUNTIME) //annotation生效的时间
public @interface MyAnnotation {
    String name();   //注释的属性方法

    int age();

    String address() /** default "earth" **/
            ;   //确定一个默认值

}
