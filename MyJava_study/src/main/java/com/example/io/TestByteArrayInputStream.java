package com.example.io;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Administrator on 2016/8/7.
 */
public class TestByteArrayInputStream {
    void read() {
        String src = "this is a cat or mouse?中国字";
        byte[] bytes = src.getBytes();

        InputStream inputStream = null;

        inputStream = new BufferedInputStream(new ByteArrayInputStream(bytes));
        byte[] tmpe = new byte[1024];
        int len = 0;
        try {
            while (-1 != (len = inputStream.read(tmpe))) {
                System.out.print(new String(tmpe, 0, tmpe.length));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null)
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }
}
