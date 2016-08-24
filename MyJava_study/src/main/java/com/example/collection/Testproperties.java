package com.example.collection;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * hashMap hashTable  区别：父类不同 线程安全不同 效率不同，健与值 是否可谓非空
 * Created by Administrator on 2016/8/2.
 */
public class Testproperties {
    void readProperties() {
        Properties properties = new Properties();
        try {
            properties.load(new FileReader("outFile/properties.pro"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(properties.toString());
    }

    void test() {
        Properties properties
                = new Properties();
        //     properties.setProperty("dirver", "Oracle:Dirver");
        properties.setProperty("url", "baidu.com");
        properties.setProperty("user", "kyy");
        properties.setProperty("password", "pwd");

        System.out.print(properties.getProperty("dirver", "cant get driver"));

    }

    void saveToFile() {
        /**
         * 输出一个properties 文件
         */

        Properties properties
                = new Properties();
        //     properties.setProperty("dirver", "Oracle:Dirver");
        properties.setProperty("url", "baidu.com");
        properties.setProperty("user", "kyy");
        properties.setProperty("password", "pwd");
        try {
            if (new File("d:/properties.pro").exists())
                new File("d:/properties.pro").delete();
            properties.store(new FileOutputStream(new File("d:/properties.pro")), "proper");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            if (new File("d:/pro.xml").exists())
                new File("d:/pro.xml").delete();
            properties.storeToXML(new FileOutputStream(new File("d:/pro.xml")), "xmlPro");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            properties.store(new FileOutputStream(new File("outFile/properties.pro")), "db.pro");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            properties.storeToXML(new FileOutputStream(new File("outFile/pro.xml")), "db.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
