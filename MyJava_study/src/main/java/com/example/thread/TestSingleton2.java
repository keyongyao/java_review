package com.example.thread;

/**
 * Created by Administrator on 2016/8/10.
 */
public class TestSingleton2 {
    private static TestSingleton2 instance = new TestSingleton2();  //类加载就实例化了，耗内存

    private TestSingleton2() {
    }

    public static TestSingleton2 getInstance() {
        return instance;
    }
}

class TestSingleton3 {
    private static class InstanceHolder {  //当外部类加载了，也没有实例化
        private static TestSingleton3 instance = new TestSingleton3();
    }

    private TestSingleton3() {
    }

    public TestSingleton3 getInstance() {
        return InstanceHolder.instance;
    }
}
