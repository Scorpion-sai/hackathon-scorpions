package com.scorpions.projectDetailsMgmt;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ProjectDetailsController {

    // Project Details APIs

    @PostMapping("/projects")
    public ResponseEntity<String> addProjectDetails(@RequestBody AddProjectDetailsRequest request) {
        // Implement adding project details for an employee
        return ResponseEntity.ok("Project details added successfully");
    }

    @PutMapping("/projects/{projectId}")
    public ResponseEntity<String> updateProjectDetails(@PathVariable String projectId,
            @RequestBody UpdateProjectDetailsRequest request) {
        // Implement updating project details for an employee by projectId
        return ResponseEntity.ok("Project details updated successfully");
    }

    @DeleteMapping("/projects/{projectId}")
    public ResponseEntity<String> deleteProjectDetails(@PathVariable String projectId) {
        // Implement deleting project details for an employee by projectId
        return ResponseEntity.ok("Project details deleted successfully");
    }

    @GetMapping("/projects/{projectId}")
    public ResponseEntity<GetProjectDetailsResponse> getProjectDetails(@PathVariable String projectId) {
        // Implement getting project details by projectId
        GetProjectDetailsResponse response = new GetProjectDetailsResponse();
        // Populate response with project details data
        return ResponseEntity.ok(response);
    }

    @GetMapping("/projects/employee/{employeeId}")
    public ResponseEntity<GetProjectDetailsByEmployeeIdResponse> getProjectDetailsByEmployeeId(@PathVariable String employeeId) {
        // Implement getting project details for an employee by employeeId
        GetProjectDetailsByEmployeeIdResponse response = new GetProjectDetailsByEmployeeIdResponse();
        // Populate response with project details data related to the employee
        return ResponseEntity.ok(response);
    }

}