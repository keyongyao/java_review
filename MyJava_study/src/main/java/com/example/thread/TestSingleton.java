package com.example.thread;

/**
 * 单例模式  通过控制构造器器 保证只有是一个实例对象
 * Created by Administrator on 2016/8/10.
 */
public class TestSingleton implements Runnable {
    long time;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "  " + singleton);
    }

    private static TestSingleton singleton = null;

    private TestSingleton() {
    }


    public static TestSingleton getInstance(long time) {
        if (singleton == null) {
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            singleton = new TestSingleton();

        }
        return singleton;
    }
}
