package com.scorpions.projectDetailsMgmt;

import com.scorpions.employeeMgmt.resp.EmployeeResponse;
import com.scorpions.entities.ProjectDetails;
import com.scorpions.projectDetailsMgmt.req.ProjectDetailsRequest;
import com.scorpions.projectDetailsMgmt.resp.AddProjectDetailsResponse;
import com.scorpions.projectDetailsMgmt.resp.ProjectDetailsResponse;
import com.scorpions.service.EmployeeService;
import com.scorpions.service.ProjectService;
import com.scorpions.utils.Utils;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ProjectDetailsController {

    @Autowired
    private ProjectService projectService;

    // Project Details APIs

    @PostMapping("/project")
    public ResponseEntity<AddProjectDetailsResponse> addProjectDetails(@RequestBody ProjectDetailsRequest request) {
        // Implement adding project details for an employee
        ProjectDetails details = projectService.saveProject(Utils.toProjectDetails(request));
        AddProjectDetailsResponse response = new AddProjectDetailsResponse();
        response.setProjectId(details.getId());
        return ResponseEntity.ok(response);
    }

    @PutMapping("/project/{projectId}")
    public ResponseEntity<String> updateProjectDetails(@PathVariable Long projectId,
            @RequestBody ProjectDetailsRequest request) {
        // Implement updating project details for an employee by projectId
        ProjectDetails details = projectService.updateProject(Utils.toProjectDetails(request, projectId));
        return ResponseEntity.ok("Project details updated successfully");
    }

    @DeleteMapping("/project/{projectId}")
    public ResponseEntity<String> deleteProjectDetails(@PathVariable Long projectId) {
        // Implement deleting project details for an employee by projectId
        projectService.deleteProject(projectId);
        return ResponseEntity.ok("Project details deleted successfully");
    }

    @GetMapping("/project/{projectId}")
    public ResponseEntity<ProjectDetails> getProjectDetails(@PathVariable Long projectId) {
        // Implement getting project details by projectId
        // Populate response with project details data
        return ResponseEntity.ok(projectService.getProjectById(projectId));
    }

    @GetMapping("/projects")
    public ResponseEntity<List<ProjectDetails>> getAllProjectDetails() {
        // Implement getting project details by projectId
        // Populate response with project details data
        return ResponseEntity.ok(projectService.getAllProjects());
    }
}