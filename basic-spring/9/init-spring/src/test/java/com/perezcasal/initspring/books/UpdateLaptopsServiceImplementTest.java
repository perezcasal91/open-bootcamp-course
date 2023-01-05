package com.perezcasal.initspring.books;

import com.perezcasal.initspring.entities.LaptopEntity;
import com.perezcasal.initspring.external.LaptopBuilder;
import com.perezcasal.initspring.services.LaptopServiceImplement;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class UpdateLaptopsServiceImplementTest {
    private final LaptopServiceImplement laptopServiceImplement;
    private LaptopEntity laptopWithoutId;

    public UpdateLaptopsServiceImplementTest(LaptopServiceImplement laptopServiceImplement) {
        this.laptopServiceImplement = laptopServiceImplement;
        initBooks();
    }
    private void initBooks() {
        LaptopEntity laptop = new LaptopBuilder()
                .setBrand("HP")
                .setStorage("HDD")
                .setPrice(5.5)
                .setReleaseDate(LocalDate.of(2023, 1, 5))
                .setWifi(true)
                .build();
        laptopWithoutId = new LaptopBuilder()
                .setBrand("ACER")
                .setStorage("SDD")
                .setPrice(5.5)
                .setReleaseDate(LocalDate.of(2023, 1, 5))
                .setWifi(true)
                .build();
        laptopServiceImplement.save(laptop);
    }
    public void updateTest1() {
        System.out.println();
        System.out.println("Staring the Test 1: Normal Update.");

        LaptopEntity responseEntity = laptopServiceImplement.update(laptopWithoutId, 4L);

        assertEquals(4, responseEntity.getId());
        assertEquals("ACER", responseEntity.getBrand());
        assertEquals("SDD", responseEntity.getStorage());
        assertEquals(5.5, responseEntity.getPrice());
        assertEquals(LocalDate.of(2023, 1, 5), responseEntity.getReleaseDate());
        assertEquals(true, responseEntity.getWifi());

        System.out.println(responseEntity);
        System.out.println();
    }
}
