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
    public BookEntity save(BookEntity newBook) {
       return booksRepository.save(newBook);
    }

    @Override
    public void update(BookEntity newBook, Long id) {
        booksRepository.findById(id)
                .map(book -> {
                    updateFromNewBook(book, newBook);
                    return booksRepository.save(book);
                })
                .orElseGet(() -> {
                    newBook.setId(id);
                    return booksRepository.save(newBook);
                });
    }

    private void updateFromNewBook(BookEntity book, BookEntity newBook) {
        book.setTitle(newBook.getTitle());
        book.setAuthor(newBook.getAuthor());
        book.setPages(newBook.getPages());
        book.setPrice(newBook.getPrice());
        book.setReleaseDate(newBook.getReleaseDate());
        book.setOnline(newBook.getOnline());
    }

    @Override
    public void delete(Long id) {
        booksRepository.deleteById(id);
    }

    @Override
    public BookEntity findOneById(Long id) {
        return booksRepository.findById(id).orElse(null);
    }

    @Override
    public List<BookEntity> findAll() {
        return booksRepository.findAll();
    }
}
