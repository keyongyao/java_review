package com.example.SORM.bean;

import java.util.List;
import java.util.Map;

/**
 * 封装表的结构  许多列  主键信息
 * Created by Administrator on 2016/8/24.
 */
public class TableInfo {


    private String name;
    /**
     * @name 表名
     */
    private Map<String, ColumnInfo> columns;
    /**
     * @columns 表的列名
     */
    private ColumnInfo onlyPRIkey;

    /**
     * @onlyPRIkey 主键
     */
    private List<ColumnInfo> priKeys;

    @Override
    public String toString() {
        return "TableInfo{" +
                "name='" + name + '\'' +
                ", columns=" + columns +
                ", onlyPRIkey=" + onlyPRIkey +
                ", priKeys=" + priKeys +
                '}';
    }

    public List<ColumnInfo> getPriKeys() {
        return priKeys;
    }

    public TableInfo(String name, Map<String, ColumnInfo> columns, List<ColumnInfo> priKeys) {
        this.name = name;
        this.columns = columns;
        this.priKeys = priKeys;
    }

    public TableInfo() {
    }

    public TableInfo(String name, Map<String, ColumnInfo> columns, ColumnInfo onlyPRIkey) {
        this.name = name;
        this.columns = columns;
        this.onlyPRIkey = onlyPRIkey;
    }

    public Map<String, ColumnInfo> getColumns() {
        return columns;
    }

    public void setColumns(Map<String, ColumnInfo> columns) {
        this.columns = columns;
    }

    public ColumnInfo getOnlyPRIkey() {
        return onlyPRIkey;
    }

    public void setOnlyPRIkey(ColumnInfo onlyPRIkey) {
        this.onlyPRIkey = onlyPRIkey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
