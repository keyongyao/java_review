package com.example.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import javax.print.DocFlavor;

/**
 * Created by Administrator on 2016/8/7.
 */
public class TestByteArrayReadWriteFile {
    byte[] read(String filePath) {
        File file = new File(filePath);
        InputStream inputStream = null;
        byte[] dst = null;
        try {
            inputStream = new BufferedInputStream(new FileInputStream(file));
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int len = 0;
            byte[] temp = new byte[2048];
            while (-1 != (len = inputStream.read(temp))) {
                byteArrayOutputStream.write(temp, 0, len);
            }
            byteArrayOutputStream.flush();
            byteArrayOutputStream.close();
            dst = byteArrayOutputStream.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dst;
    }


    void write(byte[] dst, String dstPath) {
        OutputStream outputStreamWriter = null;
        File file = new File(dstPath);
        InputStream inputStream = null;
        try {
            outputStreamWriter = new BufferedOutputStream(new FileOutputStream(file, true));
            inputStream = new BufferedInputStream(new ByteArrayInputStream(dst));
            int len = 0;
            byte[] tmp = new byte[2048];
            while (-1 != (len = inputStream.read(tmp))) {
                outputStreamWriter.write(tmp);
            }
            // outputStreamWriter.write(dst,0,dst.length);  如果启用，不利较大文件，（关闭InputStream）
            outputStreamWriter.flush();
            outputStreamWriter.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
