package com.perezcasal.initspring.services.books;

import com.perezcasal.initspring.entities.BookEntity;
import com.perezcasal.initspring.external.BookBuilder;
import com.perezcasal.initspring.services.BooksServiceImplement;

import java.time.LocalDate;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class UpdateBooksServiceImplementTest {
    private final BooksServiceImplement booksServiceImplement;
    private BookEntity book;
    private BookEntity bookWithoutId;
    private BookEntity bookWithId;
    private HashMap<String, BookEntity> responseEntity;

    public UpdateBooksServiceImplementTest(BooksServiceImplement booksServiceImplement) {
        this.booksServiceImplement = booksServiceImplement;
        initBooks();
    }
    private void initBooks() {
        book = new BookBuilder()
                .setTitle("Destiny")
                .setAuthor("Daylen")
                .setPages(300)
                .setPrice(5.5)
                .setReleaseDate(LocalDate.of(2023, 1, 5))
                .setOnline(true)
                .build();
        bookWithoutId = new BookBuilder()
                .setTitle("Life")
                .setAuthor("Elio")
                .setPages(500)
                .setPrice(5.5)
                .setReleaseDate(LocalDate.of(2023, 1, 5))
                .setOnline(true)
                .build();
        bookWithId = new BookBuilder()
                .setId(6L)
                .setTitle("Destiny")
                .setAuthor("Daylen")
                .setPages(300)
                .setPrice(5.5)
                .setReleaseDate(LocalDate.of(2023, 1, 5))
                .setOnline(true)
                .build();
        booksServiceImplement.save(book);
    }
    public void updateTest1() {
        System.out.println();
        System.out.println("Staring the Test 1: Normal Update.");

        responseEntity = booksServiceImplement.update(bookWithoutId, 4L);
        BookEntity updated = responseEntity.get("updated");

        assertTrue(responseEntity.containsKey("updated"));
        assertEquals(4, updated.getId());
        assertEquals("Life", updated.getTitle());
        assertEquals("Elio", updated.getAuthor());
        assertEquals(500, updated.getPages());
        assertEquals(5.5, updated.getPrice());
        assertEquals(LocalDate.of(2023, 1, 5), updated.getReleaseDate());
        assertEquals(true, updated.getOnline());

        System.out.println(updated);
        System.out.println();
    }

    public void updateTest2() {
        System.out.println("Staring the Test 2: No found.");
        responseEntity = booksServiceImplement.update(book, 6L);

        assertTrue(responseEntity.containsKey("not-found"));
        assertNull(responseEntity.get("not-found"));

        System.out.println(responseEntity.get("not-found"));
        System.out.println();
    }

    public void updateTest3() {
        System.out.println("Staring the Test 3: Different Id.");
        responseEntity = booksServiceImplement.update(bookWithId, 4L);

        assertTrue(responseEntity.containsKey("diff-id"));
        assertNull(responseEntity.get("diff-id"));

        System.out.println(responseEntity.get("diff-id"));
        System.out.println();
    }
}
