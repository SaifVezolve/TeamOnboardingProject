package com.example.TeamOnboardingProject.controller;

import com.example.TeamOnboardingProject.entity.Project;
import com.example.TeamOnboardingProject.exception.customizedException.ProjectNotFoundException;
import com.example.TeamOnboardingProject.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("")
    public List<Project> getAllProjects() {
        return projectService.getAllProject();
    }

    @GetMapping("{id}")
    public Project getProjectById(@PathVariable Long id) {
        Project project = projectService.getProjectById(id);
        if (project == null) {
            throw new ProjectNotFoundException();
        }
        return project;
    }

    @PostMapping("")
    public Project addProject(@Valid @RequestBody Project project) {
        return projectService.addProject(project);
    }

    @PutMapping("")
    public Project updateProject(@Valid @RequestBody Project project) {
        return projectService.updateProject(project);
    }

    @DeleteMapping("{id}")
    public void deleteProject(@PathVariable(value = "id") Long id) {
        projectService.deleteProject(id);
    }
}
