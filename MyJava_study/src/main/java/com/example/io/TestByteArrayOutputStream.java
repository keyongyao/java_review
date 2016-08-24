package com.example.io;

import java.io.ByteArrayOutputStream;

/**
 * Created by Administrator on 2016/8/7.
 */
public class TestByteArrayOutputStream {
    byte[] write() {
        String info = "this is a cat or mouse?中国字";
        byte[] src = info.getBytes();
        ByteArrayOutputStream byteArrayOutputStream = null;
        byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] dst;
        byteArrayOutputStream.write(src, 0, src.length);
        dst = byteArrayOutputStream.toByteArray();
        return dst;
    }
}

