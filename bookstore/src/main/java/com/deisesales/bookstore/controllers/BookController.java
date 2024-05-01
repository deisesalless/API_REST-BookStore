package com.deisesales.bookstore.controllers;

import com.deisesales.bookstore.entities.BookEntity;
import com.deisesales.bookstore.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService service;

    @PostMapping
    public ResponseEntity<BookEntity> register(@RequestBody BookEntity book) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.register(book));
    }

    @GetMapping
    public ResponseEntity<List<BookEntity>> listAll() {
        return ResponseEntity.ok().body(service.listAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookEntity> update(@PathVariable Long id, @RequestBody BookEntity book) {
        book.setId(id);
        return ResponseEntity.ok().body(service.update(book));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookEntity> findByID(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findByID(id));
    }
}
