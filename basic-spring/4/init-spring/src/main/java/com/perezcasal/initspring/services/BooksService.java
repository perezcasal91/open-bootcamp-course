package com.perezcasal.initspring.services;

import com.perezcasal.initspring.entities.BookEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BooksService {
    void save(BookEntity car);
    List<BookEntity> findAll();
}
