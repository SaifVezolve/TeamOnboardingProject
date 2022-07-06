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
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"name"})})
public class Project extends Auditable implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotEmpty
    @NotBlank(message="name cannot be blank")
    private String name;

    @Lob
    @Column(name = "Description", length = 1000)
    private String description;
}
