package com.example.TeamOnboardingProject.repository;

import com.example.TeamOnboardingProject.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member,Long> {

    public List<Member> findByProjectId(Long projectId);
}
