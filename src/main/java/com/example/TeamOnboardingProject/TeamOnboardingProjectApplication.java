package com.example.TeamOnboardingProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.TeamOnboardingProject")
@EnableJpaAuditing
public class TeamOnboardingProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(TeamOnboardingProjectApplication.class, args);
	}

}
