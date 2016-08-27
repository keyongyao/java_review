package com.example.SORM.core;

import com.example.SORM.bean.Configuration;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 读取 properties 文件获取配置信息，初始化数据库连接
 * Created by Administrator on 2016/8/24.
 */
public class DBmanager {
    public static Configuration connectionConfig = new Configuration();

    public static String getPoPackage() {
        return connectionConfig.getPoPackage();
    }

    public static String getSrcpath() {
        return connectionConfig.getPoPackage();
    }

    //类初始化时，执行
    static {
        Properties properties = new Properties();
        try {
            properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
            connectionConfig.setDriver(properties.getProperty("driver"));
            connectionConfig.setUser(properties.getProperty("user"));
            connectionConfig.setPwd(properties.getProperty("pwd"));
            connectionConfig.setUsingDB(properties.getProperty("usingDB"));
            connectionConfig.setPoPackage(properties.getProperty("poPackage"));
            connectionConfig.setSrcPath(properties.getProperty("srcPath"));
            connectionConfig.setUrl(properties.getProperty("url"));
            System.out.println("数据库连接配置获取成功");
        } catch (IOException e) {
            System.err.println("数据库初始化参数失败");
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName(connectionConfig.getDriver());
            con = DriverManager.getConnection(connectionConfig.getUrl(), connectionConfig.getUser(), connectionConfig.getPwd());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

}




