package com.example.SORM.po;

// 生成时间: Fri Aug 26 11:37:16 CST 2016

import java.sql.*;
import java.util.*;


public class Employees {

    private String gender;
    private Integer emp_no;
    private java.sql.Date birth_date;
    private String last_name;
    private java.sql.Date hire_date;
    private String first_name;

    public String getGender() {
        return this.gender;
    }

    public Integer getEmp_no() {
        return this.emp_no;
    }

    public java.sql.Date getBirth_date() {
        return this.birth_date;
    }

    public String getLast_name() {
        return this.last_name;
    }

    public java.sql.Date getHire_date() {
        return this.hire_date;
    }

    public String getFirst_name() {
        return this.first_name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setEmp_no(Integer emp_no) {
        this.emp_no = emp_no;
    }

    public void setBirth_date(java.sql.Date birth_date) {
        this.birth_date = birth_date;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setHire_date(java.sql.Date hire_date) {
        this.hire_date = hire_date;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }


}