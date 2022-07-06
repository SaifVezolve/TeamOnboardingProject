package com.example.TeamOnboardingProject.serviceImpl;

import com.example.TeamOnboardingProject.entity.Task;
import com.example.TeamOnboardingProject.repository.TaskRepository;
import com.example.TeamOnboardingProject.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTask(Long projectId){
        List<Task> taskList = new ArrayList<>();
        taskRepository.findByProjectId(projectId).forEach(taskList::add);
        return taskList;
    }

    public Task getTask(Long id){
        return taskRepository.findById(id).orElse(null);
    }

    public Task addTask(Task task){

        return taskRepository.save(task);
    }

    public Task updateTask(Task task){

        return taskRepository.save(task);
    }

    public void deleteTask(Long id){
        taskRepository.deleteById(id);
    }
}
