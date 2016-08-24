package com.example.javaassist;

/**
 * Created by Administrator on 2016/8/14.
 */
public class Emp {
    private int Empno;
    private String name;

    @Override
    public String toString() {
        return "Emp{" +
                "Empno=" + Empno +
                ", name='" + name + '\'' +
                '}';
    }

    public Emp() {
    }

    public Emp(int empno, String name) {
        Empno = empno;
        this.name = name;
    }

    public int getEmpno() {
        return Empno;
    }

    public void setEmpno(int empno) {
        Empno = empno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
