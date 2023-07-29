package com.scorpions.projectDetailsMgmt;

import com.scorpions.employeeMgmt.resp.EmployeeResponse;
import com.scorpions.projectDetailsMgmt.req.ProjectDetailsRequest;
import com.scorpions.projectDetailsMgmt.resp.AddProjectDetailsResponse;
import com.scorpions.projectDetailsMgmt.resp.ProjectDetailsResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ProjectDetailsController {

    // Project Details APIs

    @PostMapping("/projects")
    public ResponseEntity<AddProjectDetailsResponse> addProjectDetails(@RequestBody ProjectDetailsRequest request) {
        // Implement adding project details for an employee
        AddProjectDetailsResponse response = new AddProjectDetailsResponse();
        response.setProjectId("Project details added successfully");
        return ResponseEntity.ok(response);
    }

    @PutMapping("/projects/{projectId}")
    public ResponseEntity<String> updateProjectDetails(@PathVariable String projectId,
            @RequestBody ProjectDetailsRequest request) {
        // Implement updating project details for an employee by projectId
        return ResponseEntity.ok("Project details updated successfully");
    }

    @DeleteMapping("/projects/{projectId}")
    public ResponseEntity<String> deleteProjectDetails(@PathVariable String projectId) {
        // Implement deleting project details for an employee by projectId
        return ResponseEntity.ok("Project details deleted successfully");
    }

    @GetMapping("/projects/{projectId}")
    public ResponseEntity<ProjectDetailsResponse> getProjectDetails(@PathVariable String projectId) {
        // Implement getting project details by projectId
        ProjectDetailsResponse response = new ProjectDetailsResponse();
        // Populate response with project details data
        return ResponseEntity.ok(response);
    }

    @GetMapping("/projects/employee/{employeeId}")
    public ResponseEntity<EmployeeResponse> getProjectDetailsByEmployeeId(@PathVariable String employeeId) {
        // Implement getting project details for an employee by employeeId
        EmployeeResponse response = new EmployeeResponse();
        // Populate response with project details data related to the employee
        return ResponseEntity.ok(response);
    }

}