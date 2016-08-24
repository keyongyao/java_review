package com.example.GOF23.composition;

/**
 * 容器组件
 * Created by Administrator on 2016/8/19.
 */
public interface Composit extends Componet {
    void addComposit(Composit composit);

    void delComposit(Composit composit);

    Composit getChild(int index);

}
