package com.example.SORM.bean;

/**
 * 封装列的信息：列名  数据类型  主键类型
 * Created by Administrator on 2016/8/24.
 */
public class ColumnInfo {
    private String name;
    private String datatype;

    private int keyType;

    /**
     * @keyType 0：普通键 1：主键 2：外键
     */
    public ColumnInfo() {
    }

    public ColumnInfo(String name, String datatype, int keyType) {
        this.name = name;
        this.datatype = datatype;
        this.keyType = keyType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDatatype() {
        return datatype;
    }

    public void setDatatype(String datatype) {
        this.datatype = datatype;
    }

    public int getKeyType() {
        return keyType;
    }

    public void setKeyType(int keyType) {
        this.keyType = keyType;
    }
}
