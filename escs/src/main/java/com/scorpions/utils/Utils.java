package com.scorpions.utils;

import com.scorpions.employeeMgmt.req.EmployeeRequest;
import com.scorpions.entities.Employee;

public class Utils {
    
    public static Employee toEmployee(EmployeeRequest employeeRequest){
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
        employee.setId(employee.getId());
        employee.setName(employeeRequest.getName());
        employee.setGender(employeeRequest.getGender());
        employee.setEmailId(employeeRequest.getEmailId());
        employee.setCurrentDesignation(employeeRequest.getCurrentDesignation());
        employee.setSkills(employeeRequest.getSkills());
        employee.setAreaOfInterest(employeeRequest.getAreaOfInterest());
        employee.setShowWithoutAuth(employeeRequest.isShowWithoutAuth());
        return employee;
    }
}
