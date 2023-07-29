package com.scorpions.dao.impl;

import com.scorpions.dao.EmployeeProjectDao;
import com.scorpions.entities.EmployeeProjectDetails;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeProjectDaoImpl implements EmployeeProjectDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public EmployeeProjectDetails saveEmpProjectDetails(EmployeeProjectDetails employee) {
        entityManager.persist(employee);
        return employee;
    }

    @Override
    public EmployeeProjectDetails updateEmployee(EmployeeProjectDetails employee) {
        return entityManager.merge(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
        EmployeeProjectDetails employee = entityManager.find(EmployeeProjectDetails.class, id);
        if (employee != null) {
            entityManager.remove(employee);
        }
    }

    @Override
    public List<EmployeeProjectDetails> getDetailsByEmployeeId(Long employeeId) {
        return entityManager.createQuery(
                        "SELECT e FROM EmployeeProjectDetails e WHERE e.employeeId = :employeeId",
                        EmployeeProjectDetails.class
                ).setParameter("employeeId", employeeId)
                .getResultList();
    }

    @Override
    public List<EmployeeProjectDetails> getDetailsByProjectId(Long projectId) {
        return entityManager.createQuery(
                        "SELECT e FROM EmployeeProjectDetails e WHERE e.projectId = :projectId",
                        EmployeeProjectDetails.class
                ).setParameter("projectId", projectId)
                .getResultList();
    }

    @Override
    public List<EmployeeProjectDetails> getDetailsByEmployeeId(String skills) {
        return entityManager.createQuery(
                        "SELECT e FROM EmployeeProjectDetails e WHERE e.skills = :skills",
                        EmployeeProjectDetails.class
                ).setParameter("skills", skills)
                .getResultList();
    }

    @Override
    public EmployeeProjectDetails getDetailsByProjectIdEmployeeId(Long projectId, Long employeeId) {
        return entityManager.createQuery(
                        "SELECT e FROM EmployeeProjectDetails e WHERE e.projectId = :projectId AND e.employeeId = :employeeId",
                        EmployeeProjectDetails.class
                ).setParameter("projectId", projectId)
                .setParameter("employeeId", employeeId)
                .getSingleResult();
    }
}