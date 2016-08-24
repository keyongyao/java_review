package com.example.GOF23.builder;

/**
 * Created by Administrator on 2016/8/18.
 */
public class Director implements ToyDirctor {
    private ToyBuilder toyBuilder;

    public Director(ToyBuilder toyBuilder) {
        this.toyBuilder = toyBuilder;
    }

    @Override
    public Toy toyDirctor() {
        Toy toy = new Toy();
        toy.setBody(toyBuilder.bodyBuilder());
        toy.setFeet(toyBuilder.feetBuilder());
        toy.setHand(toyBuilder.handBuilder());
        toy.setMounth(toyBuilder.mounthBuilder());
        toy.setNose(toyBuilder.noseBuidler());
        toy.setHead(toyBuilder.headBuilder());
        return toy;
    }
}
