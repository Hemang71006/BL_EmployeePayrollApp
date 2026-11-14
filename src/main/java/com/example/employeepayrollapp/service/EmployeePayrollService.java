package com.example.employeepayrollapp.service;

// Import DTO to receive employee details
import com.example.employeepayrollapp.dto.EmployeeDTO;

// Import model to represent employee information
import com.example.employeepayrollapp.model.EmployeePayrollData;

// Import Spring service annotation
import org.springframework.stereotype.Service;

// Import collections for in-memory storage
import java.util.ArrayList;
import java.util.List;

// Import exception for handling missing employees
import java.util.NoSuchElementException;

/*
 * Author: Hemang
 * Date: 13-11-2026
 *
 * UC5: Employee Payroll Service
 * Stores and manages employee records using an ArrayList.
 */

@Service
public class EmployeePayrollService {

    // Stores employee records temporarily in application memory
    private final List<EmployeePayrollData> employeePayrollList = new ArrayList<>();

    // Generates unique employee IDs
    private int nextId = 1;

    // Creates and stores a new employee
    public EmployeePayrollData createEmployee(EmployeeDTO employeeDTO) {

        // Generate a unique ID for the new employee
        EmployeePayrollData employee = new EmployeePayrollData(
                nextId++,
                employeeDTO.getName(),
                employeeDTO.getSalary()
        );

        // Add the employee to the in-memory list
        employeePayrollList.add(employee);

        // Return the newly created employee
        return employee;
    }

    // Returns all employees stored in the list
    public List<EmployeePayrollData> getAllEmployees() {

        // Return a copy to prevent external modification of the stored list
        return new ArrayList<>(employeePayrollList);
    }

    // Returns an employee using their ID
    public EmployeePayrollData getEmployeeById(int id) {

        // Search for the employee with the requested ID
        return employeePayrollList.stream()
                .filter(employee -> employee.getId() == id)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException(
                        "Employee not found with ID: " + id
                ));
    }

    // Updates an existing employee using their ID
    public EmployeePayrollData updateEmployee(int id, EmployeeDTO employeeDTO) {

        // Find the employee that needs to be updated
        EmployeePayrollData employee = getEmployeeById(id);

        // Update the employee's name
        employee.setName(employeeDTO.getName());

        // Update the employee's salary
        employee.setSalary(employeeDTO.getSalary());

        // Return the updated employee
        return employee;
    }

    // Deletes an employee using their ID
    public void deleteEmployee(int id) {

        // Find the employee before removing it
        EmployeePayrollData employee = getEmployeeById(id);

        // Remove the employee from the list
        employeePayrollList.remove(employee);
    }
}