package com.scorpions.service;

import com.scorpions.entities.ProjectDetails;
import jakarta.transaction.Transactional;
import java.util.List;

public interface ProjectService {
    @Transactional
    ProjectDetails saveProject(ProjectDetails project);

    ProjectDetails updateProject(ProjectDetails project);

    void deleteProject(Long id);

    ProjectDetails getProjectById(Long id);

    List<ProjectDetails> getAllProjects();
}
