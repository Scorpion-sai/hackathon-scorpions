package com.scorpions.utils;

import com.scorpions.employeeMgmt.req.AddEmployeeRequest;
import com.scorpions.employeeMgmt.req.EmployeeRequest;
import com.scorpions.entities.Employee;
import com.scorpions.entities.ProjectDetails;
import com.scorpions.projectDetailsMgmt.req.ProjectDetailsRequest;

public class Utils {
    
    public static Employee toEmployee(AddEmployeeRequest employeeRequest){
        Employee employee = new Employee();
        employee.setName(employeeRequest.getName());
        employee.setGender(employeeRequest.getGender());
        employee.setEmailId(employeeRequest.getEmailId());
        employee.setCurrentDesignation(employeeRequest.getCurrentDesignation());
        employee.setSkills(employeeRequest.getSkills());
        employee.setAreaOfInterest(employeeRequest.getAreaOfInterest());
        employee.setShowWithoutAuth(employeeRequest.isShowWithoutAuth());
        return employee;
    }

    public static Employee toEmployee(EmployeeRequest employeeRequest, Long employeeId){
        Employee employee = new Employee();
        employee.setName(employeeRequest.getName());
        employee.setGender(employeeRequest.getGender());
        employee.setEmailId(employeeRequest.getEmailId());
        employee.setCurrentDesignation(employeeRequest.getCurrentDesignation());
        employee.setSkills(employeeRequest.getSkills());
        employee.setAreaOfInterest(employeeRequest.getAreaOfInterest());
        employee.setShowWithoutAuth(employeeRequest.isShowWithoutAuth());
        employee.setId(employeeId);
        return employee;
    }
    
    public static ProjectDetails toProjectDetails(ProjectDetailsRequest projectDetailsRequest){
        ProjectDetails details  = new ProjectDetails();;
        details.setProjectName(projectDetailsRequest.getProjectName());
        details.setProjectDescription(projectDetailsRequest.getProjectDescription());
        details.setShowWithoutAuth(projectDetailsRequest.isShowWithoutAuth());
        return details;
    }
    
    public static ProjectDetails toProjectDetails(ProjectDetailsRequest projectDetailsRequest, Long projectId){
        ProjectDetails details  = toProjectDetails(projectDetailsRequest);
        details.setId(projectId);
        return details;
    }
}
