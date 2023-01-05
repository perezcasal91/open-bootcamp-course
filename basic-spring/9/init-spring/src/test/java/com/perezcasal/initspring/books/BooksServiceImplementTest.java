package com.perezcasal.initspring.books;

import com.perezcasal.initspring.entities.LaptopEntity;
import com.perezcasal.initspring.external.LaptopBuilder;
import com.perezcasal.initspring.repositories.LaptopRepository;
import com.perezcasal.initspring.services.LaptopServiceImplement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class BooksServiceImplementTest {
    @Autowired
    private LaptopRepository laptopRepository;
    private LaptopServiceImplement laptopServiceImplement;
    private LaptopEntity laptop;

    @BeforeEach
    void setUp() {
        laptopServiceImplement = new LaptopServiceImplement(laptopRepository);
        laptop = new LaptopBuilder()
                .setBrand("HP")
                .setStorage("HDD")
                .setPrice(2.5)
                .setReleaseDate(LocalDate.of(2023, 1, 4))
                .setWifi(true)
                .build();
    }

    @Test
    void saveTest() {
        SaveLaptopsServiceImplementTest saveTest = new SaveLaptopsServiceImplementTest(laptopServiceImplement);
        saveTest.saveTest1();
        saveTest.saveTest2();
        saveTest.saveTest3();
    }

    @Test
    void updateTest() {
        UpdateLaptopsServiceImplementTest updateTest = new UpdateLaptopsServiceImplementTest(laptopServiceImplement);
        updateTest.updateTest1();
    }

    @Test
    void deleteTest() {
        System.out.println();
        System.out.println("Staring the Test 1: Delete laptop.");
        laptopServiceImplement.save(laptop);

        laptopServiceImplement.delete(5L);

        assertNull(laptopServiceImplement.findOneById(1L));
        System.out.println();
    }

    @Test
    void deleteAllTest() {
        System.out.println();
        System.out.println("Staring the Test 1: Delete all laptops.");

        laptopServiceImplement.deleteAll();

        assertEquals(0, laptopServiceImplement.findAll().size());
        System.out.println();
    }

    @Test
    void findOneByIdTest() {
        System.out.println();
        System.out.println("Staring the Test 1: Laptop found.");
        laptopServiceImplement.save(laptop);

        LaptopEntity found = laptopServiceImplement.findOneById(3L);

        assertEquals(3, found.getId());
        assertEquals("HP", found.getBrand());
        assertEquals("HDD", found.getStorage());
        assertEquals(2.5, found.getPrice());
        assertEquals(LocalDate.of(2023, 1, 4), found.getReleaseDate());
        assertEquals(true, found.getWifi());

        System.out.println(found);
        System.out.println();

        System.out.println("Staring the Test 2: Laptop not found.");
        found = laptopServiceImplement.findOneById(1L);

        assertNull(found);
    }

    @Test
    void findAllTest() {
        System.out.println();
        System.out.println("Staring the Test 1: Get all the laptops");

        var laptopEntityList = laptopServiceImplement.findAll();

        assertEquals(0, laptopEntityList.size());

        laptopEntityList.forEach(System.out::println);
        System.out.println();
    }
}