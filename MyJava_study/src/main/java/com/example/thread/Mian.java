package com.example.thread;

import sun.awt.windows.ThemeReader;

/**
 * Created by Administrator on 2016/8/9.
 */
public class Mian {
    public static void main(String[] str) {
        //run() start() 方法的区别  run是执行完在执行  start 方法把线程放到线程组里。
        //new TestThread("I am a student").run();
        // new TestThread("I am a teacher").run();
        // new TestRunableProxy(new TestRunable()).test();
        //  new TestCallable().test();
        //   new TestThreadStatus().test();
        // new TestThreadJoin().test();
        //new TestThreadYeild().test();
        // new  TestThreadInfo().test();
        //new Thread(TestSingleton.getInstance(850)).start();

        //new Thread(TestSingleton.getInstance(200)).start();
       /* Object goods=new Object();
        Object seller=new Object();
        TestDeadLock a=new TestDeadLock(goods,seller);
        TestDeadLock2 b= new TestDeadLock2(goods,seller);
        Thread thread=new Thread(a);
        Thread thread1=new Thread(b);
        thread.start();
        thread1.start();*/
/*
        TestCustomerProducter instance= new TestCustomerProducter();

        Producter producter= new Producter(instance);
        Customer customer= new Customer(instance);
        Thread a= new Thread(producter);
        Thread b= new Thread(customer);
        a.start();
        b.start();*/
        new TestSchedule().test();

    }
}
