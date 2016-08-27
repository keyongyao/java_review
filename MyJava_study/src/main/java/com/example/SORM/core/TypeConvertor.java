package com.example.SORM.core;

/**
 * java 数据库类型 和 数据库数据类型  之间相互转换
 * Created by Administrator on 2016/8/24.
 */
public interface TypeConvertor {
    public String dbType2javatype(String columnType);

    public String javatype2dbTyep(String javadatatype);

}
