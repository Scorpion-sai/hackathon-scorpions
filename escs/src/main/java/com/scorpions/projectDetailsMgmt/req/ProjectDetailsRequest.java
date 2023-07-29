package com.scorpions.projectDetailsMgmt.req;

import lombok.Data;

@Data
public class ProjectDetailsRequest {
    private String projectName;
    private String projectDescription;
    private String responsibility;
    private String roles;
    private String achievements;
    private String skillsUsed;
    private boolean showWithoutAuth;
    private WorkDuration from;
    private WorkDuration to;
}
