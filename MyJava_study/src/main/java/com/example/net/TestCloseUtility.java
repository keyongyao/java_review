package com.example.net;

import java.io.Closeable;
import java.io.IOException;

/**
 * Created by Administrator on 2016/8/13.
 */
public class TestCloseUtility {
    public static void closeAll(Closeable... io) {
        for (Closeable sub : io
                ) {
            try {
                sub.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
