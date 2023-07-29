package com.scorpions.projectDetailsMgmt;

import com.scorpions.employeeMgmt.resp.EmployeeResponse;
import com.scorpions.entities.EmployeeProjectDetails;
import com.scorpions.entities.ProjectDetails;
import com.scorpions.projectDetailsMgmt.req.ProjectDetailsRequest;
import com.scorpions.projectDetailsMgmt.resp.AddProjectDetailsResponse;
import com.scorpions.projectDetailsMgmt.resp.ProjectDetailsResponse;
import com.scorpions.service.EmployeeProjectService;
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


    @Autowired
    private EmployeeProjectService empProjectService;

    // Project Details APIs

    @PostMapping("/project")
    public ResponseEntity<AddProjectDetailsResponse> addProjectDetails(
            @RequestBody ProjectDetailsRequest request) {
        // Implement adding project details for an employee
        ProjectDetails details = projectService.saveProject(Utils.toProjectDetails(request));
        EmployeeProjectDetails employeeProjectDetails = new EmployeeProjectDetails(details.getId());
        employeeProjectDetails.setRoles(request.getRoles());
        employeeProjectDetails.setResponsibility(request.getResponsibility());
        employeeProjectDetails.setAchievements(request.getAchievements());
        employeeProjectDetails.setSkillsUsed(request.getSkillsUsed());
        employeeProjectDetails.setFromYear(request.getFromMonth().getYear());
        employeeProjectDetails.setFromMonth(request.getFromMonth().getMonth());
        employeeProjectDetails.setToMonth(request.getToMonth().getMonth());
        employeeProjectDetails.setToYear(request.getToMonth().getYear());
        empProjectService.saveEmpProjectDetails(employeeProjectDetails);
        AddProjectDetailsResponse response = new AddProjectDetailsResponse();
        response.setProjectId(details.getId());
        return ResponseEntity.ok(response);
    }

    @PutMapping("/project/{projectId}")
    public ResponseEntity<String> updateProjectDetails(@PathVariable Long projectId,
            @RequestBody ProjectDetailsRequest request) {
        // Implement updating project details for an employee by projectId
        ProjectDetails details = projectService.updateProject(Utils.toProjectDetails(request, projectId));
        EmployeeProjectDetails employeeProjectDetails = new EmployeeProjectDetails(details.getId());
        employeeProjectDetails.setRoles(request.getRoles());
        employeeProjectDetails.setResponsibility(request.getResponsibility());
        employeeProjectDetails.setAchievements(request.getAchievements());
        employeeProjectDetails.setSkillsUsed(request.getSkillsUsed());
        employeeProjectDetails.setFromYear(request.getFromMonth().getYear());
        employeeProjectDetails.setFromMonth(request.getFromMonth().getMonth());
        employeeProjectDetails.setToMonth(request.getToMonth().getMonth());
        employeeProjectDetails.setToYear(request.getToMonth().getYear());
        empProjectService.saveEmpProjectDetails(employeeProjectDetails);
        return ResponseEntity.ok("Project details updated successfully");
    }

    @DeleteMapping("/project/{projectId}")
    public ResponseEntity<String> deleteProjectDetails(@PathVariable Long projectId) {
        // Implement deleting project details for an employee by projectId
        projectService.deleteProject(projectId);
        List<EmployeeProjectDetails> details = empProjectService.getDetailsByProjectId(projectId);
        details.forEach(project -> empProjectService.deleteEmpProjectDetails(project.getId()));
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