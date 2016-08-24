package com.example.GOF23.iterator;

/**
 * Created by Administrator on 2016/8/20.
 */
public class TestMyIterator {
    public static void main(String[] args) {
        ConcreteContainer container = new ConcreteContainer();

        container.addObject("aa");
        container.addObject("bb");
        container.addObject("cc");
        container.addObject("dd");

        MyIterator iterator = container.getIterator();
        while (iterator.hasNext()) {
            System.out.println(container.getCurrentObject());
            iterator.next();
        }
    }
}
