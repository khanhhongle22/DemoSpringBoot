package com.example.demo_spring.demo9.repository;

import com.example.demo_spring.demo9.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
}
