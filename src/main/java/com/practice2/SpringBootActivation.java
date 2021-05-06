package com.practice2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

@SpringBootApplication
@ComponentScan(basePackages={
		"com.browserText.controller",
		"com.browserText.DAO",
		"com.browserText.model",
		"com.browserText.service",
		"com.browserText"})
public class SpringBootActivation {
	public static void main(String... args) {
		SpringApplication.run(SpringBootActivation.class, args);
	}
	
//	public void addVeiewControllers(ViewControllerRegistry registry) {
//		registry.addViewController("/").setViewName("Frontend");
//		}
}
