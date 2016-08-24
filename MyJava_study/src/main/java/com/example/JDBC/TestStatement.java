package com.example.JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Administrator on 2016/8/21.
 */
public class TestStatement {
    public static Statement createStatement(Connection c) {
        Statement statement = null;
        try {
            statement = c.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statement;
    }

    public static void main(String[] args) {
        Statement statement = createStatement(new TestConnection().getConnection());
        String sql = "select user,host,password from mysql.user;";
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            while (resultSet.next()) {
                System.out.print(resultSet.getString(1) + "\t");
                System.out.print(resultSet.getString(2) + "\t");
                System.out.print(resultSet.getString(3) + "\t");
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
