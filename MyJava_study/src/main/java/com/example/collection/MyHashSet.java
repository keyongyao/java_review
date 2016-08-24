package com.example.collection;

import java.util.HashMap;

/**
 * 自己实现hashSet
 * Created by Administrator on 2016/7/30.
 */
public class MyHashSet {
    private final Object PRESENT = new Object();
    HashMap hashMap;

    // int size;
    public MyHashSet() {
        hashMap = new HashMap();
    }

    void add(Object obj) {
        hashMap.put(obj, PRESENT);
        //     size++;
    }

    void remove() {

    }

    int getSize() {
        return hashMap.size();
        // return size;
    }

    void test() {

    }
}
