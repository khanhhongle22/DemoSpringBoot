package com.example.demo_spring.demo5.services;

import com.example.demo_spring.demo5.dtos.LoginUserDto;
import com.example.demo_spring.demo5.dtos.RegisterUserDto;
import com.example.demo_spring.demo5.entities.User2;
import com.example.demo_spring.demo5.entities.User2Role;
import com.example.demo_spring.demo5.repositories.User2Repository;
import io.jsonwebtoken.JwtException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private final User2Repository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    public AuthenticationService(
            User2Repository userRepository,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder
    ) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public ResponseEntity<String> signup(RegisterUserDto input) {
        if (userRepository.findByEmail(input.getEmail()).isPresent()) {
            return new ResponseEntity<>("Email already exists!", HttpStatus.NOT_FOUND);
        }
        User2 user = new User2();
        user.setFullName(input.getFullName());
        user.setEmail(input.getEmail());
                user.setPassword(passwordEncoder.encode(input.getPassword()));
        user.setRole(input.getRole()); // Set the role (e.g., "admin" or "user")
        userRepository.save(user);

        return new ResponseEntity<>("Register success.", HttpStatus.OK);
    }

    public User2 login(LoginUserDto input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getPassword()
                )
        );

        return userRepository.findByEmail(input.getEmail())
                .orElseThrow();
    }
}
