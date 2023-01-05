package com.perezcasal.initspring.services.books;

import com.perezcasal.initspring.entities.BookEntity;
import com.perezcasal.initspring.external.BookBuilder;
import com.perezcasal.initspring.repositories.BooksRepository;
import com.perezcasal.initspring.services.BooksServiceImplement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class BooksServiceImplementTest {
    @Autowired
    private BooksRepository booksRepository;
    private BooksServiceImplement booksServiceImplement;
    private BookEntity book;

    @BeforeEach
    void setUp() {
        booksServiceImplement = new BooksServiceImplement(booksRepository);
        book = new BookBuilder()
                .setTitle("Life")
                .setAuthor("Elio")
                .setPages(500)
                .setPrice(2.5)
                .setReleaseDate(LocalDate.of(2023, 1, 4))
                .setOnline(true)
                .build();
    }

    @Test
    void saveTest() {
        SaveBooksServiceImplementTest saveTest = new SaveBooksServiceImplementTest(booksServiceImplement);
        saveTest.saveTest1();
        saveTest.saveTest2();
        saveTest.saveTest3();
        saveTest.saveTest4();
    }

    @Test
    void updateTest() {
        UpdateBooksServiceImplementTest updateTest = new UpdateBooksServiceImplementTest(booksServiceImplement);
        updateTest.updateTest1();
        updateTest.updateTest2();
        updateTest.updateTest3();
    }

    @Test
    void deleteTest() {
        System.out.println();
        System.out.println("Staring the Test 1: Delete book.");
        booksServiceImplement.save(book);

        booksServiceImplement.delete(5L);

        assertTrue(true, String.valueOf(booksServiceImplement.findOneById(1L).containsKey("not-found")));
        System.out.println();
    }

    @Test
    void deleteAllTest() {
        System.out.println();
        System.out.println("Staring the Test 1: Delete all books.");

        booksServiceImplement.deleteAll();

        assertEquals(0, booksServiceImplement.findAll().size());
        System.out.println();
    }

    @Test
    void findOneByIdTest() {
        System.out.println();
        System.out.println("Staring the Test 1: Book found.");
        booksServiceImplement.save(book);

        BookEntity found = booksServiceImplement.findOneById(3L).get("found");

        assertEquals(3, found.getId());
        assertEquals("Life", found.getTitle());
        assertEquals("Elio", found.getAuthor());
        assertEquals(500, found.getPages());
        assertEquals(2.5, found.getPrice());
        assertEquals(LocalDate.of(2023, 1, 4), found.getReleaseDate());
        assertEquals(true, found.getOnline());

        System.out.println(found);
        System.out.println();

        System.out.println("Staring the Test 2: Book not found.");
        found = booksServiceImplement.findOneById(1L).get("not-found");

        assertNull(found);
    }

    @Test
    void findAllTest() {
        System.out.println();
        System.out.println("Staring the Test 1: Get all the books");

        var booksList = booksServiceImplement.findAll();

        assertEquals(0, booksList.size());

        booksList.forEach(System.out::println);
        System.out.println();
    }
}