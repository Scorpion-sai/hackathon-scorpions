package com.scorpions.dao;

import com.scorpions.entities.ProjectDetails;
import java.util.List;

public interface ProjectDao {

    ProjectDetails saveProject(ProjectDetails project);

    ProjectDetails updateProject(ProjectDetails project);

    void deleteProject(Long id);

    ProjectDetails getProjectById(Long id);

    List<ProjectDetails> getAllProjects();
}
