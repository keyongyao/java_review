package com.example.collection;

/**
 * Created by Administrator on 2016/7/28.
 */
public class MyMap2 {
    entry[] arr = new entry[900];
    int size;

    public void put(Object key, Object value) {
        arr[size++] = new entry("name", "KeYongYao");

    }

    public Object get(Object key) {
        for (int i = 0; i < size; i++) {
            if (arr[i].key.equals(key)) {
                return arr[i];
            }
        }
        return null;
    }
}
