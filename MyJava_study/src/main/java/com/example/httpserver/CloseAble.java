package com.example.httpserver;

import java.io.Closeable;
import java.io.IOException;

/**
 * Created by Administrator on 2016/8/13.
 */
public class CloseAble {
    public static void closeAll(Closeable... ios) {
        for (Closeable io : ios
                ) {
            try {
                io.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
