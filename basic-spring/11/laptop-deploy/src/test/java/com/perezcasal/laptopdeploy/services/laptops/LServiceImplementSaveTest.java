package com.perezcasal.laptopdeploy.services.laptops;

import com.perezcasal.laptopdeploy.entities.LaptopEntity;
import com.perezcasal.laptopdeploy.external.LaptopBuilder;
import com.perezcasal.laptopdeploy.services.LaptopServiceImplement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class LServiceImplementSaveTest {
    private final LaptopServiceImplement laptopServiceImplement;
    private LaptopEntity laptop;
    private LaptopEntity laptopWithoutId;
    private LaptopEntity laptopWithinId;
    private LaptopEntity laptopWithoutAttributes;

    private ResponseEntity<LaptopEntity> responseEntity;

    public LServiceImplementSaveTest(LaptopServiceImplement laptopServiceImplement) {
        this.laptopServiceImplement = laptopServiceImplement;
        initLaptops();
    }
    private void initLaptops() {
        laptop = new LaptopBuilder()
                .setBrand("HP")
                .setStorage("HDD")
                .setPrice(2.5)
                .setReleaseDate(LocalDate.of(2023, 1, 4))
                .setWifi(true)
                .build();
        laptopWithoutId = new LaptopBuilder()
                .setBrand("HP")
                .setStorage("HDD")
                .setPrice(2.5)
                .setReleaseDate(LocalDate.of(2023, 1, 4))
                .setWifi(true)
                .build();
        laptopWithinId = new LaptopBuilder()
                .setId(1L)
                .setBrand("HP")
                .setStorage("HDD")
                .setPrice(2.5)
                .setReleaseDate(LocalDate.of(2023, 1, 4))
                .setWifi(true)
                .build();
        laptopWithoutAttributes = new LaptopBuilder()
                .setBrand("HP")
                .setStorage("HDD")
                .setPrice(500.5)
                .build();
    }
    public void saveTest1() {
        System.out.println();
        System.out.println("Staring the Test 1: Normal Save.");

        responseEntity = laptopServiceImplement.save(laptop);
        var saved = responseEntity.getBody();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(saved);
        assertEquals(1, saved.getId());
        assertEquals("HP", saved.getBrand());
        assertEquals("HDD", saved.getStorage());
        assertEquals(2.5, saved.getPrice());
        assertEquals(LocalDate.of(2023, 1, 4), saved.getReleaseDate());
        assertEquals(true, saved.getWifi());

        System.out.println(saved);
        System.out.println();
    }

    public void saveTest2() {
        System.out.println("Staring the Test 2: Without Attributes Save.");

        responseEntity = laptopServiceImplement.save(laptopWithoutAttributes);
        var saved = responseEntity.getBody();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(saved);
        assertEquals(2, saved.getId());
        assertEquals("HP", saved.getBrand());
        assertEquals("HDD", saved.getStorage());
        assertEquals(500.5, saved.getPrice());

        System.out.println(saved);
        System.out.println();
    }

    public void saveTest3() {
        System.out.println("Staring the Test 3: With Id Save.");

        responseEntity = laptopServiceImplement.save(laptopWithinId);
        var savedWithId = responseEntity.getBody();

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertNull(savedWithId);

        System.out.println();
    }

    public void saveTest4() {
        System.out.println("Staring the Test 4: Same Element Save.");

        responseEntity = laptopServiceImplement.save(laptopWithoutId);
        var savedSameElement = responseEntity.getBody();

        assertEquals(HttpStatus.NOT_ACCEPTABLE, responseEntity.getStatusCode());
        assertNull(savedSameElement);

        System.out.println();
    }
}
