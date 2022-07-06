package com.example.TeamOnboardingProject.repository;

import com.example.TeamOnboardingProject.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project,Long> {
}
