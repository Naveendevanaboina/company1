package com.neoteric.collections;

import java.util.Objects;

public class Employee {


    private String name;
    private String employeeid;
    public Employee (String name,String employeeid){
        this.name=name;
        this.employeeid=employeeid;
    }

    public String getName() {
        return name;
    }

    public String getEmployeeid() {
        return employeeid;
    }


    @Override
    public String toString(){
        return "Employee{"+"name=' "+name+'\''+",employeeid='"+employeeid+'\''+'}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name) && Objects.equals(employeeid, employee.employeeid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, employeeid);
    }
}