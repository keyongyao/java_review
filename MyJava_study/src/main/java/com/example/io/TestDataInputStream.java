package com.example.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;

/**
 * 保存字符串有问题
 * Created by Administrator on 2016/8/7.
 */
public class TestDataInputStream implements Serializable {
    void write(String dstPath) {
        double point = 2.5;
        long num = 100L;
        String str = "红花锅锅";
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(new File(dstPath))));
            //TODO
            dataOutputStream.writeBytes(str);
            dataOutputStream.writeDouble(point);
            dataOutputStream.writeLong(num);

            dataOutputStream.flush();
            dataOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void read(String dstpath) {
        double point = 0.0;
        long num = 0;
        String str = null;
        DataInputStream dataInputStream = null;
        try {
            dataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(new File(dstpath))));
            //TODO
            str = dataInputStream.readUTF();

            point = dataInputStream.readDouble();
            num = dataInputStream.readLong();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (dataInputStream != null)
                try {
                    dataInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        System.out.println(point + "<---->" + num + "<------->" + str);
    }
}
