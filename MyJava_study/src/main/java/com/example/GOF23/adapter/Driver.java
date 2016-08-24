package com.example.GOF23.adapter;

/**
 * Created by Administrator on 2016/8/18.
 */
public class Driver {
    public static void main(String[] args) {
        start(new Adapter(new In()));
    }

    public static void start(Out out) {
        out.handleRun();
    }
}
