package com.perezcasal.initspring.external;

import com.perezcasal.initspring.entities.LaptopEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class LaptopBuilder {
    private final LaptopEntity laptop;

    public LaptopBuilder() {
        this.laptop = new LaptopEntity();
    }

    public LaptopBuilder setId(Long id) {
        laptop.setId(id);
        return this;
    }

    public LaptopBuilder setBrand(String title) {
        this.laptop.setBrand(title);
        return this;
    }

    public LaptopBuilder setStorage(String author) {
        this.laptop.setStorage(author);
        return this;
    }

    public LaptopBuilder setPrice(Double price) {
        this.laptop.setPrice(price);
        return this;
    }

    public LaptopBuilder setReleaseDate(LocalDate releaseDate) {
        this.laptop.setReleaseDate(releaseDate);
        return this;
    }

    public LaptopBuilder setWifi(Boolean online) {
        this.laptop.setWifi(online);
        return this;
    }

    public LaptopEntity build() {
        return laptop;
    }
}
