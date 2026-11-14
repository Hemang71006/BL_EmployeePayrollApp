
package com.example.employeepayrollapp.controller;

// Import DTO to receive employee details
import com.example.employeepayrollapp.dto.EmployeeDTO;

// Import model to return employee information
import com.example.employeepayrollapp.model.EmployeePayrollData;

// Import service to perform employee operations
import com.example.employeepayrollapp.service.EmployeePayrollService;

// Import Spring REST annotations
import org.springframework.web.bind.annotation.*;

/*
 * Author: Hemang
 * Date: 13-11-2026
 *
 * UC4: Employee Payroll Controller
 * This controller handles HTTP requests and delegates
 * employee operations to the service layer.
 */

// Marks this class as a REST controller
@RestController

// Defines the common URL for all controller endpoints
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    // Stores the EmployeePayrollService object reference
    private final EmployeePayrollService employeePayrollService;

    // Constructor injection: Spring automatically provides the service object
    public EmployeePayrollController(EmployeePayrollService employeePayrollService) {

        // Assign the injected service object to the instance variable
        this.employeePayrollService = employeePayrollService;
    }

    // Handles GET requests to retrieve the employee endpoint
    @GetMapping("/")
    public String getEmployees() {

        // Return a success message
        return "GET Request Successful";
    }

    // Handles GET requests using an employee ID
    @GetMapping("/get/{id}")
    public String getEmployee(@PathVariable int id) {

        // Return a message containing the received employee ID
        return "GET Employee with ID: " + id;
    }

    // Handles POST requests to create an employee
    @PostMapping("/create")
    public EmployeePayrollData createEmployee(@RequestBody EmployeeDTO employeeDTO) {

        // Pass employee details to the service and return its result
        return employeePayrollService.createEmployee(employeeDTO);
    }

    // Handles PUT requests to update employee details
    @PutMapping("/update")
    public EmployeePayrollData updateEmployee(@RequestBody EmployeeDTO employeeDTO) {

        // Call the service update method and return the result
        return employeePayrollService.updateEmployee(employeeDTO);
    }

    // Handles DELETE requests using an employee ID
    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable int id) {

        // Return a success message containing the employee ID
        return "DELETE Request Successful: " + id;
    }
}
