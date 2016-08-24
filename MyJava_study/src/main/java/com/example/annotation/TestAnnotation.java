package com.example.annotation;

/**
 * 注释可以被编译器读懂 用户 包 类 方法 字段
 * Created by Administrator on 2016/8/14.
 */
public class TestAnnotation {

    @MyAnnotation(name = "kyy", age = 18, address = "earth")
    public String toString() {
        return super.toString();
    }
}
