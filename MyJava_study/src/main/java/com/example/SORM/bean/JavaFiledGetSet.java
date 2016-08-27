package com.example.SORM.bean;

/**
 * 封装字段属性的get和set 方法
 * Created by Administrator on 2016/8/25.
 */
public class JavaFiledGetSet {
    private String fieldInfo;
    private String getInfo;
    private String setInfo;

    @Override
    public String toString() {
        return "JavaFiledGetSet{" +
                "fieldInfo='" + fieldInfo + '\'' +
                ", getInfo='" + getInfo + '\'' +
                ", setInfo='" + setInfo + '\'' +
                '}';
    }

    public JavaFiledGetSet() {
    }

    public JavaFiledGetSet(String fieldInfo, String getInfo, String setInfo) {
        this.fieldInfo = fieldInfo;
        this.getInfo = getInfo;
        this.setInfo = setInfo;
    }

    public String getFieldInfo() {
        return fieldInfo;
    }

    public void setFieldInfo(String fieldInfo) {
        this.fieldInfo = fieldInfo;
    }

    public String getGetInfo() {
        return getInfo;
    }

    public void setGetInfo(String getInfo) {
        this.getInfo = getInfo;
    }

    public String getSetInfo() {
        return setInfo;
    }

    public void setSetInfo(String setInfo) {
        this.setInfo = setInfo;
    }
}
