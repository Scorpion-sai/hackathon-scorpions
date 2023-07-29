package com.scorpions.projectDetailsMgmt.req;

import com.scorpions.employeeMgmt.resp.EmployeeResponse;
import java.util.List;
import lombok.Data;

@Data
public class ProjectDetailsRequest {
    private String projectName;
    private String projectDescription;
    private String responsibility;
    private String roles;
    private String achievements;
    private String skillsUsed;
    private String durationOfWork;
    private boolean showWithoutAuth;
}
