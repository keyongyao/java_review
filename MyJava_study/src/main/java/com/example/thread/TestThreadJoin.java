package com.example.thread;

/**
 * Created by Administrator on 2016/8/9.
 */
public class TestThreadJoin extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 500; i++) {
            System.out.println("joining  " + i);

        }
    }

    void test() {
        Thread thread = new Thread(this);
        thread.start();
        for (int i = 0; i < 300; i++) {
            if (i == 15)
                try {
                    thread.join();  //此时 test方法阻塞  等待 thread运行完
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            System.out.println("Main  " + i);
        }
    }

}
