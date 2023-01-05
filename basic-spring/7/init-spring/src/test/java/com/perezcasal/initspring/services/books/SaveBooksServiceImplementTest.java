package com.perezcasal.initspring.services.books;

import com.perezcasal.initspring.entities.BookEntity;
import com.perezcasal.initspring.external.BookBuilder;
import com.perezcasal.initspring.services.BooksServiceImplement;

import java.time.LocalDate;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class SaveBooksServiceImplementTest {
    private final BooksServiceImplement booksServiceImplement;
    private BookEntity book;
    private BookEntity bookWithoutId;
    private BookEntity bookWithinId;
    private BookEntity bookWithoutAttributes;

    private HashMap<String, BookEntity> responseEntity;

    public SaveBooksServiceImplementTest(BooksServiceImplement booksServiceImplement) {
        this.booksServiceImplement = booksServiceImplement;
        initBooks();
    }
    private void initBooks() {
        book = new BookBuilder()
                .setTitle("Life")
                .setAuthor("Elio")
                .setPages(500)
                .setPrice(2.5)
                .setReleaseDate(LocalDate.of(2023, 1, 4))
                .setOnline(true)
                .build();
        bookWithoutId = new BookBuilder()
                .setTitle("Life")
                .setAuthor("Elio")
                .setPages(500)
                .setPrice(2.5)
                .setReleaseDate(LocalDate.of(2023, 1, 4))
                .setOnline(true)
                .build();
        bookWithinId = new BookBuilder()
                .setId(1L)
                .setTitle("Life")
                .setAuthor("Elio")
                .setPages(500)
                .setPrice(2.5)
                .setReleaseDate(LocalDate.of(2023, 1, 4))
                .setOnline(true)
                .build();
        bookWithoutAttributes = new BookBuilder()
                .setTitle("Life")
                .setAuthor("Elio")
                .setPages(500)
                .build();
    }
    public void saveTest1() {
        System.out.println();
        System.out.println("Staring the Test 1: Normal Save");

        responseEntity = booksServiceImplement.save(book);
        BookEntity saved = responseEntity.get("saved");

        assertTrue(responseEntity.containsKey("saved"));
        assertEquals(1, saved.getId());
        assertEquals("Life", saved.getTitle());
        assertEquals("Elio", saved.getAuthor());
        assertEquals(500, saved.getPages());
        assertEquals(2.5, saved.getPrice());
        assertEquals(LocalDate.of(2023, 1, 4), saved.getReleaseDate());
        assertEquals(true, saved.getOnline());

        System.out.println(saved);
        System.out.println();
    }

    public void saveTest2() {
        System.out.println("Staring the Test 2: Without Attributes Save");
        responseEntity = booksServiceImplement.save(bookWithoutAttributes);
        BookEntity saved = responseEntity.get("saved");

        assertTrue(responseEntity.containsKey("saved"));
        assertTrue(responseEntity.containsKey("saved"));
        assertEquals(2, saved.getId());
        assertEquals("Life", saved.getTitle());
        assertEquals("Elio", saved.getAuthor());
        assertEquals(500, saved.getPages());

        System.out.println(responseEntity.get("saved"));
        System.out.println();
    }

    public void saveTest3() {
        System.out.println("Staring the Test 3: With Id Save");
        responseEntity = booksServiceImplement.save(bookWithinId);

        assertTrue(responseEntity.containsKey("id-not-null"));
        assertNull(responseEntity.get("id-not-null"));

        System.out.println(responseEntity.get("id-not-null"));
        System.out.println();
    }

    public void saveTest4() {
        System.out.println("Staring the Test 4: Same Element Save");
        responseEntity = booksServiceImplement.save(bookWithoutId);

        assertTrue(responseEntity.containsKey("exist"));
        assertNull(responseEntity.get("exist"));

        System.out.println(responseEntity.get("exist"));
        System.out.println();
    }
}
