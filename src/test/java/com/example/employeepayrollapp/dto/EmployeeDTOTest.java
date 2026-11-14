
package com.example.employeepayrollapp.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
 * Author: Hemang
 * Date: 13-11-2026
 *
 * UC3: Employee DTO Tests
 */

class EmployeeDTOTest {

    @Test
    void givenEmployeeDetails_whenCreated_thenReturnEmployeeDetails() {

        EmployeeDTO employeeDTO = new EmployeeDTO("Hemang", 50000);

        assertEquals("Hemang", employeeDTO.getName());
        assertEquals(50000, employeeDTO.getSalary());
    }

    @Test
    void givenEmployeeDTO_whenUsingSetters_thenUpdateEmployeeDetails() {

        EmployeeDTO employeeDTO = new EmployeeDTO();

        employeeDTO.setName("Rahul");
        employeeDTO.setSalary(60000);

        assertEquals("Rahul", employeeDTO.getName());
        assertEquals(60000, employeeDTO.getSalary());
    }
}
