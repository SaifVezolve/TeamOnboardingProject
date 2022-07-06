package com.example.TeamOnboardingProject.repository;

import com.example.TeamOnboardingProject.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task,Long> {
    public List<Task> findByProjectId(Long projectId);
}
