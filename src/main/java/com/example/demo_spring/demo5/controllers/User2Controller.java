package com.example.demo_spring.demo5.controllers;

import com.example.demo_spring.demo5.entities.User2;
import com.example.demo_spring.demo5.services.User2Service;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/users2")
@RestController
public class User2Controller {
    private final User2Service userService;

    public User2Controller(User2Service userService) {
        this.userService = userService;
    }

    @GetMapping("/me")
    public ResponseEntity<User2> viewMe() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        User2 currentUser = (User2) authentication.getPrincipal();

        return ResponseEntity.ok(currentUser);
    }

    @GetMapping("/")
    public ResponseEntity<List<User2>> allUsers() {
        List <User2> users = userService.allUsers();

        return ResponseEntity.ok(users);
    }
}
