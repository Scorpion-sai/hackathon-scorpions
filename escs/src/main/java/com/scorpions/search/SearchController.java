package com.scorpions.search;

import com.scorpions.entities.Employee;
import com.scorpions.entities.EmployeeProjectDetails;
import com.scorpions.search.req.SearchRequest;
import com.scorpions.search.resp.SearchResponse;
import com.scorpions.service.EmployeeProjectService;
import com.scorpions.service.EmployeeService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SearchController {
    // Search and Filter APIs

    @Autowired
    private EmployeeProjectService empProjectService;

    
    @PostMapping("/search")
    public ResponseEntity<List<EmployeeProjectDetails>> searchEmployees(@RequestBody SearchRequest request) {
        System.out.println(request);
        // Implement searching employees based on given parameters
        List<EmployeeProjectDetails> employeeProjectDetails = null;
        switch(request.getFilter()){
            case NAME -> {
                employeeProjectDetails = empProjectService.getDetailsByEmployeeName(request.getValue());
                
            }
            case EMAILID -> {
                employeeProjectDetails = empProjectService.getDetailsByEmailId(request.getValue());
            }
            case EMPLOYEEID -> {
                employeeProjectDetails = empProjectService.getDetailsByEmployeeId(Long.getLong(request.getValue()));
            }
            case SKILLS -> {
               employeeProjectDetails = empProjectService.getDetailsBySkills(request.getValue());
            }
        }
        // Populate response with search results data
        return ResponseEntity.ok(employeeProjectDetails);
    }

}