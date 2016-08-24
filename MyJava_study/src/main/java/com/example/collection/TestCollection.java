package com.example.collection;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by Administrator on 2016/7/30.
 */
public class TestCollection {
    Employee employee = new Employee();
    DateFormat dateFormat = new SimpleDateFormat();

    void test() {
        employee.setId(001);
        employee.setName("KYY");
        employee.setDepartment("Scient");
        employee.setSalary(8000);
        try {
            employee.setHireData(dateFormat.parse("2016-07"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
