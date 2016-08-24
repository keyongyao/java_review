package com.example.GOF23.iterator;

/**
 * 自定义迭代器接口
 * Created by Administrator on 2016/8/20.
 */
public interface MyIterator {
    boolean hasNext();

    void previous();

    void next();

    boolean isFirst();

    boolean isLast();

    Object getCurentObject();
}
