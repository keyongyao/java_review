package com.example.GOF23.proxy;

/**
 * Created by Administrator on 2016/8/19.
 */
public class TradesMan implements Car {
    private Car car;

    public TradesMan(Car car) {
        this.car = car;
    }

    Car sell() {
        return car;
    }

    @Override
    public void run() {
        car.run();
    }

    @Override
    public void start() {
        car.start();
    }

    @Override
    public void stop() {
        car.stop();
    }
}
