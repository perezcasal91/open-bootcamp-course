package com.perezcasal.laptopdeploy.services.laptops;

import com.perezcasal.laptopdeploy.entities.LaptopEntity;
import com.perezcasal.laptopdeploy.external.LaptopBuilder;
import com.perezcasal.laptopdeploy.repositories.LaptopRepository;
import com.perezcasal.laptopdeploy.services.LaptopServiceImplement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class LaptopServiceImplementTest {
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
        LServiceImplementSaveTest saveTest = new LServiceImplementSaveTest(laptopServiceImplement);
        saveTest.saveTest1();
        saveTest.saveTest2();
        saveTest.saveTest3();
        saveTest.saveTest4();
    }

    @Test
    void updateTest() {
        LServiceImplementUpdateTest updateTest = new LServiceImplementUpdateTest(laptopServiceImplement);
        updateTest.updateTest1();
        updateTest.updateTest2();
        updateTest.updateTest3();
        updateTest.updateTest4();
    }

    @Test
    void deleteTest() {
        System.out.println();
        System.out.println("Staring the Test 1: Delete laptop.");
        laptopServiceImplement.save(laptop);

        laptopServiceImplement.delete(5L);

        var found = laptopServiceImplement.findOneById(1L);

        assertEquals(HttpStatus.NOT_FOUND, found.getStatusCode());

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

        var responseEntity = laptopServiceImplement.findOneById(3L);
        var found = responseEntity.getBody();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(found);
        assertEquals(3, found.getId());
        assertEquals("HP", found.getBrand());
        assertEquals("HDD", found.getStorage());
        assertEquals(2.5, found.getPrice());
        assertEquals(LocalDate.of(2023, 1, 4), found.getReleaseDate());
        assertEquals(true, found.getWifi());

        System.out.println(found);
        System.out.println();

        System.out.println("Staring the Test 2: Laptop not found.");
        responseEntity = laptopServiceImplement.findOneById(7L);
        found = responseEntity.getBody();

        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        assertNull(found);

        System.out.println();
    }

    @Test
    void findAllTest() {
        System.out.println();
        System.out.println("Staring the Test 1: Get all the laptops");

        var laptopsList = laptopServiceImplement.findAll();

        assertEquals(0, laptopsList.size());

        laptopsList.forEach(System.out::println);
        System.out.println();
    }
}