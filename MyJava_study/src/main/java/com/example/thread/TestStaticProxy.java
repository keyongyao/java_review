package com.example.thread;

/**
 * 解决一个类不能继承多个父类的情景
 * 利用一个中介类（和具体类实现同接口），通过参数传进代理类进行处理
 * Created by Administrator on 2016/8/9.
 */
public class TestStaticProxy {

}

interface Role {
    public abstract void Do();
}

class Student implements Role {
    @Override
    public void Do() {
        System.out.println("do");
    }
}

class proxy implements Role {
    Student student;

    public proxy(Role role) {
        student = (Student) role;
    }

    @Override
    public void Do() {
        System.out.println(student.toString() + "actually do ");
    }
}