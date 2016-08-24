package com.example.thread;

/**
 * Created by Administrator on 2016/8/10.
 */
public class TestCustomerProducter {
    String s;
    private boolean isProducting = true;

    synchronized void product(String s) {
        if (!isProducting)
            try {
                this.wait();
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        this.s = s;
        System.out.println("product " + s);
        this.isProducting = false;
        this.notify();

    }


    synchronized void eat() {
        if (isProducting) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.err.println("eating " + s);
        this.isProducting = true;
        this.notify();

    }


}

class Customer implements Runnable {
    private TestCustomerProducter abc;

    public Customer(TestCustomerProducter abc) {
        this.abc = abc;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            abc.eat();
        }
    }
}

class Producter implements Runnable {
    private TestCustomerProducter abc;

    public Producter(TestCustomerProducter abc) {
        this.abc = abc;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0) {
                abc.product("苹果");
            } else {
                abc.product("雪梨");
            }
        }

    }
}
