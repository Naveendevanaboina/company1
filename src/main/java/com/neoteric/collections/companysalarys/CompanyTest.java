package com.neoteric.collections.companysalarys;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CompanyTest {
        public static void main(String[] args) {

            Department itDepartment = new Department();
            itDepartment.setName(" IT Department ");

            Employee A = new Employee();
            A.setEmployeeName("A");
            A.setSalary(20000.0);
            A.setEmployeeId(1);

            Employee B = new Employee();
            B.setEmployeeName("B");
            B.setSalary(50000.0);
            B.setEmployeeId(2);

            itDepartment.add(A);
            itDepartment.add(B);

            Department hr = new Department();
            hr.setName(" HR Deaprtment ");

            Employee C = new Employee();
            C.setEmployeeName("C");
            C.setSalary(10000.0);
            C.setEmployeeId(3);

            Employee D = new Employee();
            D.setEmployeeName("D");
            D.setSalary(30000.0);
            D.setEmployeeId(4);

            hr.add(C);
            hr.add(D);


            Department finance = new Department();
            finance.setName("Finance Department");

            Employee E = new Employee();
            E.setEmployeeName("D");
            E.setSalary(80000);
            E.setEmployeeId(5);

            Employee F = new Employee();
            F.setEmployeeName("F");
            F.setSalary(85000);
            F.setEmployeeId(6);

            finance.add(E);
            finance.add(F);

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

