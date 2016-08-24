package com.example.collection;

import org.apache.commons.collections4.IterableMap;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.map.HashedMap;

/**
 * Created by Administrator on 2016/8/6.
 */
public class TestIterableMap {
    IterableMap<String, String> iterableMap = new HashedMap<>();

    void test() {
        iterableMap.put("name", "kyy");
        iterableMap.put("name2", "kyy2");
        iterableMap.put("name3", "kyy3");
        iterableMap.put("name4", "kyy4");
        iterableMap.put("name5", "kyy5");
        for (MapIterator<String, String> it = iterableMap.mapIterator(); it.hasNext(); ) {
            System.out.println(it.next());
            System.out.println(it.getValue());
        }

    }
}
