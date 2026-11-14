
package com.example.employeepayrollapp.dto;

/*
 * Author: Hemang
 * Date: 13-11-2026
 *
 * UC3: Employee Data Transfer Object
 * This class carries employee information from the client
 * to the controller.
 */

public class EmployeeDTO {

    private String name;
    private double salary;

    // Default constructor
    public EmployeeDTO() {

    }

    // Parameterized constructor
    public EmployeeDTO(String name, double salary) {
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
