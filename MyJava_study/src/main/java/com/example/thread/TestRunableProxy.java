package com.example.thread;

import java.util.Date;

/**
 * 此类为 TestRunable 类的真实调用类
 * 需要传进 TestRunable 的对象
 * Created by Administrator on 2016/8/9.
 */
public class TestRunableProxy {
    TestRunable testRunable;

    public TestRunableProxy(TestRunable testRunable) {
        this.testRunable = testRunable;
    }

    public TestRunableProxy() {
    }


    void test() {
        Thread thread = new Thread(testRunable);  // 通过 Thread 接收实现runable 接口的类
        thread.start();

        for (int i = 0; i < 10; i++) {
            System.out.println(this.getClass() + "   " + new Date().toString());
        }
    }

}
