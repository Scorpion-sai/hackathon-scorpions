package com.scorpions.employeeMgmt;

import com.scorpions.employeeMgmt.req.EmployeeRequest;
import com.scorpions.employeeMgmt.resp.AddEmployeeResponse;
import com.scorpions.employeeMgmt.resp.EmployeeResponse;
import com.scorpions.projectDetailsMgmt.resp.ProjectDetailsResponse;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    // Employee Management APIs

    @PostMapping("/employee")
    public ResponseEntity<AddEmployeeResponse> addEmployee(@RequestBody EmployeeRequest request) {
        AddEmployeeResponse response = new AddEmployeeResponse();
        response.setEmployeeId("Employee added/updated successfully");
        // Implement adding/updating employee Employee details
        return ResponseEntity.ok(response);
    }

    @PutMapping("/employee")
    public ResponseEntity<String> updateEmployee(@RequestBody EmployeeRequest request) {
        // Implement updating employee Employee details
        return ResponseEntity.ok("Employee updated successfully");
    }

    @DeleteMapping("/employee/{employeeId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable String employeeId) {
        // Implement deleting employee Employee by employeeId
        return ResponseEntity.ok("Employee deleted successfully");
    }

    @GetMapping("/employees")
    public ResponseEntity<List<EmployeeResponse>> getEmployees() {
        List<EmployeeResponse> employeesList = new ArrayList<>();
        // Implement getting all employee Employees
        EmployeeResponse response = new EmployeeResponse();
        // Populate response with Employees data
        return ResponseEntity.ok(employeesList);
    }

    @GetMapping("/Employee/{employeeId}")
    public ResponseEntity<EmployeeResponse> getEmployee(@PathVariable String employeeId) {
        // Implement getting employee Employee by employeeId
        EmployeeResponse response = new EmployeeResponse();
        // Populate response with Employee data
        return ResponseEntity.ok(response);
    }

    @GetMapping("/Employee/project/{projectId}")
    public ResponseEntity<ProjectDetailsResponse> getEmployeeByProjectId(@PathVariable String projectId) {
        // Implement getting employee Employees associated with a project by projectId
        ProjectDetailsResponse response = new ProjectDetailsResponse();
        // Populate response with Employee data related to the project
        return ResponseEntity.ok(response);
    }

}