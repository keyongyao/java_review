package com.example.collection;


import org.apache.commons.collections4.iterators.UniqueFilterIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 测试arrayList 由于是有序 元素可以重复  现在测试去重复的 Iterator
 * Created by Administrator on 2016/8/6.
 */
public class TestIteratorUniqFilter {
    List<String> list = new ArrayList<>();

    void test() {
        list.add("小明报名");
        list.add("小明报名");
        list.add("小宏报名");
        list.add("小次报名");
        list.add("小次报名");
        UniqueFilterIterator<String> iterator = new UniqueFilterIterator(list.iterator());
        Iterator<String> iterator2 = new UniqueFilterIterator(list.iterator());
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
