package com.example.demo_spring.demo5.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @GetMapping
    public ResponseEntity<List<String>> findAll() {
        return ResponseEntity.ok(List.of("Book1", "Book2", "Book3"));
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody String data) {
        return ResponseEntity.ok(data);
    }
}
