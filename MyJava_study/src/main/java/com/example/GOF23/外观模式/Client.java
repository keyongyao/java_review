package com.example.GOF23.外观模式;

/**
 * 客户想买车
 * Created by Administrator on 201/8/20.
 */
public class Client {

    public static void main(String[] args) {
        new Client(new CarVendor()).buyCar();
    }

    public Client(CarVendor carVendor) {
        this.carVendor = carVendor;
    }

    private CarVendor carVendor;

    void buyCar() {
        carVendor.sell();
    }
}
