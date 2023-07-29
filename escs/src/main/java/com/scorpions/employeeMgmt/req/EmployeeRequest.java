package com.scorpions.employeeMgmt.req;

import com.scorpions.projectDetailsMgmt.req.ProjectDetailsRequest;
import java.util.List;
import lombok.Data;

@Data
public class EmployeeRequest {
    private String name;
    private String emailId;
    private String gender;
    private String currentDesignation;
    private int yearsOfExperience;
    private List<String> skills;
    private String areaOfInterest;
    private boolean showWithoutAuth;
    
    private List<ProjectDetailsRequest> projectsList;
}
