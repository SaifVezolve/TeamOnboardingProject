package com.example.TeamOnboardingProject.entity;


import com.example.TeamOnboardingProject.entity.audit.Auditable;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "Task")
public class Task extends Auditable implements Serializable {

    @Column(name = "TaskID")@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotEmpty
    @NotBlank(message="name cannot be blank")
    @Column(name = "Task_Name")
    private String taskName;

    @NotNull
    @NotEmpty
    @NotBlank(message="type cannot be blank")
    @Column(name = "Task_Description")
    private String taskDescription;

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    //public Task(Long projectId) {
    //    this.project = new Project(projectId,"","");
    //}


   // public Project getProject() {
    //    return project;
    //}

    //public void setProject(Project project) {
    //    this.project = project;
    //}

}
