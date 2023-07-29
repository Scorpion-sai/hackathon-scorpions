package com.scorpions.dao.impl;

import com.scorpions.dao.ProjectDao;
import com.scorpions.entities.ProjectDetails;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ProjectDaoImpl implements ProjectDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public ProjectDetails saveProject(ProjectDetails project) {
        entityManager.persist(project);
        return project;
    }

    @Override
    public ProjectDetails updateProject(ProjectDetails project) {
        return entityManager.merge(project);
    }

    @Override
    public void deleteProject(Long id) {
        ProjectDetails project = getProjectById(id);
        if (project != null) {
            entityManager.remove(project);
        }
    }

    @Override
    public ProjectDetails getProjectById(Long id) {
        return entityManager.find(ProjectDetails.class, id);
    }

    @Override
    public List<ProjectDetails> getAllProjects() {
        return entityManager.createQuery("SELECT p FROM Project p", ProjectDetails.class).getResultList();
    }
}
