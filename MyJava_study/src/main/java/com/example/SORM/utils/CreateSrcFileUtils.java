package com.example.SORM.utils;


import com.example.SORM.bean.ColumnInfo;
import com.example.SORM.bean.JavaFiledGetSet;
import com.example.SORM.bean.TableInfo;
import com.example.SORM.core.DBmanager;
import com.example.SORM.core.MySQLTypeInverse;
import com.example.SORM.core.TableContent;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 操作生成源码文件
 * Created by Administrator on 2016/8/24.
 */
public class CreateSrcFileUtils {
    TableInfo tableInfo;
    List<JavaFiledGetSet> fieldList = new ArrayList<>();
    Map<String, ColumnInfo> tableColumns = new HashMap<>();
    MySQLTypeInverse inverse = new MySQLTypeInverse();

    public CreateSrcFileUtils(TableInfo tableInfo) {
        this.tableInfo = tableInfo;
        tableColumns = tableInfo.getColumns();
        for (ColumnInfo cc : tableColumns.values()
                ) {
            fieldList.add(createMethod(cc, new MySQLTypeInverse()));
        }
    }

    public String getTableName() {
        return tableInfo.getName();
    }

    public JavaFiledGetSet createMethod(ColumnInfo columnInfo, MySQLTypeInverse inverse) {
        JavaFiledGetSet methodBody = new JavaFiledGetSet();
        String fieldType = inverse.dbType2javatype(columnInfo.getDatatype());
        String fieldName = columnInfo.getName();
        String FieldName = StringUtils.toUpperLetter(columnInfo.getName());

        String fieldDeclear = "\t private fieldType fieldName ;\n";
        String getMethod = "\t public fieldType  getFieldName() {return this.fieldName;}\n";
        String setMethod = "\t public void  setFieldName( fieldType  fieldName ){ this.fieldName=fieldName;}\n";
        // 构造字段
        fieldDeclear = fieldDeclear.replaceAll("fieldType", fieldType);
        fieldDeclear = fieldDeclear.replaceAll("fieldName", fieldName);
        methodBody.setFieldInfo(fieldDeclear);
        //构造get方法
        getMethod = getMethod.replaceAll("fieldType", fieldType);
        getMethod = getMethod.replaceAll("FieldName", FieldName);
        getMethod = getMethod.replaceAll("fieldName", fieldName);
        methodBody.setGetInfo(getMethod);
        //构造set方法
        setMethod = setMethod.replaceAll("FieldName", FieldName);
        setMethod = setMethod.replaceAll("fieldType", fieldType);
        setMethod = setMethod.replaceAll("fieldName", fieldName);
        methodBody.setSetInfo(setMethod);
        return methodBody;
    }


    public StringBuilder createClassBody() {

        StringBuilder builder = new StringBuilder();
        /**
         * package  XXXXX
         * import   XXXXX
         * public class XX {
         *     public XX(){};
         *     set();
         *     get();
         * }
         */
        builder.append("package " + DBmanager.getPoPackage() + ";\n\n");
        builder.append("// 生成时间: " + new Date().toString() + "\n");
        builder.append("import java.sql.*;\n");
        builder.append("import java.util.*;\n\n\n");
        builder.append("public class " + StringUtils.toUpperLetter(tableInfo.getName()) + " {\n\n");
        for (JavaFiledGetSet ss : fieldList
                ) {
            builder.append(ss.getFieldInfo());
        }

        builder.append("\n");

        for (JavaFiledGetSet ss : fieldList
                ) {
            builder.append(ss.getGetInfo());
        }

        builder.append("\n");

        for (JavaFiledGetSet ss : fieldList
                ) {
            builder.append(ss.getSetInfo());
        }

        builder.append("\n\n");
        builder.append("}");
        // System.out.println(builder.toString());
        return builder;
    }


   /* public static void main(String[] args) {
     *//*   ColumnInfo info=new ColumnInfo("userName","varchar",0);
        System.out.println(createMethod(info,new MySQLTypeInverse()));*//*
        TableInfo tableInfo = TableContent.getDatabaseTablesMap().get("employees");
        JavaFileUtils javaFileUtils = new JavaFileUtils(tableInfo);
        javaFileUtils.createClassBody();

    }*/
}
