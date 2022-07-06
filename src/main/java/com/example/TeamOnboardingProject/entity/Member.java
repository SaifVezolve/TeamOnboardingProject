package com.example.TeamOnboardingProject.entity;

import com.example.TeamOnboardingProject.entity.audit.Auditable;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table (name = "employee")
public class Member extends Auditable implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EmpID")
    private Long id;

    @NotNull
    @NotEmpty
    @NotBlank(message="first name cannot be empty")
    @Column(name = "First_Name")
    private String firstName;

    @NotNull
    @NotEmpty
    @NotBlank(message="last name cannot be empty")
    @Column(name = "Last_Name")
    private String lastName;

    @NotNull
    @NotEmpty
    @NotBlank(message="email cannot be blank")
    @Email(message = "User Email should be valid")
    @Column(name = "Email_Address")
    private String emailID;

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;
}
