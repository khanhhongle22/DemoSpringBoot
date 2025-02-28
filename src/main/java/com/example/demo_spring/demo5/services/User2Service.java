package com.example.demo_spring.demo5.services;

import com.example.demo_spring.demo5.entities.User2;
import com.example.demo_spring.demo5.repositories.User2Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class User2Service {
    private final User2Repository userRepository;

    public User2Service(User2Repository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User2> allUsers() {
        List<User2> users = new ArrayList<>();

        userRepository.findAll().forEach(users::add);

        return users;
    }

    public Optional<User2> getSingleUser(String email) {
        return userRepository.findByEmail(email);
    }
}
