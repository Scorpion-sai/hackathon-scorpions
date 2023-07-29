package com.scorpions.dao.impl;

import com.scorpions.dao.EmployeeDao;
import com.scorpions.entities.Employee;
import com.scorpions.entities.EmployeeProjectDetails;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class EmployeeDaoImpl implements EmployeeDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Employee saveEmployee(Employee employee) {
        entityManager.persist(employee);
        return employee;
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return entityManager.merge(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
        Employee employee = getEmployeeById(id);
        if (employee != null) {
            entityManager.remove(employee);
        }
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return entityManager.find(Employee.class, id);
    }

    @Override public List<Employee> getEmployeeByName(String name) {
        return entityManager.createQuery(
                "SELECT e FROM Employee e WHERE e.name = :name", Employee.class)
                .setParameter("name", name)
                .getResultList();
    }

    @Override public Employee getEmployeeByEmailId(String emailId) {
        return entityManager.createQuery(
                        "SELECT e FROM Employee e WHERE e.emailId = :emailId", Employee.class)
                .setParameter("emailId", emailId)
                .getSingleResult();
    }


    @Override
    public List<Employee> getAllEmployees() {
        return entityManager.createQuery("SELECT e FROM Employee e", Employee.class).getResultList();
    }
}
