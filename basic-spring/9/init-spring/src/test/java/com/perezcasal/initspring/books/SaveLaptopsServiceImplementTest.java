package com.perezcasal.initspring.books;


import com.perezcasal.initspring.entities.LaptopEntity;
import com.perezcasal.initspring.external.LaptopBuilder;
import com.perezcasal.initspring.services.LaptopServiceImplement;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class SaveLaptopsServiceImplementTest {
    private final LaptopServiceImplement laptopServiceImplement;
    private LaptopEntity laptop;
    private LaptopEntity laptopWithoutId;
    private LaptopEntity bookWithoutAttributes;

    private LaptopEntity responseEntity;

    public SaveLaptopsServiceImplementTest(LaptopServiceImplement laptopServiceImplement) {
        this.laptopServiceImplement = laptopServiceImplement;
        initBooks();
    }
    private void initBooks() {
        laptop = new LaptopBuilder()
                .setBrand("HP")
                .setStorage("HDD")
                .setPrice(2.5)
                .setReleaseDate(LocalDate.of(2023, 1, 4))
                .setWifi(true)
                .build();
        laptopWithoutId =  new LaptopBuilder()
                .setBrand("HP")
                .setStorage("HDD")
                .setPrice(2.5)
                .setReleaseDate(LocalDate.of(2023, 1, 4))
                .setWifi(true)
                .build();
        bookWithoutAttributes =  new LaptopBuilder()
                .setBrand("HP")
                .setStorage("HDD")
                .setPrice(2.5)
                .build();
    }
    public void saveTest1() {
        System.out.println();
        System.out.println("Staring the Test 1: Normal Save");

        responseEntity = laptopServiceImplement.save(laptop);

        assertEquals(1, responseEntity.getId());
        assertEquals("HP", responseEntity.getBrand());
        assertEquals("HDD", responseEntity.getStorage());
        assertEquals(2.5, responseEntity.getPrice());
        assertEquals(LocalDate.of(2023, 1, 4), responseEntity.getReleaseDate());
        assertEquals(true, responseEntity.getWifi());

        System.out.println(responseEntity);
        System.out.println();
    }

    public void saveTest2() {
        System.out.println("Staring the Test 2: Without Attributes Save");
        responseEntity = laptopServiceImplement.save(bookWithoutAttributes);

        assertEquals(2, responseEntity.getId());
        assertEquals("HP", responseEntity.getBrand());
        assertEquals("HDD", responseEntity.getStorage());
        assertEquals(2.5, responseEntity.getPrice());

        System.out.println(responseEntity);
        System.out.println();
    }

    public void saveTest3() {
        System.out.println("Staring the Test 3: Same Element Save");
        responseEntity = laptopServiceImplement.save(laptopWithoutId);

        assertNull(responseEntity);

        System.out.println();
    }
}
