package com.example.TeamOnboardingProject.serviceImpl;

import com.example.TeamOnboardingProject.entity.Project;
import com.example.TeamOnboardingProject.repository.ProjectRepository;
import com.example.TeamOnboardingProject.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public List<Project> getAllProject(){
        List<Project> projectList = new ArrayList<>();
        projectRepository.findAll().forEach(projectList::add);
        return projectList;
    }

    public Project getProjectById(Long id){
        Project project =  projectRepository.findById(id).orElse(null);
        System.out.println("project = " + project);
        return project;
    }

    public Project addProject(Project project){
        return projectRepository.save(project);
    }

    public Project updateProject(Project project){
        return projectRepository.save(project);
    }

    public void deleteProject(Long id){
        projectRepository.deleteById(id);
        
    }
}
