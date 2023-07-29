package com.scorpions.service.impl;

import com.scorpions.dao.EmployeeProjectDao;
import com.scorpions.entities.EmployeeProjectDetails;
import com.scorpions.service.EmployeeProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeProjectServiceImpl implements EmployeeProjectService {

    private final EmployeeProjectDao employeeProjectDao;

    @Autowired
    public EmployeeProjectServiceImpl(EmployeeProjectDao employeeProjectDao) {
        this.employeeProjectDao = employeeProjectDao;
    }

    @Override
    public EmployeeProjectDetails saveEmpProjectDetails(EmployeeProjectDetails employee) {
        return employeeProjectDao.saveEmpProjectDetails(employee);
    }

    @Override
    public EmployeeProjectDetails updateEmpProjectDetails(EmployeeProjectDetails employee) {
        return employeeProjectDao.updateEmpProjectDetails(employee);
    }

    @Override
    public void deleteEmpProjectDetails(Long id) {
        employeeProjectDao.deleteEmpProjectDetails(id);
    }

    @Override
    public List<EmployeeProjectDetails> getDetailsByEmployeeId(Long employeeId) {
        return employeeProjectDao.getDetailsByEmployeeId(employeeId);
    }

    @Override
    public List<EmployeeProjectDetails> getDetailsByProjectId(Long projectId) {
        return employeeProjectDao.getDetailsByProjectId(projectId);
    }

    @Override
    public List<EmployeeProjectDetails> getDetailsByEmployeeId(String skills) {
        return employeeProjectDao.getDetailsByEmployeeId(skills);
    }

    @Override
    public EmployeeProjectDetails getDetailsByProjectIdEmployeeId(Long projectId, Long employeeId) {
        return employeeProjectDao.getDetailsByProjectIdEmployeeId(projectId, employeeId);
    }
}