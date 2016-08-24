package com.example.GOF23.proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2016/8/19.
 */
public class CarHandle implements InvocationHandler {
    private Car car;

    public CarHandle(Car car) {
        this.car = car;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("<------->代码块<----->");
        method.invoke(car, args);
        return null;
    }
}
