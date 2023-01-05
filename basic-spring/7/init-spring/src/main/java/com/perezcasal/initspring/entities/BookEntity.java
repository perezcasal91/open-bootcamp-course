package com.perezcasal.initspring.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "book")
@Tag(name = "Book Entity")
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(name = "id", description = "Id",
            type = "Long", example = "1")
    private Long id;
    @Schema(name = "title", description = "Title",
            type = "String", example = "The Lord od the Ring.")
    private String title;
    @Schema(name = "author", description = "Author",
            type = "String", example = "Elieser Perez")
    private String author;
    @Schema(name = "pages", description = "Pages",
            type = "Integer", example = "500")
    private Integer pages;
    @Schema(name = "price", description = "Price",
            type = "Double", example = "500.5")
    private Double price;
    @Schema(name = "releaseDate", description = "Release Date",
            type = "LocalDate", example = "2023-01-04")
    private LocalDate releaseDate;
    @Schema(name = "online", description = "Online",
            type = "Boolean", example = "true or false")
    private Boolean online;

    public BookEntity() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Boolean getOnline() {
        return online;
    }

    public void setOnline(Boolean online) {
        this.online = online;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof BookEntity book))
            return false;
        return  Objects.equals(this.title, book.title)
                && Objects.equals(this.author, book.author)
                && Objects.equals(this.pages, book.pages)
                && Objects.equals(this.price, book.price)
                && Objects.equals(this.releaseDate, book.releaseDate)
                && Objects.equals(this.online, book.online);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.title, this.author,
                this.pages, this.price, this.releaseDate, this.online);
    }

    @Override
    public String toString() {
        return String
                .format("Book[id=%d, title='%s', author='%s', pages='%d'" +
                                ", price='%s', releaseDate='%s', online='%s']",
                        id, title, author, pages, price, releaseDate, online);
    }
}
