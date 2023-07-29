package com.scorpions.dao;

import com.scorpions.entities.Employee;
import java.util.List;

public interface EmployeeDao {

    Employee saveEmployee(Employee employee);

    Employee updateEmployee(Employee employee);

    void deleteEmployee(Long id);

    Employee getEmployeeById(Long id);

    List<Employee> getEmployeeByName(String Name);

    Employee getEmployeeByEmailId(String emailId);
    
    List<Employee> getAllEmployees();
}
