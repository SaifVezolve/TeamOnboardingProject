package com.example.TeamOnboardingProject.controller;

import com.example.TeamOnboardingProject.entity.Project;
import com.example.TeamOnboardingProject.entity.Task;
import com.example.TeamOnboardingProject.exception.customizedException.TaskNotFoundException;
import com.example.TeamOnboardingProject.service.ProjectService;
import com.example.TeamOnboardingProject.service.TaskService;
import com.example.TeamOnboardingProject.serviceImpl.TaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/tasks1")
public class TaskController {
    @Autowired
    private TaskService taskService;
    @Autowired
    private ProjectService projectService;

    @GetMapping("")
    public List<Task> getAllTasks(@RequestHeader("Project-ID") Long projectId){
        return taskService.getAllTask(projectId);
    }
    @GetMapping("{id}")
    public Task getTask(@RequestHeader("Project-ID") Long projectId, @PathVariable Long id){
        Task task =  taskService.getTask(id);
        if(task == null){
            throw new TaskNotFoundException();
        }
        return task;
    }
    @PostMapping("")
    public Task addTask(@Valid @RequestBody Task task, @RequestHeader("Project-ID") Long projectId){
        Project project = projectService.getProjectById(projectId);
        if (project == null) {

        }
        task.setProject(project);
        return taskService.addTask(task);
    }

    @PutMapping("")
    public Task updateTask(@RequestHeader("Project-ID") Long projectId, @Valid @RequestBody Task task){Project project = projectService.getProjectById(projectId);
        if (project == null) {
        }
        task.setProject(project);
        return taskService.updateTask(task);
    }

    @DeleteMapping("{id}")
    public void deleteTask(@PathVariable(value = "id") Long id){
        taskService.deleteTask(id);
    }
}
