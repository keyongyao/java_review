package com.example.collection;

import java.util.HashSet;
import java.util.Set;

/**
 * 测试SET方法
 * Created by Administrator on 2016/7/30.
 */
public class TestHashSet {
    Set set = new HashSet();

    public void test() {
        set.add("aaa");
        set.add("aaa");
        System.out.println(set.size());
    }

}