package com.perezcasal.laptopdeploy.services.laptops;

import com.perezcasal.laptopdeploy.entities.LaptopEntity;
import com.perezcasal.laptopdeploy.external.LaptopBuilder;
import com.perezcasal.laptopdeploy.services.LaptopServiceImplement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class LServiceImplementUpdateTest {
    private final LaptopServiceImplement laptopServiceImplement;
    private LaptopEntity laptop;
    private LaptopEntity laptopWithoutId;
    private LaptopEntity laptopWithId;
    private ResponseEntity<LaptopEntity> responseEntity;

    public LServiceImplementUpdateTest(LaptopServiceImplement laptopServiceImplement) {
        this.laptopServiceImplement = laptopServiceImplement;
        initLaptops();
    }
    private void initLaptops() {
        laptop = new LaptopBuilder()
                .setBrand("MAC")
                .setStorage("SDD")
                .setPrice(5.5)
                .setReleaseDate(LocalDate.of(2023, 1, 5))
                .setWifi(true)
                .build();
        laptopWithoutId = new LaptopBuilder()
                .setBrand("HP")
                .setStorage("HDD")
                .setPrice(5.5)
                .setReleaseDate(LocalDate.of(2023, 1, 5))
                .setWifi(true)
                .build();
        laptopWithId = new LaptopBuilder()
                .setId(6L)
                .setBrand("MAC")
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

        responseEntity = laptopServiceImplement.update(laptopWithoutId, 4L);
        var updated = responseEntity.getBody();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(updated);
        assertEquals(4, updated.getId());
        assertEquals("HP", updated.getBrand());
        assertEquals("HDD", updated.getStorage());
        assertEquals(5.5, updated.getPrice());
        assertEquals(LocalDate.of(2023, 1, 5), updated.getReleaseDate());
        assertEquals(true, updated.getWifi());

        System.out.println(updated);
        System.out.println();
    }

    public void updateTest2() {
        System.out.println("Staring the Test 2: No found.");
        responseEntity = laptopServiceImplement.update(laptop, 6L);
        var updated = responseEntity.getBody();

        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        assertNull(updated);

        System.out.println();
    }

    public void updateTest3() {
        System.out.println("Staring the Test 3: Different Id.");
        responseEntity = laptopServiceImplement.update(laptopWithId, 4L);
        var updated = responseEntity.getBody();

        assertEquals(HttpStatus.NOT_ACCEPTABLE, responseEntity.getStatusCode());
        assertNull(updated);

        System.out.println();
    }

    public void updateTest4() {
        System.out.println("Staring the Test 3: Null Id.");
        responseEntity = laptopServiceImplement.update(laptopWithId, null);
        var updated = responseEntity.getBody();

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertNull(updated);

        System.out.println();
    }
}
