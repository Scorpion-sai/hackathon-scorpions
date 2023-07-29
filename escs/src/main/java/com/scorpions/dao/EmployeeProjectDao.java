package com.scorpions.dao;

import com.scorpions.entities.EmployeeProjectDetails;
import java.util.List;

public interface EmployeeProjectDao {

    EmployeeProjectDetails saveEmpProjectDetails(EmployeeProjectDetails employee);

    EmployeeProjectDetails updateEmployee(EmployeeProjectDetails employee);

    void deleteEmployee(Long id);

    List<EmployeeProjectDetails> getDetailsByEmployeeId(Long employeeId);

    List<EmployeeProjectDetails> getDetailsByProjectId(Long projectId);

    List<EmployeeProjectDetails> getDetailsByEmployeeId(String skills);

    EmployeeProjectDetails getDetailsByProjectIdEmployeeId(Long projectId, Long employeeId);
    
}
