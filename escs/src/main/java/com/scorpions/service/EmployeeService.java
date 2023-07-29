package com.scorpions.service;

import com.scorpions.entities.Employee;
import java.util.List;

public interface EmployeeService {

    Employee saveEmployee(Employee employee);

    Employee updateEmployee(Employee employee);

    void deleteEmployee(Long id);

    Employee getEmployeeById(Long id);

    List<Employee> getAllEmployees();

    List<Employee> getEmployeeByName(String Name);

    Employee getEmployeeByEmailId(String emailId);
}

