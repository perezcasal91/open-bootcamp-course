package com.perezcasal.initspring.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "book")
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String author;
    private Integer pages;
    private Double price;
    private LocalDate releaseDate;
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
        if (!(o instanceof BookEntity))
            return false;
        BookEntity book = (BookEntity) o;
        return Objects.equals(this.id, book.id)
                && Objects.equals(this.title, book.title)
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
