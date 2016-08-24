package com.example.reflection;

/**
 * Created by Administrator on 2016/8/14.
 */
public class UserBean {
    private int id;
    private String uname;
    private int age;

    @Override
    public String toString() {
        return "UserBean{" +
                "id=" + id +
                ", uname='" + uname + '\'' +
                ", age=" + age +
                '}';
    }

    public UserBean(int id, String uname, int age) {
        this.id = id;
        this.uname = uname;
        this.age = age;
    }

    public UserBean() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
