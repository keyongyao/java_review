package com.example.thread;

import java.util.Date;

/**
 * Created by Administrator on 2016/8/9.
 */
public class TestThreadStatus implements Runnable {
    @Override
    public void run() {
        while (isAllowRun) {
            System.out.println(this.getClass() + "  is running  " + new Date().toString());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean isAllowRun = true;

    public boolean isAllowRun() {
        return isAllowRun;
    }

    public void setAllowRun(boolean allowRun) {
        this.isAllowRun = allowRun;
    }

    void test() {
        Thread thread = new Thread(this);
        thread.start();
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.setAllowRun(false);
    }
}
