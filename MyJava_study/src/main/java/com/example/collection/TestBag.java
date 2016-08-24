package com.example.collection;

import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.bag.HashBag;
import org.apache.commons.collections4.bag.TreeBag;

import java.util.Iterator;
import java.util.Set;

/**
 * 测试 bag
 * treeBag 有序
 * hashBag  无序
 * Created by Administrator on 2016/8/6.
 */
public class TestBag {

    Bag<String> bag = new HashBag<>();

    void testHashBag() {
        bag.add("阿爸");
        bag.add("阿妈");
        bag.add("客用");
        bag.add("姿势");
        bag.add("八十");
        for (Iterator<String> iterator = bag.iterator(); iterator.hasNext(); ) {
            System.out.println(iterator.next());
        }
    }

    Bag<String> treeBag = new TreeBag<>();

    void testTreeBag() {
        treeBag.add("阿爸");
        treeBag.add("阿妈");
        treeBag.add("客用");
        treeBag.add("姿势");
        treeBag.add("八十");
        for (Iterator<String> iterator = treeBag.iterator(); iterator.hasNext(); ) {
            System.out.println(iterator.next());
        }
    }

    void testCountWord() {
        String str = "this is cat and that is mouse or who is food";
        String[] arry = str.split(" ");
        Bag<String> stringBag = new HashBag<>();
        for (String tmp : arry) {
            stringBag.add(tmp);
        }
        Set<String> stringSet = stringBag.uniqueSet();
        for (String key : stringSet) {
            System.out.println("key：" + key + "\t count:" + stringBag.getCount(key));
        }
    }
}
