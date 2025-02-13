package com.example.demo_spring.demo2;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class Girl2 {
    @PostConstruct
    public void postConstruct() {
        System.out.println("\tGirl postConstruct");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("\tGirl preDestroy");
    }
}
