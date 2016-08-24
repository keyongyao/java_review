package com.example.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 使用占位符，捏造SQL语句
 * Created by Administrator on 2016/8/21.
 */
public class TestPrepaireStatement {
    public static void main(String[] args) {
        Connection connection = new TestConnection().getConnection();
        String sql = "select  ?,? from mysql.user";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {

            statement = connection.prepareStatement(sql);
            statement.setObject(1, "user");
            statement.setObject(2, "host");
            System.out.println(statement.toString());
            statement.execute();

            resultSet = statement.getResultSet();

            while (resultSet.next()) {
                System.out.print(resultSet.getString(1) + "\t");
                System.out.println(resultSet.getString(2) + "\t");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null)
                    resultSet.close();
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

    }
}
