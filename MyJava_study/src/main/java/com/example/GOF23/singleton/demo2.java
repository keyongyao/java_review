package com.example.GOF23.singleton;

/**
 * 饿汉式  一开始就创建对象，消耗资源
 * Created by Administrator on 2016/8/17.
 */
public class demo2 {
    private static demo2 ourInstance = new demo2();

    public static demo2 getInstance() {
        return ourInstance;
    }

    private demo2() {
    }
}
