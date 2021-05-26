package com.practice2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootActivation {
  public static void main(String... args) {
    SpringApplication.run(SpringBootActivation.class, args);
  }

  // public void addVeiewControllers(ViewControllerRegistry registry) {
  // registry.addViewController("/").setViewName("Frontend");
  // }
}
