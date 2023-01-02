package com.perezcasal.initspring.external;

import com.perezcasal.initspring.entities.BookEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class BookBuilder {
    private final BookEntity book;

    public BookBuilder() {
        this.book = new BookEntity();
    }

    public BookBuilder setId(Long id) {
        book.setId(id);
        return this;
    }

    public BookBuilder setTitle(String title) {
        this.book.setTitle(title);
        return this;
    }

    public BookBuilder setAuthor(String author) {
        this.book.setAuthor(author);
        return this;
    }

    public BookBuilder setPages(Integer pages) {
        this.book.setPages(pages);
        return this;
    }

    public BookBuilder setPrice(Double price) {
        this.book.setPrice(price);
        return this;
    }

    public BookBuilder setReleaseDate(LocalDate releaseDate) {
        this.book.setReleaseDate(releaseDate);
        return this;
    }

    public BookBuilder setOnline(Boolean online) {
        this.book.setOnline(online);
        return this;
    }

    public BookEntity build() {
        return book;
    }
}
