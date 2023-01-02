package com.perezcasal.initspring.services;

import com.perezcasal.initspring.entities.BookEntity;
import com.perezcasal.initspring.repositories.BooksRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksServiceImplement implements BooksService {
    BooksRepository booksRepository;

    public BooksServiceImplement(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    @Override
    public void save(BookEntity car) {
        booksRepository.save(car);
    }

    @Override
    public List<BookEntity> findAll() {
        return booksRepository.findAll();
    }
}
