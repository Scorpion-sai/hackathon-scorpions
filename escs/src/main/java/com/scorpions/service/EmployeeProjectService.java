package com.scorpions.service;

import com.scorpions.entities.EmployeeProjectDetails;
import java.util.List;

public interface EmployeeProjectService {

    EmployeeProjectDetails saveEmpProjectDetails(EmployeeProjectDetails employee);

    EmployeeProjectDetails updateEmpProjectDetails(EmployeeProjectDetails employee);

    void deleteEmpProjectDetails(Long id);

    List<EmployeeProjectDetails> getDetailsByEmployeeId(Long employeeId);

    List<EmployeeProjectDetails> getDetailsByProjectId(Long projectId);

    List<EmployeeProjectDetails> getDetailsByEmployeeId(String skills);

    EmployeeProjectDetails getDetailsByProjectIdEmployeeId(Long projectId, Long employeeId);

    List<EmployeeProjectDetails> getDetailsByEmployeeName(String name);
}
