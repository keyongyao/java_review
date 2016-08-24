package com.example.thread;

import sun.awt.windows.ThemeReader;

/**
 * Created by Administrator on 2016/8/10.
 */
public class TestDeadLock implements Runnable {
    Object goods;
    Object seller;

    public TestDeadLock(Object goods, Object seller) {
        this.goods = goods;
        this.seller = seller;
    }

    @Override
    public void run() {
        while (true) {
            test();
        }
    }

    void test() {
        synchronized (goods) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        synchronized (seller) {

        }
        System.out.println("一手给钱");
    }
}

class TestDeadLock2 implements Runnable {
    Object goods;
    Object seller;

    public TestDeadLock2(Object goods, Object seller) {
        this.goods = goods;
        this.seller = seller;
    }

    @Override
    public void run() {
        while (true) {
            test();
        }
    }

    void test() {
        synchronized (seller) {
            try {
                Thread.sleep(7500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        synchronized (goods) {

        }
        System.out.println("一手给人");
    }
}
