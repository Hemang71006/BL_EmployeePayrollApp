
package com.example.employeepayrollapp.service;

// Import DTO for creating test employee details
import com.example.employeepayrollapp.dto.EmployeeDTO;

// Import model to verify returned employee objects
import com.example.employeepayrollapp.model.EmployeePayrollData;

// Import JUnit Test annotation
import org.junit.jupiter.api.Test;

// Import assertion methods
import static org.junit.jupiter.api.Assertions.*;

/*
 * Author: Hemang
 * Date: 13-11-2026
 *
 * UC4: Employee Payroll Service Tests
 * Tests employee creation and update service methods.
 */

class EmployeePayrollServiceTest {

    // Create the service object to test its methods directly
    private final EmployeePayrollService employeePayrollService =
            new EmployeePayrollService();

    // Test whether the createEmployee method returns correct employee details
    @Test
    void givenEmployeeDTO_whenCreateEmployee_thenReturnEmployee() {

        // Create DTO containing sample employee information
        EmployeeDTO employeeDTO = new EmployeeDTO("Hemang", 50000);

        // Call the service method to create an employee
        EmployeePayrollData employee =
                employeePayrollService.createEmployee(employeeDTO);

        // Verify that the returned employee object is not null
        assertNotNull(employee);

        // Verify that the employee name is correct
        assertEquals("Hemang", employee.getName());

        // Verify that the employee salary is correct
        assertEquals(50000, employee.getSalary());
    }

    // Test whether the updateEmployee method returns correct employee details
    @Test
    void givenEmployeeDTO_whenUpdateEmployee_thenReturnEmployee() {

        // Create DTO containing updated employee information
        EmployeeDTO employeeDTO = new EmployeeDTO("Hemang", 60000);

        // Call the service update method
        EmployeePayrollData employee =
                employeePayrollService.updateEmployee(employeeDTO);

        // Verify that the returned employee object is not null
        assertNotNull(employee);

        // Verify that the employee name is correct
        assertEquals("Hemang", employee.getName());

        // Verify that the updated salary is correct
        assertEquals(60000, employee.getSalary());
    }
}
