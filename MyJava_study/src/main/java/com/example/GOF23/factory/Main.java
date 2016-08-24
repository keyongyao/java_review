package com.example.GOF23.factory;

/**
 * Created by Administrator on 2016/8/17.
 */
public class Main {
    public static void main(String[] args) {
        Animal animal = new SimpleFactory().createAnimal("bird");
        animal.run();
    }
}
