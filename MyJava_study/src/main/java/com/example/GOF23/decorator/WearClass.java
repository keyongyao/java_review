package com.example.GOF23.decorator;

/**
 * Created by Administrator on 2016/8/20.
 */
public class WearClass implements DressUp {
    private DressUp human;

    public WearClass(DressUp human) {
        this.human = human;
    }

    @Override
    public void dressup() {
        human.dressup();
        System.out.println("给你戴眼镜吧！");
    }
}
