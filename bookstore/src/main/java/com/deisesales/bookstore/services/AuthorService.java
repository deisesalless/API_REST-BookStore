package com.deisesales.bookstore.services;

import com.deisesales.bookstore.entities.AuthorEntity;
import com.deisesales.bookstore.exceptions.EntityNotFound;
import com.deisesales.bookstore.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository repository;

    public AuthorEntity register(AuthorEntity author) {
        return repository.save(author);
    }

    public List<AuthorEntity> listAll() {
        return repository.findAll();
    }

    public AuthorEntity update(AuthorEntity author) {
        Optional<AuthorEntity> newAuthor = repository.findById(author.getId());

        if (newAuthor.isEmpty()) {
            throw new EntityNotFound("Autor do ID: " + author.getId() + " não encontrado.");
        } else {
            updateAuthor(newAuthor, author);
            return repository.save(newAuthor.get());
        }
    }

    public void updateAuthor(Optional<AuthorEntity> newAuthor, AuthorEntity author) {
        newAuthor.get().setId(author.getId());
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public AuthorEntity findByID(Long id) {
        Optional<AuthorEntity> author = repository.findById(id);

        if (author.isEmpty()) {
            throw new EntityNotFound("Autor do ID: " + id + " não encontrado.");
        } else {
            return author.get();
        }

    }
}
