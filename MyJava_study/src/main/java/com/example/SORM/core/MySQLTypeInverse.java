package com.example.SORM.core;

/**
 * 实现sql的数据类型到java的数据类型的转换
 * Created by Administrator on 2016/8/25.
 */
public class MySQLTypeInverse implements TypeConvertor {
    @Override
    public String dbType2javatype(String columnType) {
        columnType = columnType.toLowerCase();
        switch (columnType) {
            case ("int"):
            case ("smallint"):
            case ("tinyint"):
            case ("integer"):
                return "Integer";
            case "char":
            case "varchar":
                return "String";
            case "bigint":
                return "Long";
            case "double":
            case "float":
                return "Double";
            case "clob":
                return "java.sql.Clob";
            case "BlOB":
                return "java.sql.Blob";
            case "time":
                return "java.sql.Time";
            case "timestamp":
                return "java.sql.Timestamp";
            case "enum":
                return "String";
            case "date":
                return "java.sql.Date";

        }
        return null;
    }

    @Override
    //TODO 尚未实现方法
    public String javatype2dbTyep(String javadatatype) {
        return null;
    }

    /*public static void main(String[] args) {
        System.out.println(new MySQLTypeInverse().dbType2javatype("timestamp".toUpperCase()));
    }*/
}
