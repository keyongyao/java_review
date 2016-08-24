package com.example.GOF23.proxy;

/**
 * Created by Administrator on 2016/8/19.
 */
public class Driver {
    public static void main(String[] args) {
        TradesMan tradesMan = new TradesMan(new BenZi());
        tradesMan.start();
        tradesMan.run();
        tradesMan.stop();

    }
}
