package com.example.TeamOnboardingProject.serviceImpl;

import com.example.TeamOnboardingProject.entity.Member;
import com.example.TeamOnboardingProject.repository.MemberRepository;
import com.example.TeamOnboardingProject.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public List<Member> getAllMembers(){
        List<Member> newMemberList = new ArrayList<>();
        memberRepository.findAll().forEach(newMemberList::add);
        return newMemberList;
    }

    public List<Member> getMemberByProject(Long id){
        List<Member> memberList = new ArrayList<>();
        memberRepository.findByProjectId(id).forEach(memberList::add);
        return memberList;
    }

    public Member getMemberById(Long id){
        return memberRepository.findById(id).orElse(null);
    }

    public Member addNewMember(Member member){
        return memberRepository.save(member);
    }

    public Member updateNewMember(Member member){
        return memberRepository.save(member);
    }
    public void deleteMember(Long id){
        memberRepository.deleteById(id);
    }
}
