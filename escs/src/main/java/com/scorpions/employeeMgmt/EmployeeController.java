package com.scorpions.employeeMgmt;

import com.scorpions.employeeMgmt.req.AddEmployeeRequest;
import com.scorpions.employeeMgmt.req.EmployeeRequest;
import com.scorpions.employeeMgmt.resp.AddEmployeeResponse;
import com.scorpions.entities.Employee;
import com.scorpions.entities.EmployeeProjectDetails;
import com.scorpions.entities.ProjectDetails;
import com.scorpions.service.EmployeeProjectService;
import com.scorpions.service.EmployeeService;
import com.scorpions.service.ProjectService;
import com.scorpions.utils.Utils;
import jakarta.transaction.Transactional;
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


    @Autowired
    private EmployeeProjectService empProjectService;
    // Employee Management APIs

    @PostMapping("/employee")
    @Transactional
    public ResponseEntity<AddEmployeeResponse> addEmployee(@RequestBody AddEmployeeRequest request) {
        System.out.println(request);
        AddEmployeeResponse response = new AddEmployeeResponse();
        Employee employee = employeeService.saveEmployee(Utils.toEmployee(request));
        if(request.getProjectsList() != null && request.getProjectsList().size() > 0) {
            request.getProjectsList().forEach(project -> {
                ProjectDetails projectDetails = new ProjectDetails();
                projectDetails.setProjectName(project.getProjectName());
                projectDetails.setProjectDescription(project.getProjectName());
                projectDetails.setShowWithoutAuth(project.isShowWithoutAuth());
                ProjectDetails newProject = projectService.saveProject(projectDetails);

                EmployeeProjectDetails empProjectDetails = new EmployeeProjectDetails(newProject.getId());
                empProjectDetails.setEmployeeId(employee.getId());
                empProjectDetails.setAchievements(project.getAchievements());
                empProjectDetails.setRoles(project.getRoles());
                empProjectDetails.setResponsibility(project.getResponsibility());
                empProjectDetails.setSkillsUsed(List.of(request.getSkills().split(",")));
                if(project.getFrom() != null){
                    empProjectDetails.setFromMonth(project.getFrom().getMonth());
                    empProjectDetails.setFromYear(project.getFrom().getYear()); 
                }
                if(project.getTo() != null) {
                    empProjectDetails.setToMonth(project.getTo().getMonth());
                    empProjectDetails.setToYear(project.getTo().getYear());
                }
                empProjectService.saveEmpProjectDetails(empProjectDetails);
            });
        }
        
        response.setEmployeeId(employee.getId());
        // Implement adding/updating employee Employee details
        return ResponseEntity.ok(response);
    }

    @Transactional
    @PutMapping("/employee/{employeeId}")
    public ResponseEntity<String> updateEmployee(
            @PathVariable Long employeeId,
            @RequestBody EmployeeRequest request) {
        System.out.println(request);
        // Implement updating employee Employee details
        employeeService.updateEmployee(Utils.toEmployee(request, employeeId));
        return ResponseEntity.ok("Employee updated successfully");
    }

    @DeleteMapping("/employee/{employeeId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long employeeId) {
        // Implement deleting employee Employee by employeeId
        employeeService.deleteEmployee(employeeId);
        List<EmployeeProjectDetails> projectEmpMap = empProjectService.getDetailsByEmployeeId(employeeId);
        projectEmpMap.forEach(project -> empProjectService.deleteEmpProjectDetails(project.getId()));
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

    @GetMapping("/employeeByName")
    public ResponseEntity<List<Employee>> getEmployeeByName(@RequestParam String name) {
        // Implement getting employee Employee by employeeId
        // Populate response with Employee data
        return ResponseEntity.ok(employeeService.getEmployeeByName(name));
    }

    @GetMapping("/employeeByEmailId")
    public ResponseEntity<Employee> getEmployeeByEmailId(@RequestParam String emailId) {
        // Implement getting employee Employee by employeeId
        // Populate response with Employee data
        return ResponseEntity.ok(employeeService.getEmployeeByEmailId(emailId));
    }
}