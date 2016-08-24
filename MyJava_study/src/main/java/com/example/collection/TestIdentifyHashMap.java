package com.example.collection;

import java.util.IdentityHashMap;

/**
 * 比较健的地址，判断是否重复
 * Created by Administrator on 2016/8/2.
 */
public class TestIdentifyHashMap {
    IdentityHashMap<String, String> identityHashMap = new IdentityHashMap<>();

    void test() {
        identityHashMap.put("name", "kyy");
        identityHashMap.put("name", "kyy");
        System.out.println(identityHashMap.size() + "\n" + identityHashMap.toString());
        identityHashMap.put(new String("name"), "kyy");
        identityHashMap.put(new String("name"), "kyy");
        identityHashMap.put(new String("name"), new String("kyy"));
        System.out.println(identityHashMap.size() + "\n" + identityHashMap.toString());

    }
}
