package com.example.collection;

import org.apache.commons.collections4.iterators.ArrayIterator;
import org.apache.commons.collections4.iterators.LoopingListIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 循环输出迭代器
 * Created by Administrator on 2016/8/6.
 */
public class TestIteratorLoop {
    List<String> list = new ArrayList<>();

    void test() {
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        Iterator<String> iterator = new LoopingListIterator<>(list);
        //重复4次输出List里全部元素的
        for (int timex = 0; timex < list.size() * 4; timex++)
            System.out.println(iterator.next());
    }

    //迭代数组
    void testArrayLoop() {
        int arry[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Iterator<Integer> iterator = new ArrayIterator<Integer>(arry, 3, arry.length);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
