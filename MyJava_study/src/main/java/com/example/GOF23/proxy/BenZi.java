package com.example.GOF23.proxy;

/**
 * Created by Administrator on 2016/8/19.
 */
public class BenZi implements Car {
    @Override
    public void run() {
        System.out.println("奔驰在跑！");
    }

    @Override
    public void start() {
        System.out.println("奔驰启动了");
    }

    @Override
    public void stop() {
        System.out.println("奔驰停车了");
    }
}
