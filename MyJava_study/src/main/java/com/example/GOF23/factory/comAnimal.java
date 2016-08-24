package com.example.GOF23.factory;

/**
 * Created by Administrator on 2016/8/18.
 */
public class comAnimal {
}

class human implements Animal {


    @Override
    public void run() {
        System.out.println("human run");
    }
}


class bird implements Animal {

    @Override
    public void run() {
        System.out.println("bird fly");
    }
}

class fish implements Animal {
    @Override
    public void run() {
        System.out.println("fish swim");
    }
}

