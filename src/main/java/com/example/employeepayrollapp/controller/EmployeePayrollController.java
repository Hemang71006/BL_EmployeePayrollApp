
package com.example.employeepayrollapp.controller;

import org.springframework.web.bind.annotation.*;

/*
 * Author: Hemang
 * Date: 13-11-2026
 *
 * UC1: REST Controller
 * This controller handles HTTP requests related to Employee Payroll.
 */

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    /*
     * GET API
     * Returns a success message when the endpoint is accessed.
     */
    @GetMapping("/")
    public String getEmployees() {
        return "GET Request Successful";
    }

    /*
     * GET API with Path Variable
     * Reads the employee ID from the URL.
     */
    @GetMapping("/get/{id}")
    public String getEmployee(@PathVariable int id) {
        return "GET Employee with ID: " + id;
    }

    /*
     * POST API
     * Accepts employee information in the request body.
     */
    @PostMapping("/create")
    public String createEmployee(@RequestBody String employee) {
        return "POST Request Successful: " + employee;
    }

    /*
     * PUT API
     * Accepts employee information for an update request.
     */
    @PutMapping("/update")
    public String updateEmployee(@RequestBody String employee) {
        return "PUT Request Successful: " + employee;
    }

    /*
     * DELETE API
     * Reads the employee ID from the URL.
     */
    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable int id) {
        return "DELETE Request Successful: " + id;
    }
}
