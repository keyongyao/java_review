package com.example.GOF23.singleton;

/**
 * 懒汉式加载，不消耗资源，并发高
 * 最好的单例模式
 * <p/>
 * 防止 反射 创建多实例
 * Created by Administrator on 2016/8/17.
 */
public class demo4 {
    private demo4() {
        if (Hoder.instance != null) {
            throw new RuntimeException();
        }
    }

    private static class Hoder {
        private static demo4 instance = new demo4();
    }

    public static demo4 getInstance() {
        return Hoder.instance;
    }
}
