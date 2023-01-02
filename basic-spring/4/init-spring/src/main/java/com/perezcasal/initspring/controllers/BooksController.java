package com.perezcasal.initspring.controllers;

import com.perezcasal.initspring.entities.BookEntity;
import com.perezcasal.initspring.services.BooksService;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BooksController {
    BooksService booksService;

    public BooksController(BooksService booksService) {
        this.booksService = booksService;
    }

    public void save(BookEntity car) {
        booksService.save(car);
    }

    public List<BookEntity> findAll() {
        return booksService.findAll();
    }
}
