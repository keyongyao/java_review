package com.example.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;


/**
 * Created by Administrator on 2016/8/7.
 */
public class TestOutputStream {
    OutputStream outputStream = null;

    void test() {
        try {
            outputStream = new FileOutputStream(new File("d:/output.txt"), true);
            String s = new Date().toString();
            outputStream.write(s.getBytes());
            outputStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != outputStream)
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }
}
