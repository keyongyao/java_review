package com.example.GOF23.decorator;

/**
 * 主体类
 * Created by Administrator on 2016/8/20.
 */
public class Woman implements DressUp {
    public static void main(String[] args) {
        new WearClass(new WearSkirt(new WearThighBoot(new Woman()))).dressup();
    }


    @Override
    public void dressup() {
        System.out.println("我是一个女孩，我需要修饰：");
    }
}
