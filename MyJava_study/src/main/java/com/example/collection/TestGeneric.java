package com.example.collection;

/**
 * 测试泛型
 * Created by Administrator on 2016/7/30.
 */
public class TestGeneric {
    private Object javeEE;
    private Object Oracle;

    public TestGeneric(Object javeEE, Object oracle) {
        this.javeEE = javeEE;
        Oracle = oracle;
    }

    public TestGeneric() {
    }

    public Object getJaveEE() {
        return javeEE;
    }

    public void setJaveEE(Object javeEE) {
        this.javeEE = javeEE;
    }

    public Object getOracle() {
        return Oracle;
    }

    public void setOracle(Object oracle) {
        Oracle = oracle;
    }


    void test() {
        TestGeneric testGeneric = new TestGeneric(34, 23);
        System.out.println(testGeneric.getJaveEE().getClass());

    }
}
