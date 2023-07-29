package com.scorpions.employeeMgmt;

import com.scorpions.employeeMgmt.req.EmployeeRequest;
import com.scorpions.employeeMgmt.resp.AddEmployeeResponse;
import com.scorpions.employeeMgmt.resp.EmployeeResponse;
import com.scorpions.entities.Employee;
import com.scorpions.projectDetailsMgmt.resp.ProjectDetailsResponse;
import com.scorpions.service.EmployeeService;
import com.scorpions.service.ProjectService;
import com.scorpions.utils.Utils;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ProjectService projectService;
    // Employee Management APIs

    @PostMapping("/employee")
    public ResponseEntity<AddEmployeeResponse> addEmployee(@RequestBody EmployeeRequest request) {
        AddEmployeeResponse response = new AddEmployeeResponse();
        Employee employee = employeeService.saveEmployee(Utils.toEmployee(request));
        response.setEmployeeId(employee.getId());
        // Implement adding/updating employee Employee details
        return ResponseEntity.ok(response);
    }

    @PutMapping("/employee/{employeeId}")
    public ResponseEntity<String> updateEmployee(
            @PathVariable Long employeeId,
            @RequestBody EmployeeRequest request) {
        // Implement updating employee Employee details
        employeeService.updateEmployee(Utils.toEmployee(request, employeeId));
        return ResponseEntity.ok("Employee updated successfully");
    }

    @DeleteMapping("/employee/{employeeId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long employeeId) {
        // Implement deleting employee Employee by employeeId
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok("Employee deleted successfully");
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getEmployees() {
        // Populate response with Employees data
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Long employeeId) {
        // Implement getting employee Employee by employeeId
        // Populate response with Employee data
        return ResponseEntity.ok(employeeService.getEmployeeById(employeeId));
    }
}