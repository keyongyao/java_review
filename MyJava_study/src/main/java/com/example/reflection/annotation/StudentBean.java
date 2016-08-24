package com.example.reflection.annotation;


/**
 * 保存学生的信息类
 * Created by Administrator on 2016/8/14.
 */
@com.example.reflection.annotation.AnnotationTable(value = "tb_student")
public class StudentBean {
    @com.example.reflection.annotation.AnnotationField(columnName = "name", length = 4, type = "varchar")
    private String name;
    @com.example.reflection.annotation.AnnotationField(columnName = "id", length = 2, type = "int")
    private int id;
    @AnnotationField(columnName = "age", length = 3, type = "int")
    private int age;

    @Override
    public String toString() {
        return "StudentBean{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public StudentBean(String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public StudentBean() {
    }


}
