package com.example.GOF23.decorator;

/**
 * Created by Administrator on 2016/8/20.
 */
public class WearSkirt implements DressUp {
    private DressUp human;

    public WearSkirt(DressUp human) {
        this.human = human;
    }

    @Override
    public void dressup() {
        human.dressup();
        System.out.println("给你穿裙子吧！");
    }
}
