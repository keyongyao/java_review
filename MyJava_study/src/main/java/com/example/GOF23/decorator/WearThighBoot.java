package com.example.GOF23.decorator;

/**
 * Created by Administrator on 2016/8/20.
 */
public class WearThighBoot implements DressUp {
    private DressUp human;

    public WearThighBoot(DressUp human) {
        this.human = human;
    }

    @Override
    public void dressup() {
        human.dressup();
        System.out.println("给你穿长靴吧！");
    }
}
