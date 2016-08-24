package com.example.GOF23.adapter;

/**
 * 作用：拿到输入类，转为成 输出接口
 * Created by Administrator on 2016/8/18.
 */
public class Adapter implements Out {
    private In in;

    public Adapter(In in) {
        this.in = in;
    }

    @Override
    public void handleRun() {
        in.run();
    }
}
