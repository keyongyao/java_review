package com.example.SORM;


import org.omg.CORBA.Context;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Administrator on 2016/8/24.
 */
public class Main {
    public static void main(String[] args) {
        try {
            FileOutputStream outputStream = new FileOutputStream(new File("output"));

            outputStream.write(new byte[]{'d', 'd'});
            outputStream.flush();
            outputStream.close();

            InputStream in = new BufferedInputStream(Thread.currentThread()
                    .getContextClassLoader().getResourceAsStream("abc.properties"));
            System.out.println(Thread.currentThread().getContextClassLoader().getResource("").getPath());
            byte[] flush = new byte[1024];
            int len = 0;
            StringBuilder builder = new StringBuilder();
            while (-1 != (len = in.read(flush))) {
                builder.append(new String(flush, 0, len));
            }
            in.close();
            System.out.println(builder.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
