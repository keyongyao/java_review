package com.example.collection;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 测试ArrayList 该类
 * Created by Administrator on 2016/7/25.
 */
public class TestArrayList {

    public List init() {
        List list = new ArrayList();
        list.add("aaa");
        list.add(new Date().toString());
        list.add("bbb");
        return list;
    }

    public void print() {

        List list = new TestArrayList().init();

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i).toString() + "\n");

        }
    }

}
