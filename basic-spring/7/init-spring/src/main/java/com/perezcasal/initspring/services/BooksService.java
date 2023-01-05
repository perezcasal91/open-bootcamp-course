package com.perezcasal.initspring.services;

import com.perezcasal.initspring.entities.BookEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public interface BooksService {
    HashMap<String, BookEntity> save(BookEntity newBook);
    HashMap<String, BookEntity> update(BookEntity newBook, Long id);
    void delete(Long id);
    void deleteAll();
    HashMap<String, BookEntity> findOneById(Long id);
    List<BookEntity> findAll();
}
