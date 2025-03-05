package com.example.demo_spring.demo9.configuration;

import com.example.demo_spring.demo9.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class EmployeeConfig {
    @Bean
    public ModelMapper modelMapperBean() {
        return new ModelMapper();
    }

}
