package com.scorpions.projectDetailsMgmt.req;

import com.scorpions.employeeMgmt.resp.EmployeeResponse;
import java.util.List;
import lombok.Data;

@Data
public class ProjectDetailsRequest {
    private String projectId;
    private String projectName;
    private String projectDescription;
    private String rolesAndResponsibility;
    private String achievements;
    private List<String> skillsUsed;
    private String durationOfWork;
    private boolean showWithoutAuth;
    private List<EmployeeResponse> employees;
    //private List<EmployeeResponse> previousEmployees;
}
