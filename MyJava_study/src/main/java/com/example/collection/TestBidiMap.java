package com.example.collection;

import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;
import org.apache.commons.collections4.bidimap.DualTreeBidiMap;

import java.util.Iterator;

/**
 * 测试双向MAP 特点 key value 都不重复
 * DualTreeBidiMap  有序
 * DualHashBidiMap  无序
 * <p/>
 * Created by Administrator on 2016/8/6.
 */
public class TestBidiMap {
    BidiMap<String, String> bidiMap = new DualTreeBidiMap<>();

    //测试无序BidiMap
    void testDualBidiMap() {
        bidiMap.put("name", "kyy");
        bidiMap.put("sex", "boy");
        bidiMap.put("work", "farmer");
        //  System.out.println(bidiMap.get("name"));
        // System.out.println(bidiMap.inverseBidiMap().get("boy"));

        MapIterator<String, String> iteratorMap = bidiMap.mapIterator();
        while (iteratorMap.hasNext()) {
            iteratorMap.next();
            System.out.println(iteratorMap.getKey() + "<----->" + iteratorMap.getValue());
        }
    }

    BidiMap<String, String> map = new DualHashBidiMap<>();

    void testDualHashBidiMap() {
        map.put("name", "kyy");
        map.put("sex", "boy");
        map.put("work", "farmer");

        for (MapIterator<String, String> iteratorMap = map.mapIterator();
             iteratorMap.hasNext(); ) {
            iteratorMap.next();
            System.out.println(iteratorMap.getKey() + "<----->" + iteratorMap.getValue());
        }

    }

}
