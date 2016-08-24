package com.example.thread;

import sun.awt.windows.ThemeReader;

/**
 * Created by Administrator on 2016/8/9.
 */
public class TestThreadYeild extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("Main  <----->" + i);
        }
    }

    void test() {
        Thread thread = new Thread(this);
        thread.start();


        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (i == 500)
                thread.yield();
            System.out.println("test  <----> " + i);

        }
    }


}
