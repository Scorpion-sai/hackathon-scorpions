package com.scorpions.service.impl;

import com.scorpions.dao.EmployeeDao;
import com.scorpions.entities.Employee;
import com.scorpions.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDao employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDao employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeDAO.saveEmployee(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeDAO.updateEmployee(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeDAO.deleteEmployee(id);
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeDAO.getEmployeeById(id);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    @Override public List<Employee> getEmployeeByName(String Name) {
        return employeeDAO.getEmployeeByName(Name);
    }

    @Override public List<Employee> getEmployeeByEmailId(String emailId) {
        return employeeDAO.getEmployeeByEmailId(emailId);
    }
}
