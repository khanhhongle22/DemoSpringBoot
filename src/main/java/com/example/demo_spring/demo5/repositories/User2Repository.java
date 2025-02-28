package com.example.demo_spring.demo5.repositories;

import com.example.demo_spring.demo5.entities.User2;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface User2Repository extends CrudRepository<User2, Integer> {
    Optional<User2> findByEmail(String email);
}
