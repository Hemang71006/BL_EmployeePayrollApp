package com.example.employeepayrollapp.model;

/*
 * Author: Hemang
 * Date: 13-11-2026
 *
 * UC5: Employee Payroll Model
 * Represents employee payroll information.
 */

public class EmployeePayrollData {

    // Stores the unique employee ID
    private int id;

    // Stores the employee name
    private String name;

    // Stores the employee salary
    private double salary;

    // Default constructor
    public EmployeePayrollData() {
    }

    // Constructor used when creating an employee
    public EmployeePayrollData(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    // Retains the previous constructor for compatibility with existing code
    public EmployeePayrollData(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    // Returns the employee ID
    public int getId() {
        return id;
    }

    // Updates the employee ID
    public void setId(int id) {
        this.id = id;
    }

    // Returns the employee name
    public String getName() {
        return name;
    }

    // Updates the employee name
    public void setName(String name) {
        this.name = name;
    }

    // Returns the employee salary
    public double getSalary() {
        return salary;
    }

    // Updates the employee salary
    public void setSalary(double salary) {
        this.salary = salary;
    }
}