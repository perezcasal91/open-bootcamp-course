package com.perezcasal.initspring.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.models.annotations.OpenAPI31;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "laptop")
@Tag(name = "Laptop Entity")
public class LaptopEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Schema(name = "id", description = "Id",
            type = "Long", example = "1")
    private Long id;
    @Schema(name = "brand", description = "Brand",
            type = "String", example = "HP")
    private String brand;
    @Schema(name = "storage", description = "Storage",
            type = "String", example = "HDD")
    private String storage;
    @Schema(name = "price", description = "Price",
            type = "Double", example = "500.5")
    private Double price;
    @Schema(name = "releaseDate", description = "Release Date",
            type = "LocalDate", example = "2023-01-04")
    private LocalDate releaseDate;
    @Schema(name = "wifi", description = "Wi-Fi",
            type = "Boolean", example = "true or false")
    private Boolean wifi;
    public LaptopEntity() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
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

    public Boolean getWifi() {
        return wifi;
    }

    public void setWifi(Boolean wifi) {
        this.wifi = wifi;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof LaptopEntity book))
            return false;
        return Objects.equals(this.brand, book.brand)
                && Objects.equals(this.storage, book.storage)
                && Objects.equals(this.price, book.price)
                && Objects.equals(this.releaseDate, book.releaseDate)
                && Objects.equals(this.wifi, book.wifi);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.brand, this.storage
                , this.price, this.releaseDate, this.wifi);
    }

    @Override
    public String toString() {
        return String
                .format("Book[id=%d, brand='%s', storage='%s', price='%s'" +
                                ", releaseDate='%s', wifi='%s']",
                        id, brand, storage, price, releaseDate, wifi);
    }
}
