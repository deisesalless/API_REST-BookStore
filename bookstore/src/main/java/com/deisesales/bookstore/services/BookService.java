package com.deisesales.bookstore.services;

import com.deisesales.bookstore.entities.BookEntity;
import com.deisesales.bookstore.exceptions.EntityNotFound;
import com.deisesales.bookstore.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    public BookEntity register(BookEntity book) {
         return repository.save(book);
    }

    public List<BookEntity> listAll() {
        return repository.findAll();
    }

    public BookEntity update(BookEntity book) {
        Optional<BookEntity> newBook = repository.findById(book.getId());

        if (newBook.isEmpty()) {
            throw new EntityNotFound("Livro do ID: " + book.getId() + " não encontrado.");
        } else {
            updateBook(newBook,  book);
            return repository.save(newBook.get());
        }
    }

    public void updateBook(Optional<BookEntity> newBook, BookEntity book) {
        newBook.get().setName(book.getName());
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public BookEntity findByID(Long id) {
        Optional<BookEntity> book = repository.findById(id);

        if (book.isEmpty()) {
            throw new EntityNotFound("Livro do ID: " + id + " não encontrado.");
        } else {
            return book.get();
        }
    }
}
