package com.example.TeamOnboardingProject.service;

import com.example.TeamOnboardingProject.entity.Member;
import com.example.TeamOnboardingProject.entity.Project;

import java.util.List;

public interface ProjectService {

    List<Project> getAllProject();

    Project getProjectById(Long id);

    Project addProject(Project project);

    Project updateProject(Project project);

    void deleteProject(Long id);
}
