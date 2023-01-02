package com.perezcasal.initspring.controllers;

import com.perezcasal.initspring.entities.BookEntity;
import com.perezcasal.initspring.services.BooksService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BooksController {
    BooksService booksService;

    public BooksController(BooksService booksService) {
        this.booksService = booksService;
    }

    @PostMapping(
            value = "/api/books/add",
            consumes = "application/json")
    public ResponseEntity<BookEntity> saveBook(@RequestBody BookEntity newBook) {
        BookEntity book = booksService.save(newBook);
        return book == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(book);
    }

    @PutMapping(
            value = "/api/books/{id}",
            consumes = "application/json")
    public void updateBook(@RequestBody BookEntity newBook, @PathVariable Long id) {
        booksService.update(newBook, id);
    }

    @DeleteMapping(value = "/api/books/{id}")
    public void deleteBook(@PathVariable Long id) {
        booksService.delete(id);
    }

    @GetMapping(
            value = "/api/books/{id}",
            produces = "application/json")
    public ResponseEntity<BookEntity> findBookById(@PathVariable Long id) {
        BookEntity book = booksService.findOneById(id);
        return book == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(book);
    }

    @GetMapping(
            value = "/api/books",
            produces = "application/json")
    public List<BookEntity> findAllBooks() {
        return booksService.findAll();
    }
}
