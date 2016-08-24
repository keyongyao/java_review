package com.example.GOF23.builder;

/**
 * Created by Administrator on 2016/8/18.
 */
public interface ToyBuilder {
    Head headBuilder();

    Hand handBuilder();

    Feet feetBuilder();

    Body bodyBuilder();

    Nose noseBuidler();

    Mounth mounthBuilder();
}
