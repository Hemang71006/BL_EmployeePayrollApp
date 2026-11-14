package com.example.employeepayrollapp.controller;

// Import DTO to receive employee details
import com.example.employeepayrollapp.dto.EmployeeDTO;

// Import model to return employee information
import com.example.employeepayrollapp.model.EmployeePayrollData;

// Import service to perform employee operations
import com.example.employeepayrollapp.service.EmployeePayrollService;

// Import Spring REST annotations
import org.springframework.web.bind.annotation.*;

// Import HTTP status codes and response handling
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

// Import list for returning multiple employees
import java.util.List;

// Import exception handling
import java.util.NoSuchElementException;

/*
 * Author: Hemang
 * Date: 13-11-2026
 *
 * UC5: Employee Payroll Controller
 * Handles employee CRUD operations through REST APIs.
 */

@RestController

// Defines the common URL for all employee endpoints
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    // Stores the service object reference
    private final EmployeePayrollService employeePayrollService;

    // Constructor injection of the service
    public EmployeePayrollController(EmployeePayrollService employeePayrollService) {

        // Assign the injected service object
        this.employeePayrollService = employeePayrollService;
    }

    // Handles GET requests to retrieve all employees
    @GetMapping("/")
    public List<EmployeePayrollData> getEmployees() {

        // Return all employees from the service
        return employeePayrollService.getAllEmployees();
    }

    // Handles GET requests to retrieve one employee by ID
    @GetMapping("/get/{id}")
    public ResponseEntity<?> getEmployee(@PathVariable int id) {

        try {
            // Retrieve the employee using the supplied ID
            return ResponseEntity.ok(employeePayrollService.getEmployeeById(id));

        } catch (NoSuchElementException exception) {

            // Return 404 when the employee does not exist
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(exception.getMessage());
        }
    }

    // Handles POST requests to create a new employee
    @PostMapping("/create")
    public ResponseEntity<EmployeePayrollData> createEmployee(
            @RequestBody EmployeeDTO employeeDTO) {

        // Create and store the employee
        EmployeePayrollData employee =
                employeePayrollService.createEmployee(employeeDTO);

        // Return the created employee with HTTP 201 status
        return ResponseEntity.status(HttpStatus.CREATED).body(employee);
    }

    // Handles PUT requests to update an existing employee
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateEmployee(
            @PathVariable int id,
            @RequestBody EmployeeDTO employeeDTO) {

        try {
            // Update the employee using the supplied ID
            EmployeePayrollData employee =
                    employeePayrollService.updateEmployee(id, employeeDTO);

            // Return the updated employee
            return ResponseEntity.ok(employee);

        } catch (NoSuchElementException exception) {

            // Return 404 when the employee does not exist
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(exception.getMessage());
        }
    }

    // Handles DELETE requests to remove an employee
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int id) {

        try {
            // Delete the employee using the supplied ID
            employeePayrollService.deleteEmployee(id);

            // Return successful deletion response
            return ResponseEntity.ok("Employee deleted successfully: " + id);

        } catch (NoSuchElementException exception) {

            // Return 404 when the employee does not exist
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(exception.getMessage());
        }
    }
}