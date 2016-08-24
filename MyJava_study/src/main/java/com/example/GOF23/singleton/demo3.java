package com.example.GOF23.singleton;

import java.io.Serializable;

/**
 * 懒汉式加载，不消耗资源，并发高
 * 最好的单例模式
 * Created by Administrator on 2016/8/17.
 */
public class demo3 implements Serializable {
    private demo3() {
    }

    private static class Hoder {
        private static demo3 instance = new demo3();
    }

    public static demo3 getInstance() {
        return Hoder.instance;
    }

    //阻止反序列化
    private Object readResolve() {
        return Hoder.instance;
    }

    @Override
    protected demo3 clone() throws CloneNotSupportedException {
        return (demo3) super.clone();
    }
}
