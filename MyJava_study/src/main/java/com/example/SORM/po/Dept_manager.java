package com.example.SORM.po;

// 生成时间: Fri Aug 26 11:37:16 CST 2016

import java.sql.*;
import java.util.*;


public class Dept_manager {

    private String dept_no;
    private java.sql.Date from_date;
    private java.sql.Date to_date;
    private Integer emp_no;

    public String getDept_no() {
        return this.dept_no;
    }

    public java.sql.Date getFrom_date() {
        return this.from_date;
    }

    public java.sql.Date getTo_date() {
        return this.to_date;
    }

    public Integer getEmp_no() {
        return this.emp_no;
    }

    public void setDept_no(String dept_no) {
        this.dept_no = dept_no;
    }

    public void setFrom_date(java.sql.Date from_date) {
        this.from_date = from_date;
    }

    public void setTo_date(java.sql.Date to_date) {
        this.to_date = to_date;
    }

    public void setEmp_no(Integer emp_no) {
        this.emp_no = emp_no;
    }


}