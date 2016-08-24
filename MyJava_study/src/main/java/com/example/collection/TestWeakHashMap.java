package com.example.collection;

import java.lang.ref.WeakReference;

/**
 * strong soft weak pthome
 * 常量不清楚
 * Created by Administrator on 2016/8/2.
 */
public class TestWeakHashMap {
    String str = new String("sdfasdafdsf");
    String str2 = "sdfasdafdsf";
    WeakReference<String> ws = new WeakReference<String>(str);
    WeakReference<String> ws2 = new WeakReference<String>(str2);

    void test() {
        System.out.println("GC运行前：\nws.get()" + ws.get() + "     \nws2.get()" + ws2.get());
        str = null;
        str2 = null;
        System.gc();
        System.runFinalization();
        System.out.println("GC运行后\n ws.get()" + ws.get());
        System.out.println("GC运行后\nws2.get()" + ws2.get());
    }
}
