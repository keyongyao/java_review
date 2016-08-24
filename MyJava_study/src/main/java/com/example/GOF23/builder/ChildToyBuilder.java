package com.example.GOF23.builder;

/**
 * Created by Administrator on 2016/8/18.
 */
public class ChildToyBuilder implements ToyBuilder {

    @Override
    public Head headBuilder() {
        System.out.println("构建头");
        return new Head("头大大");
    }

    @Override
    public Hand handBuilder() {
        System.out.println("构建手");
        return new Hand("手纤细");
    }

    @Override
    public Feet feetBuilder() {
        System.out.println("构建腿");
        return new Feet("美腿");
    }

    @Override
    public Body bodyBuilder() {
        System.out.println("构建身体");
        return new Body("体态丰盈");
    }

    @Override
    public Nose noseBuidler() {
        System.out.println("构建鼻子");
        return new Nose("高鼻子");
    }

    @Override
    public Mounth mounthBuilder() {
        System.out.println("构建嘴");
        return new Mounth("红唇");
    }
}
