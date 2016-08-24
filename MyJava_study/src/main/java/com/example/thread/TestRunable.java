package com.example.thread;

import java.util.Date;

/**
 * 使用runable接口实现线程
 * 静态代理具体实现
 * Created by Administrator on 2016/8/9.
 */
public class TestRunable implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(this.getClass() + "   " + new Date().toString());
        }
    }
}
