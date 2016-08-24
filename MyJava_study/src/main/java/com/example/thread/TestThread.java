package com.example.thread;

import java.util.Date;

/**
 * Created by Administrator on 2016/8/9.
 */
public class TestThread extends Thread {
    String name = null;

    public TestThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 10; i++) {
            System.out.println(name + "    " + this.getClass() + "   is Running   " + new Date().toString());
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    void test() {

    }
}
