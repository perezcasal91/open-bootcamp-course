package com.perezcasal.laptopdeploy.external;

import com.perezcasal.laptopdeploy.entities.LaptopEntity;
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

    public LaptopBuilder setBrand(String brand) {
        this.laptop.setBrand(brand);
        return this;
    }

    public LaptopBuilder setStorage(String storage) {
        this.laptop.setStorage(storage);
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

    public LaptopBuilder setWifi(Boolean wifi) {
        this.laptop.setWifi(wifi);
        return this;
    }

    public LaptopEntity build() {
        return laptop;
    }
}
