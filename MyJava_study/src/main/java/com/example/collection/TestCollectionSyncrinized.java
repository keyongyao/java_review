package com.example.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/8/2.
 */
public class TestCollectionSyncrinized {
    List<String> list = new ArrayList<>();

    void test() {
        list.add("a");
        list.add("b");
        List<String> listSyn = Collections.synchronizedList(list);

    }

    void readOnly() {
        Map<String, String> map = new HashMap<>();
        map.put("abc", "abc");
        map.put("abcd", "abcd");
        map = Collections.unmodifiableMap(map);

        try {
            map.put("add", "add");
        } catch (UnsupportedOperationException e) {
            //   e.printStackTrace();
            System.out.println("不支持读写");
        } finally {
        }
    }

    void oneElenment() {
        List<String> singleton = Collections.singletonList(new String("oneElement"));
//        singleton.add("element");
//        singleton.add("elenment2");
        System.out.println(singleton.size());
        System.out.println(singleton.getClass());

    }
}
