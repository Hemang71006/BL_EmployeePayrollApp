
package com.example.employeepayrollapp.model;

/*
 * Author: Hemang
 * Date: 13-11-2026
 *
 * UC3: Employee Payroll Model
 * This class represents employee payroll information
 * within the application.
 */

public class EmployeePayrollData {

    private String name;
    private double salary;

    // Default constructor
    public EmployeePayrollData() {

    }

    // Parameterized constructor
    public EmployeePayrollData(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    // Getter for employee name
    public String getName() {
        return name;
    }

    // Setter for employee name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for employee salary
    public double getSalary() {
        return salary;
    }

    // Setter for employee salary
    public void setSalary(double salary) {
        this.salary = salary;
    }
}
