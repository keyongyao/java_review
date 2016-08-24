package com.example.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 综合输入和输出流
 * Created by Administrator on 2016/8/7.
 */
public class TestCopyFile {
    File src = new File("M:\\尚学堂_Android视频教程\\49.Spinner的使用讲解2.mp4");
    File dest = new File("d:/49.Spinner的使用讲解2.mp4");

    void testCopy() {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {

            inputStream = new FileInputStream(src);
            outputStream = new FileOutputStream(dest);
            byte[] temp = new byte[4096];
            inputStream.read(temp);
            int len = 0;
            while (-1 != (len = inputStream.read(temp))) {
                outputStream.write(temp);
            }
            outputStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null)
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if (outputStream != null)
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }
}
