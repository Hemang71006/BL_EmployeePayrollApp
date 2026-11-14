
package com.example.employeepayrollapp.service;

// Import DTO to receive employee details from the client
import com.example.employeepayrollapp.dto.EmployeeDTO;

// Import model to create employee payroll objects
import com.example.employeepayrollapp.model.EmployeePayrollData;

// Import Service annotation from Spring
import org.springframework.stereotype.Service;

/*
 * Author: Hemang
 * Date: 13-11-2026
 *
 * UC4: Employee Payroll Service
 * This class contains business logic for employee operations.
 */

// Marks this class as a Spring service component
@Service
public class EmployeePayrollService {

    // Creates an employee using the details received through DTO
    public EmployeePayrollData createEmployee(EmployeeDTO employeeDTO) {

        // Create and return an EmployeePayrollData object
        return new EmployeePayrollData(
                employeeDTO.getName(),       // Get employee name from DTO
                employeeDTO.getSalary()      // Get employee salary from DTO
        );
    }

    // Handles the employee update request
    public EmployeePayrollData updateEmployee(EmployeeDTO employeeDTO) {

        // Create and return an EmployeePayrollData object with updated details
        return new EmployeePayrollData(
                employeeDTO.getName(),       // Get employee name from DTO
                employeeDTO.getSalary()      // Get employee salary from DTO
        );
    }
}
