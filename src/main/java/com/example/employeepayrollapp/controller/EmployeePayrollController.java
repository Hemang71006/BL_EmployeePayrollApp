
package com.example.employeepayrollapp.controller;

import com.example.employeepayrollapp.dto.EmployeeDTO;
import com.example.employeepayrollapp.model.EmployeePayrollData;
import org.springframework.web.bind.annotation.*;

/*
 * Author: Hemang
 * Date: 13-11-2026
 *
 * UC3: REST Controller with DTO and Model
 * This controller handles employee payroll requests.
 */

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    // GET API
    @GetMapping("/")
    public String getEmployees() {
        return "GET Request Successful";
    }

    // GET API with Path Variable
    @GetMapping("/get/{id}")
    public String getEmployee(@PathVariable int id) {
        return "GET Employee with ID: " + id;
    }

    // POST API: Accepts EmployeeDTO and returns EmployeePayrollData
    @PostMapping("/create")
    public EmployeePayrollData createEmployee(@RequestBody EmployeeDTO employeeDTO) {

        EmployeePayrollData employee = new EmployeePayrollData(
                employeeDTO.getName(),
                employeeDTO.getSalary()
        );

        return employee;
    }

    // PUT API: Accepts EmployeeDTO and returns EmployeePayrollData
    @PutMapping("/update")
    public EmployeePayrollData updateEmployee(@RequestBody EmployeeDTO employeeDTO) {

        EmployeePayrollData employee = new EmployeePayrollData(
                employeeDTO.getName(),
                employeeDTO.getSalary()
        );

        return employee;
    }

    // DELETE API
    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable int id) {
        return "DELETE Request Successful: " + id;
    }
}
