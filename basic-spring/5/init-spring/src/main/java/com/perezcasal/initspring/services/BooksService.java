package com.perezcasal.initspring.services;

import com.perezcasal.initspring.entities.BookEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BooksService {
    BookEntity save(BookEntity newBook);
    void update(BookEntity newBook, Long id);
    void delete(Long id);
    BookEntity findOneById(Long id);
    List<BookEntity> findAll();
}
