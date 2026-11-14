package com.example.employeepayrollapp.service;

// Import DTO for employee test data
import com.example.employeepayrollapp.dto.EmployeeDTO;

// Import model for checking employee results
import com.example.employeepayrollapp.model.EmployeePayrollData;

// Import JUnit annotations
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// Import collection
import java.util.List;

// Import assertion methods
import static org.junit.jupiter.api.Assertions.*;

/*
 * Author: Hemang
 * Date: 13-11-2026
 *
 * UC5: Employee Payroll Service Tests
 * Tests employee creation, retrieval, updating and deletion.
 */

class EmployeePayrollServiceTest {

    // Service instance used for testing
    private EmployeePayrollService employeePayrollService;

    // Initialize a fresh service before every test
    @BeforeEach
    void setUp() {

        // Create a new service with an empty employee list
        employeePayrollService = new EmployeePayrollService();
    }

    // Test employee creation
    @Test
    void givenEmployeeDTO_whenCreateEmployee_thenEmployeeShouldBeStored() {

        // Create sample employee details
        EmployeeDTO employeeDTO = new EmployeeDTO("Hemang", 50000);

        // Create and store the employee
        EmployeePayrollData employee =
                employeePayrollService.createEmployee(employeeDTO);

        // Verify that the employee was created
        assertNotNull(employee);

        // Verify that the first employee receives ID 1
        assertEquals(1, employee.getId());

        // Verify employee details
        assertEquals("Hemang", employee.getName());
        assertEquals(50000, employee.getSalary());

        // Verify that the employee is stored in the list
        assertEquals(1, employeePayrollService.getAllEmployees().size());
    }

    // Test retrieving all employees
    @Test
    void givenMultipleEmployees_whenGetAllEmployees_thenReturnEmployeeList() {

        // Create two employees
        employeePayrollService.createEmployee(new EmployeeDTO("Hemang", 50000));
        employeePayrollService.createEmployee(new EmployeeDTO("Rahul", 60000));

        // Retrieve all employees
        List<EmployeePayrollData> employees =
                employeePayrollService.getAllEmployees();

        // Verify that both employees are returned
        assertEquals(2, employees.size());
    }

    // Test retrieving an employee by ID
    @Test
    void givenEmployeeId_whenGetEmployeeById_thenReturnEmployee() {

        // Store an employee
        EmployeePayrollData createdEmployee =
                employeePayrollService.createEmployee(
                        new EmployeeDTO("Hemang", 50000)
                );

        // Retrieve the employee using its ID
        EmployeePayrollData employee =
                employeePayrollService.getEmployeeById(createdEmployee.getId());

        // Verify the retrieved employee
        assertEquals("Hemang", employee.getName());
        assertEquals(50000, employee.getSalary());
    }

    // Test updating an employee
    @Test
    void givenEmployeeIdAndDTO_whenUpdateEmployee_thenUpdateEmployeeDetails() {

        // Create an employee
        EmployeePayrollData createdEmployee =
                employeePayrollService.createEmployee(
                        new EmployeeDTO("Hemang", 50000)
                );

        // Create updated employee details
        EmployeeDTO updatedDTO = new EmployeeDTO("Hemang", 70000);

        // Update the employee
        EmployeePayrollData updatedEmployee =
                employeePayrollService.updateEmployee(
                        createdEmployee.getId(), updatedDTO
                );

        // Verify that the employee details were updated
        assertEquals("Hemang", updatedEmployee.getName());
        assertEquals(70000, updatedEmployee.getSalary());

        // Verify that updating did not create an additional employee
        assertEquals(1, employeePayrollService.getAllEmployees().size());
    }

    // Test deleting an employee
    @Test
    void givenEmployeeId_whenDeleteEmployee_thenRemoveEmployee() {

        // Create an employee
        EmployeePayrollData employee =
                employeePayrollService.createEmployee(
                        new EmployeeDTO("Hemang", 50000)
                );

        // Delete the employee
        employeePayrollService.deleteEmployee(employee.getId());

        // Verify that the employee list is empty
        assertTrue(employeePayrollService.getAllEmployees().isEmpty());
    }

    // Test handling an invalid employee ID
    @Test
    void givenInvalidEmployeeId_whenGetEmployeeById_thenThrowException() {

        // Verify that requesting a missing employee throws an exception
        assertThrows(
                java.util.NoSuchElementException.class,
                () -> employeePayrollService.getEmployeeById(999)
        );
    }
}