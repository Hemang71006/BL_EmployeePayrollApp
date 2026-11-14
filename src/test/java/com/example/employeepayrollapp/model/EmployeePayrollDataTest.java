
package com.example.employeepayrollapp.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
 * Author: Hemang
 * Date: 13-11-2026
 *
 * UC3: Employee Payroll Model Tests
 */

class EmployeePayrollDataTest {

    @Test
    void givenEmployeeDetails_whenCreated_thenReturnEmployeeDetails() {

        EmployeePayrollData employee =
                new EmployeePayrollData("Hemang", 50000);

        assertEquals("Hemang", employee.getName());
        assertEquals(50000, employee.getSalary());
    }

    @Test
    void givenEmployee_whenUsingSetters_thenUpdateEmployeeDetails() {

        EmployeePayrollData employee = new EmployeePayrollData();

        employee.setName("Rahul");
        employee.setSalary(60000);

        assertEquals("Rahul", employee.getName());
        assertEquals(60000, employee.getSalary());
    }
}
