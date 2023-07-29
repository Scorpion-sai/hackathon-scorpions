package com.scorpions.service.impl;

import com.scorpions.dao.ProjectDao;
import com.scorpions.entities.ProjectDetails;
import com.scorpions.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectDao projectDAO;

    @Autowired
    public ProjectServiceImpl(ProjectDao projectDAO) {
        this.projectDAO = projectDAO;
    }

    @Override
    public ProjectDetails saveProject(ProjectDetails project) {
        return projectDAO.saveProject(project);
    }

    @Override
    public ProjectDetails updateProject(ProjectDetails project) {
        return projectDAO.updateProject(project);
    }

    @Override
    public void deleteProject(Long id) {
        projectDAO.deleteProject(id);
    }

    @Override
    public ProjectDetails getProjectById(Long id) {
        return projectDAO.getProjectById(id);
    }

    @Override
    public List<ProjectDetails> getAllProjects() {
        return projectDAO.getAllProjects();
    }
}
