package com.scorpions.dao;

import com.scorpions.entities.EmployeeProjectDetails;
import java.util.List;

public interface EmployeeProjectDao {

    EmployeeProjectDetails saveEmpProjectDetails(EmployeeProjectDetails employee);

    EmployeeProjectDetails updateEmpProjectDetails(EmployeeProjectDetails employee);

    void deleteEmpProjectDetails(Long id);

    List<EmployeeProjectDetails> getDetailsByEmployeeId(Long employeeId);

    List<EmployeeProjectDetails> getDetailsByProjectId(Long projectId);

    List<EmployeeProjectDetails> getDetailsBySkills(String skills);

    List<EmployeeProjectDetails> getDetailsByEmployeeName(String name);

    List<EmployeeProjectDetails> getDetailsByEmployeeEmailId(String emailId);

    EmployeeProjectDetails getDetailsByProjectIdEmployeeId(Long projectId, Long employeeId);
    
}
