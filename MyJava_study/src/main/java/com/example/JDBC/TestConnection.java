package com.example.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 测试JDBC mysql的链接
 * Created by Administrator on 2016/8/21.
 */
public class TestConnection {

    public Connection getConnection() {
        Connection connection = null;
        try {
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //打开连接
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mysql", "root", "");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }


}
