package com.example.SORM.utils;

import java.io.Closeable;
import java.io.IOException;

/**
 * Created by Administrator on 2016/8/26.
 */
public class CloseClosableObject {
    public static void closeAll(Closeable... ios) {
        for (Closeable cc : ios
                ) {
            if (cc != null)
                try {
                    cc.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

}
