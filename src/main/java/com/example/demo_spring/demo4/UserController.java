package com.example.demo_spring.demo4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// @Controller // For html
@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @DeleteMapping("/users")
    public String deleteAllUsers() {
        userRepository.deleteAll();
        return "Removed all users success!";
    }

    @DeleteMapping("/users/{userId}")
    public String deleteUser(@PathVariable("userId") Long id) {
        Optional<User> currentUser = userService.getUserById(id);
        if (currentUser.isPresent()) {
            userRepository.deleteById(id);
            return "Delete userId: " + id + " success!";
        } else {
            return "Not found user!";
        }
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User newUser = new User();
        newUser.setName(user.getName());
        userService.saveUser(newUser);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @PutMapping("/users/{userId}")  // Use PUT for updates
    public ResponseEntity<User> updateUser(@PathVariable("userId") Long id,
                                           @RequestBody User createUserDto) {
        Optional<User> currentUser = userService.getUserById(id);

        if (currentUser.isPresent()) {
            User user = currentUser.get();
            user.setName(createUserDto.getName());
            userService.saveUser(user);
            return new ResponseEntity<>(user, HttpStatus.OK); // 200 OK
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404 Not Found
        }
    }

    @GetMapping("/users")
    public void getAllUsers() {
        List<User> users = userService.getAllUsers();
        if (!users.isEmpty()) {
            users.forEach(user -> {
                System.out.println("User: " + user);
                System.out.println("name: " + user.getName());
            });
        }
    }

    @GetMapping("/users/{userId}")
    public void getUserById(@PathVariable("userId") Long id) {
        Optional<User> user = userService.getUserById(id);
        if (user.isPresent()) {
            System.out.println("User id: " + user.get().getId());
            System.out.println("User name: " + user.get().getName());
        }
    }

    // Test mysql db connection
    @GetMapping("/test")
    public String testConnection() {
        try {
            userRepository.findAll();
            return "Success connect!";
        } catch (Exception e) {
            return "Connection failed: " + e.getMessage();
        }
    }

    // Return users for html page
    @GetMapping("/users/index")
    public String userIndex(Model model) {
        List<User> users = userService.getAllUsers();
        if (!users.isEmpty()) {
            users.forEach(user -> {
                /*model.addAttribute("user", user);
                model.addAttribute("name", user.getName());*/
            });
            model.addAttribute("users", users);
        }
        return "users";
    }
}
