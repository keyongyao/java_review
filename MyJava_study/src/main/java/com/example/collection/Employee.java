package com.example.collection;

import java.util.Date;

/**
 * Created by Administrator on 2016/7/30.
 */
public class Employee {
    private int id;
    private String name;
    private int salary;
    private String department;
    private Date hireData;

    public Employee() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getHireData() {
        return String.valueOf(hireData);
    }

    public void setHireData(Date hireData) {
        this.hireData = hireData;
    }

    public Employee(int id, String name, int salary, String department, Date hireData) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;
        this.hireData = hireData;
    }
}
