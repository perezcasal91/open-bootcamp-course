package com.perezcasal.initspring.services;

import com.perezcasal.initspring.entities.BookEntity;
import com.perezcasal.initspring.repositories.BooksRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class BooksServiceImplement implements BooksService {
    @Autowired
    private final BooksRepository booksRepository;
    private final Logger logger;
    private HashMap<String, BookEntity> response;

    public BooksServiceImplement(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
        this.logger = LoggerFactory.getLogger(this.getClass());
    }

    /**
     * Save a New Book into the H2 Database using JPA.
     * @param newBook Book Entity
     * @return HashMap - The response.
     */
    @Override
    public HashMap<String, BookEntity> save(BookEntity newBook) {
        initResponse();
        logger.info("Call to the function save.");
        if (newBook.getId() != null) {
            logger.warn("Bad request: Trying to add a book with id, use instead the method Update.");
            response.put("id-not-null", null);
            return response;
        }
        if (isAnyMatch(newBook)) {
            logger.warn("Element exist: Trying to add a book that already exist.");
            response.put("exist", null);
            return response;
        }
        response.put("saved", booksRepository.save(newBook));
       return response;
    }

    /**
     * Verify if the new book already exist into the Database.
     * @param newBook Book Entity
     * @return Boolean
     */
    private boolean isAnyMatch(BookEntity newBook) {
        return booksRepository.findAll().stream().anyMatch(book -> book.equals(newBook));
    }

    /**
     * Update an existing Book into the Database using JPA
     * @param newBook Book Entity
     * @param id Primary key
     * @return HashMap - The response.
     */
    @Override
    public HashMap<String, BookEntity> update(BookEntity newBook, Long id) {
        initResponse();
        logger.info("Call to the function update.");
        if (id == null) {
            logger.warn("Bad request: The id can not be null.");
            response.put("id-null", null);
            return response;
        }
        var optionalBook = booksRepository.findById(id);
        if (optionalBook.isPresent()) {
            BookEntity book = optionalBook.get();
            if (newBook.getId() == null) {
                response.put("updated", booksRepository.save(updateFromNewBook(book, newBook)));
            } else {
                if (newBook.getId().equals(id)) {
                    response.put("updated", booksRepository.save(updateFromNewBook(book, newBook)));
                } else {
                    logger.warn("Bad request: Trying to update a book with different id," +
                            " bookId=" + book.getId() + " newBookId=" + newBook.getId());
                    response.put("diff-id", null);
                }
            }
        } else {
            logger.warn("Not found: Could not found the book you trying to update, use instead the method Save.");
            response.put("not-found", null);
        }
        return response;
    }

    private BookEntity updateFromNewBook(BookEntity book, BookEntity newBook) {
        book.setTitle(newBook.getTitle());
        book.setAuthor(newBook.getAuthor());
        book.setPages(newBook.getPages());
        book.setPrice(newBook.getPrice());
        book.setReleaseDate(newBook.getReleaseDate());
        book.setOnline(newBook.getOnline());
        return book;
    }

    /**
     * Delete a book from the Database using JPA.
     * @param id Primary key
     */
    @Override
    public void delete(Long id) {
        logger.info("Call to the function delete.");
        booksRepository.deleteById(id);
    }

    /**
     * Delete all books from the Database using JPA.
     */
    @Override
    public void deleteAll() {
        logger.info("Call to the function deleteAll.");
        booksRepository.deleteAll();
    }

    /**
     * Find one book into the Database using JPA.
     * @param id Primary key
     * @return HashMap - The response.
     */
    @Override
    public HashMap<String, BookEntity>  findOneById(Long id) {
        initResponse();
        logger.info("Call to the function findOneById.");
        if (id == null) {
            logger.warn("Bad request: The id can not be null.");
            response.put("id-null", null);
            return response;
        }
        response.put("found", booksRepository.findById(id).orElseGet(()-> {
            logger.warn("Not found: Could not found the book.");
            return response.put("not-found", null);
        }));
        return response;
    }
    private void initResponse() {
        this.response = new HashMap<>();
    }

    /**
     * Find all the books are into the Database using JPA.
     * @return List of Book Entity
     */
    @Override
    public List<BookEntity> findAll() {
        logger.info("Call to the function findAll.");
        return booksRepository.findAll();
    }
}
