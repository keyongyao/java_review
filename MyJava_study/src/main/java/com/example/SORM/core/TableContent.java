package com.example.SORM.core;

import com.example.SORM.bean.ColumnInfo;
import com.example.SORM.bean.TableInfo;
import com.example.SORM.utils.StringUtils;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 保存整个数据库的所有表的结构
 * Created by Administrator on 2016/8/24.
 */
public class TableContent {
    /**
     * 表信息和字符串对应
     */
    public static Map<String, TableInfo> databaseTablesMap = new HashMap<>();
    /**
     * 表信息和类名对应
     */
    public static Map<Class, TableInfo> classMapTable = new HashMap<>();


    public static Map<String, TableInfo> getDatabaseTablesMap() {
        return databaseTablesMap;
    }

    public static Map<Class, TableInfo> getClassMapTable() {
        return classMapTable;
    }


    private TableContent() {
    }

    static {
        try {
            Connection con = DBmanager.getConnection();
            DatabaseMetaData databaseMetaData = con.getMetaData();
            ResultSet tables = databaseMetaData.getTables(null, "%", "%", new String[]{"TABLE"});
            while (tables.next()) {
                //处理表
                String tbname = (String) tables.getObject("TABLE_NAME");
                TableInfo tableInfo = new TableInfo(tbname, new HashMap<String, ColumnInfo>(), new ArrayList<ColumnInfo>());
                databaseTablesMap.put(tbname, tableInfo);
                //处理列
                ResultSet columns = databaseMetaData.getColumns(null, "%", tbname, "%");
                while (columns.next()) {
                    ColumnInfo columnInfo = new ColumnInfo(columns.getString("COLUMN_NAME"), columns.getString("TYPE_NAME"), 0);
                    tableInfo.getColumns().put(columns.getString("COLUMN_NAME"), columnInfo);
                }
                //处理主键
                ResultSet primaryKeys = databaseMetaData.getPrimaryKeys(null, "%", tbname);
                while (primaryKeys.next()) {
                    ColumnInfo columnInfo = tableInfo.getColumns().get(primaryKeys.getString("COLUMN_NAME"));
                    columnInfo.setKeyType(1);
                    tableInfo.getPriKeys().add(columnInfo);

                }
                if (tableInfo.getPriKeys().size() > 0) {
                    tableInfo.setOnlyPRIkey(tableInfo.getPriKeys().get(0));
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        loadTablesClass();
    }

    public static void main(String[] args) {

        System.out.println(classMapTable.keySet().toString());
        System.out.println(classMapTable.values().toString());

    }

    public static void loadTablesClass() {
        String packageName = DBmanager.connectionConfig.getPoPackage() + ".";
        for (String f : databaseTablesMap.keySet()
                ) {
            String className = packageName + StringUtils.toUpperLetter(f);
            Class<?> aClass = null;
            try {

                aClass = Class.forName(className);

            } catch (ClassNotFoundException e) {
                System.err.println("找不到类：" + className);
                e.printStackTrace();
            }
            TableInfo tableInfo = databaseTablesMap.get(f);
            classMapTable.put(aClass, tableInfo);
        }
    }

}
