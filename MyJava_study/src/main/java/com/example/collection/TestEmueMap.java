package com.example.collection;

import java.util.EnumMap;

/**
 * Created by Administrator on 2016/8/2.
 */
public class TestEmueMap {
    EnumMap<Season, String> enumMap = new EnumMap<Season, String>(Season.class);

    enum Season {
        Spring, Summer, Fall, winter;
    }

    void test() {
        enumMap.put(Season.Fall, "秋天");
        enumMap.put(Season.Spring, "春天");
        enumMap.put(Season.winter, "冬天");
        enumMap.put(Season.Summer, "夏天");
        System.out.println(enumMap.size());
        System.out.println(enumMap.toString());
        for (int i = 0; i < enumMap.size(); i++) {
            System.out.println(enumMap.get(Season.Summer));
        }
    }
}