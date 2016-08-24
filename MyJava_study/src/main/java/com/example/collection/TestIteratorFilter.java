package com.example.collection;

import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.iterators.FilterIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 测试自定义的过滤器  IteratorFilter
 * Created by Administrator on 2016/8/6.
 */
public class TestIteratorFilter {
    List<String> list = new ArrayList<>();

    void test() {
        list.add("abc7");
        list.add("abc5");
        list.add("abc3");
        list.add("abc3");
        list.add("abc2");
        list.add("aaabaaa");
        list.add("ass");
        list.add("d");
        list.add("reer");
        //判断指示
        Predicate<String> pre = new Predicate<String>() {
            @Override
            public boolean evaluate(String s) {
                return new StringBuilder(s).reverse().toString().equals(s);
            }
        };
        //一个迭代器接口，判断指示和List迭代接口
        Iterator<String> iterator = new FilterIterator<>((list.iterator()), pre);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }


}
