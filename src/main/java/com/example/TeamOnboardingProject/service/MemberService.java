package com.example.TeamOnboardingProject.service;

import com.example.TeamOnboardingProject.entity.Member;

import java.util.List;

public interface MemberService {
    List<Member> getAllMembers();

    Member getMemberById(Long id);

    List<Member> getMemberByProject(Long id);

    Member addNewMember(Member member);

    Member updateNewMember(Member member);

    void deleteMember(Long id);
}
