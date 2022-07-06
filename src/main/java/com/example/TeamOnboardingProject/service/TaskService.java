package com.example.TeamOnboardingProject.service;

import com.example.TeamOnboardingProject.entity.Task;

import java.util.List;

public interface TaskService {

    List<Task> getAllTask(Long projectId);

    Task getTask(Long id);

    Task addTask(Task task);

    Task updateTask(Task task);

    void deleteTask(Long id);
}
