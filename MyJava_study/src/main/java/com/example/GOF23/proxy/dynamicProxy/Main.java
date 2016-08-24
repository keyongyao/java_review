package com.example.GOF23.proxy.dynamicProxy;

import java.lang.reflect.Proxy;

/**
 * Created by Administrator on 2016/8/19.
 */
public class Main {
    public static void main(String[] args) {
        BenZi benZi = new BenZi();
        CarHandle carHandle = new CarHandle(benZi);
        Car proxy = (Car) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{Car.class}, carHandle);
        proxy.start();
        proxy.run();
        proxy.stop();

    }
}
