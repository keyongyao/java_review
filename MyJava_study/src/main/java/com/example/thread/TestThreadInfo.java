package com.example.thread;

/**
 * 测试线程一些信息，
 * Created by Administrator on 2016/8/10.
 */
public class TestThreadInfo implements Runnable {
    boolean flag = true;
    int num = 0;

    @Override
    public void run() {
        while (flag)
            System.out.println(num++);
    }

    void stop() {
        this.flag = !flag;
    }

    void test() {
        Thread thread = new Thread(this, "测试");
        thread.start();
        System.out.println(" Thread.currentThread()" + Thread.currentThread());
        System.out.println("thread.isAlive() " + thread.isAlive());
        System.out.println(" thread.getName() " + thread.getName());
        System.out.println(" thread.getState() " + thread.getState());
        System.out.println("thread.currentThread() " + thread.currentThread());
        System.out.println("thread.getPriority()  " + thread.getPriority());
        System.out.println("thread.getStackTrace() " + thread.getStackTrace());
        System.out.println(" thread.getThreadGroup() " + thread.getThreadGroup());
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.stop();
    }
}
