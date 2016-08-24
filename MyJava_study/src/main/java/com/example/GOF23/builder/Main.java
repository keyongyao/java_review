package com.example.GOF23.builder;

/**
 * Created by Administrator on 2016/8/18.
 */
public class Main {
    public static void main(String[] args) {
        Director director = new Director(new ChildToyBuilder());

        System.out.println(director.toyDirctor().toString());
    }
}
