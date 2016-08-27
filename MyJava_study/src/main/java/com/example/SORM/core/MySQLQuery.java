package com.example.SORM.core;

import com.example.SORM.bean.ColumnInfo;
import com.example.SORM.bean.TableInfo;
import com.example.SORM.po.Employees;
import com.example.SORM.utils.JDBCUtils;
import com.example.SORM.utils.ReflectUtils;
import com.example.SORM.utils.StringUtils;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 实现Query接口
 * Created by Administrator on 2016/8/26.
 */
public class MySQLQuery implements Query {
    @Override
    public int executeDML(String SQL, Object[] parma) {
        Connection con = DBmanager.getConnection();
        int rowCount = 0;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = con.prepareStatement(SQL);
            JDBCUtils.handleParam(preparedStatement, parma);
            rowCount = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeAll(preparedStatement, con);
        }
        return rowCount;
    }

    @Override
    public void insert(Object o) {
        Class<?> aClass = o.getClass();
        TableInfo tableInfo = TableContent.getClassMapTable().get(aClass);
        StringBuilder sql = new StringBuilder("insert into " + tableInfo.getName() + " (");
        Field[] declaredFields = aClass.getDeclaredFields();
        List<Object> valueList = new ArrayList<>();
        int valueCount = 0;
        for (Field ff : declaredFields
                ) {
            String fieldName = ff.getName();
            Object fieldValue = ReflectUtils.getMethodGetValue(fieldName, o);
            if (fieldValue != null) {
                valueCount++;
                sql.append(fieldName + ",");
                valueList.add(fieldValue);
            }
        }
        sql.setCharAt(sql.length() - 1, ')');
        sql.append(" values(");
        for (int i = 0; i < valueCount; i++) {
            sql.append("?,");
        }
        sql.setCharAt(sql.length() - 1, ')');
        // System.out.println(sql.toString());
        executeDML(sql.toString(), valueList.toArray());
    }

    @Override
    public void delete(Class aClass, Object id) {
        TableInfo tableInfo = TableContent.getClassMapTable().get(aClass);
        ColumnInfo priKey = tableInfo.getOnlyPRIkey();
        String sql = "delete  from " + tableInfo.getName() + " where " + priKey.getName() + "=?;";
        executeDML(sql, new Object[]{id});
    }

    @Override
    public void delete(Object o) {
        Class<?> aClass = o.getClass();
        TableInfo tableInfo = TableContent.getClassMapTable().get(aClass);
        ColumnInfo priKey = tableInfo.getOnlyPRIkey();
        Object priKeyValue = ReflectUtils.getMethodGetValue(priKey.getName(), o);
        delete(aClass, priKeyValue);

    }

    @Override
    public int update(Object o, String[] filedNames) {
        // update table set field = ?,field2=?  where id=?;
        Class<?> aClass = o.getClass();
        TableInfo tableInfo = TableContent.getClassMapTable().get(aClass);
        String tableName = tableInfo.getName();

        StringBuilder sql = new StringBuilder("update " + tableName + " set ");
        List<Object> valuesList = new ArrayList<>();
        for (String fd : filedNames
                ) {
            Object fieldValue = ReflectUtils.getMethodGetValue(fd, o);
            if (fieldValue != null) {
                sql.append(fd + "=? ,");
                valuesList.add(fieldValue);
            }
        }
        sql.setCharAt(sql.length() - 1, ' ');

        //设置 where  语句
        ColumnInfo onlyPRIkey = tableInfo.getOnlyPRIkey();
        Object priKeyValue = ReflectUtils.getMethodGetValue(onlyPRIkey.getName(), o);
        sql.append("where " + onlyPRIkey.getName() + "=? ");
        //TODO  是修改的ID 设定更加灵活
        valuesList.add(priKeyValue); //确定要修改的 ID

        System.out.println(sql.toString());
        return executeDML(sql.toString(), valuesList.toArray());
    }

    @Override
    public List queryRows(String sql, Class aClass, Object[] param) {
        Connection con = DBmanager.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Object> beansList = null;
        try {
            preparedStatement = con.prepareStatement(sql);
            JDBCUtils.handleParam(preparedStatement, param);  // 处理占位符
            resultSet = preparedStatement.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();

            while (resultSet.next()) {
                if (beansList == null)
                    beansList = new ArrayList<>();
                Object beanObject = aClass.newInstance();
                for (int i = 0; i < metaData.getColumnCount(); i++) {
                    String fieldName = metaData.getColumnLabel(i + 1);
                    Object valueObject = resultSet.getObject(i + 1);
                    ReflectUtils.setMethodsetVlaue(beanObject, fieldName, valueObject);
                }
                beansList.add(beanObject);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeAll(resultSet, preparedStatement, con);
        }
        return beansList;
    }

    @Override
    public Object queryUniqueRows(String sql, Class aClass, Object[] param) {
        List list = queryRows(sql, aClass, param);
        return (list != null) ? list.get(0) : null;
    }

    @Override
    public Object queryvalue(String sql, Object[] param) {
        Connection con = DBmanager.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Object value = null;
        try {
            preparedStatement = con.prepareStatement(sql);
            JDBCUtils.handleParam(preparedStatement, param);  // 处理占位符
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                value = resultSet.getObject(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeAll(resultSet, preparedStatement, con);
        }

        return value;
    }

    @Override
    public Number queryNumber(String sql, Object[] param) {
        return (Number) queryvalue(sql, param);
    }


    public static void main(String[] args) {
        /*Employees employees=new Employees();
        employees.setEmp_no(10001);
        new MySQLQuery().delete(employees);
        new MySQLQuery().delete(Employees.class,10003);*/
        /*Employees employees=new Employees();
        employees.setEmp_no(10002);
        employees.setBirth_date(new java.sql.Date(System.currentTimeMillis()-(1000*60*60*24*365)));
        employees.setFirst_name("KK");
        employees.setGender("F");
        employees.setLast_name("YongYao");
       new MySQLQuery().update(employees,new String[]{"birth_date","first_name","gender","last_name"});*/

        String sql = "select * from employees limit ?";
        List list = new MySQLQuery().queryRows(sql, Employees.class, new Object[]{300});

        for (Object ee : list
                ) {
            System.out.println(((Employees) ee).getEmp_no() + "  " + ((Employees) ee).getFirst_name() + " " + ((Employees) ee).getLast_name());
        }
    }
}
