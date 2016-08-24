package com.example.GOF23.singleton;

/**
 * 懒汉式 壹开始并没有创建对象，等到getInstance() 时候，在创建，
 * 并发低，因为要使用synchronized{} 同步线程
 * Created by Administrator on 2016/8/17.
 */
public class demo1 {
    public demo1() {
    }

    private static demo1 instance;

    public static synchronized demo1 getInstance() {
        if (instance == null)
            instance = new demo1();
        return instance;
    }

}
