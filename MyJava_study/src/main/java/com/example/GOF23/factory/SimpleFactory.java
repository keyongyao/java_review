package com.example.GOF23.factory;

import java.util.ArrayList;
import java.util.List;

/**
 * 简单工厂模式
 * Created by Administrator on 2016/8/17.
 */
public class SimpleFactory {
    List<String> animalList = new ArrayList<>();

    public Animal createAnimal(String name) {
        animalList.add("bird");
        animalList.add("human");
        animalList.add("fish");
        switch (name) {
            case "human":
                return new human();
            case "bird":
                return new bird();
            case "fish":
                return new fish();
            default:
                return null;
        }

    }
}
