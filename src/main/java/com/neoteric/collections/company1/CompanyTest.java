package com.neoteric.collections.company1;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CompanyTest {
    public static void main(String[] args) {

            Department itDepartment = new Department();
            itDepartment.setName(" IT Department ");

            Employee chandu = new Employee();
            chandu.setEmployeeName("Chandu");
            chandu.setSalary(20000.0);
            chandu.setEmployeeId(1);

            Employee seetha = new Employee();
            seetha.setEmployeeName("Seetha");
            seetha.setSalary(50000.0);
            seetha.setEmployeeId(2);

            itDepartment.add(chandu);
            itDepartment.add(seetha);

            Department hr = new Department();
            hr.setName(" HR Deaprtment ");

            Employee madhu = new Employee();
            madhu.setEmployeeName("madhu");
            madhu.setSalary(10000.0);
            madhu.setEmployeeId(3);

            Employee venkat = new Employee();
            venkat.setEmployeeName("venkat");
            venkat.setSalary(30000.0);
            venkat.setEmployeeId(4);

            hr.add(madhu);
            hr.add(venkat);


            Department finance = new Department();
            finance.setName("Finance Department");

            Employee shiva = new Employee();
            shiva.setEmployeeName("shiva");
            shiva.setSalary(80000);
            shiva.setEmployeeId(5);

            Employee mahi = new Employee();
            mahi.setEmployeeName("mahi");
            mahi.setSalary(85000);
            mahi.setEmployeeId(6);

            finance.add(shiva);
            finance.add(mahi);

            List<Department> departments = new ArrayList<>();
            departments.add(itDepartment);
            departments.add(hr);
            departments.add(finance);


            Optional<Employee> companyMaxSalaryEmployee = departments.stream()
                    .flatMap(department -> department.getEmployeeList().stream())
                    .max((o1, o2) -> o1.compareTo(o2));   //  company Max salary

            companyMaxSalaryEmployee.ifPresent(employee ->
                    System.out.println("Company-wide Max Salary: " + employee));

            // Calculate department-wise maximum salary using Comparable
            departments.forEach(department -> {
                Optional<Employee> maxSalaryEmployee = department.getEmployeeList().stream()
                        .max((o1, o2) -> o1.compareTo(o2));

                maxSalaryEmployee.ifPresent(employee -> {
                    System.out.println("Department: " + department.getName());
                    System.out.println("  Max Salary Employee: " + employee);
                });
            });



            Optional<Employee> companyMaxSalaryEmployee1 = departments.stream()
                    .flatMap(department -> department.getEmployeeList().stream())
                    .min((o1, o2) -> o1.compareTo(o2));   //  company Max salary

            companyMaxSalaryEmployee1.ifPresent(employee ->
                    System.out.println("Company minimum  Salary: " + employee));

            // Calculate department-wise maximum salary using Comparable
            departments.forEach(department -> {
                Optional<Employee> maxSalaryEmployee = department.getEmployeeList().stream()
                        .min((o1, o2) -> o1.compareTo(o2));

                maxSalaryEmployee.ifPresent(employee -> {
                    System.out.println("Department: " + department.getName());
                    System.out.println("  minimum Salary Employee: " + employee);
                });
            });
        }
    }

