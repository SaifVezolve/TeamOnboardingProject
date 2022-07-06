package com.example.TeamOnboardingProject.controller;

import com.example.TeamOnboardingProject.entity.Member;
import com.example.TeamOnboardingProject.entity.Project;
import com.example.TeamOnboardingProject.exception.customizedException.MemberNotFoundException;
import com.example.TeamOnboardingProject.service.MemberService;
import com.example.TeamOnboardingProject.service.ProjectService;
import com.example.TeamOnboardingProject.serviceImpl.MemberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {

    @Autowired
    private MemberService memberServices;

    @Autowired
    private ProjectService projectService;

    @GetMapping("")
    public List<Member> getAllMembers(){
        return memberServices.getAllMembers();
    }

    @GetMapping("{id}")
    public Member getMemberById(@PathVariable Long id){

        Member member =  memberServices.getMemberById(id);
        if(member == null){
            throw new MemberNotFoundException();
        }
        return member;
    }

    @GetMapping("project")
    public List<Member> getMemberByProject(@RequestHeader("Project-ID") Long projectId){
        return memberServices.getMemberByProject(projectId);
    }

    @PostMapping("")
    public Member addNewMember(@Valid @RequestBody Member member,@RequestHeader("Project-ID") Long projectId){
        Project project = projectService.getProjectById(projectId);
        member.setProject(project);
        return memberServices.addNewMember(member);
    }

    @PutMapping("")
    public Member updateNewMember( @Valid @RequestBody Member member, @RequestHeader("Project-ID") Long projectId){
        Project project = projectService.getProjectById(projectId);
        member.setProject(project);
        return memberServices.updateNewMember(member);
    }

    @DeleteMapping("{id}")
    public void deleteMember(@PathVariable(value = "id") Long id){
        memberServices.deleteMember(id);
    }
}
