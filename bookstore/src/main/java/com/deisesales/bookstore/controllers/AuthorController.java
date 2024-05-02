package com.deisesales.bookstore.controllers;

import com.deisesales.bookstore.entities.AuthorEntity;
import com.deisesales.bookstore.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorService service;

    @PostMapping
    public ResponseEntity<AuthorEntity> register(AuthorEntity author) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.register(author));
    }

    @GetMapping
    public ResponseEntity<List<AuthorEntity>> listAll() {
        return ResponseEntity.ok().body(service.listAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuthorEntity> update(@PathVariable Long id, @RequestBody AuthorEntity author) {
        return ResponseEntity.ok().body(service.update(author));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
        ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorEntity> findByID(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findByID(id));
    }
}
