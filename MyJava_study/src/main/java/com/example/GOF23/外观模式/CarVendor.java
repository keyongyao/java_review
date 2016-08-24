package com.example.GOF23.外观模式;


/**
 * 汽车零售商
 * Created by Administrator on 2016/8/20.
 */
public class CarVendor {
    void sell() {
        new 汽车上牌();
        new 汽车买保险();
        new 装饰汽车();
    }
}
