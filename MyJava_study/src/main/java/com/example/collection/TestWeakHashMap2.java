package com.example.collection;

import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/**
 * Created by Administrator on 2016/8/2.
 */
public class TestWeakHashMap2 {
    WeakHashMap<String, String> weakHashMap = new WeakHashMap<>();

    void test() {
        //不会被回收
        weakHashMap.put("name", "kyy");
        weakHashMap.put("name", "boy");
        //会被回收
        weakHashMap.put(new String("name3"), "kyy");
        weakHashMap.put(new String("name3"), new String("kyy"));
        // System.gc();
        // System.runFinalization();
        System.out.println(weakHashMap.size());
        System.out.println(weakHashMap.toString());
    }
}
