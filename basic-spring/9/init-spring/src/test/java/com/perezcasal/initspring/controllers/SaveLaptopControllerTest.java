package com.perezcasal.initspring.controllers;

import com.perezcasal.initspring.entities.LaptopEntity;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class SaveLaptopControllerTest {
    private final TestRestTemplate testRestTemplate;
    private HttpHeaders httpHeaders;
    private String jsonWithoutId;
    private String jsonWithoutAttributes;
    private ResponseEntity<LaptopEntity> responseEntity;
    private HttpEntity<String> httpEntity;

    public SaveLaptopControllerTest(TestRestTemplate testRestTemplate) {
        this.testRestTemplate = testRestTemplate;
        initHeaders();
        initJSON();
    }
    private void initHeaders() {
        httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
    }

    private void initJSON() {
        jsonWithoutId = """
                {
                    "brand": "HP",
                    "storage": "HDD",
                    "price": 2.5,
                    "releaseDate": "2023-01-03",
                    "wifi": false
                }
                """;

        jsonWithoutAttributes = """
                {
                    "brand": "HP",
                    "storage": "HDD",
                    "price": 2.5
                }
                """;
    }

    public void saveTest1() {
        System.out.println();
        System.out.println("Staring the Test 1");

        httpEntity = new HttpEntity<>(jsonWithoutId, httpHeaders);
        responseEntity = testRestTemplate.exchange("/api/laptops/add", HttpMethod.POST, httpEntity, LaptopEntity.class);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(1, Objects.requireNonNull(responseEntity.getBody()).getId());
        assertEquals("HP", Objects.requireNonNull(responseEntity.getBody()).getBrand());
        assertEquals("HDD", Objects.requireNonNull(responseEntity.getBody()).getStorage());
        assertEquals(2.5, Objects.requireNonNull(responseEntity.getBody()).getPrice());
        assertEquals(LocalDate.of(2023, 1, 3),
                Objects.requireNonNull(responseEntity.getBody()).getReleaseDate());
        assertEquals(false, Objects.requireNonNull(responseEntity.getBody()).getWifi());

        System.out.println(responseEntity.getBody());
        System.out.println();
    }

    public void saveTest2() {
        System.out.println("Staring the Test 2");

        httpEntity = new HttpEntity<>(jsonWithoutAttributes, httpHeaders);
        responseEntity = testRestTemplate.exchange
                ("/api/laptops/add", HttpMethod.POST, httpEntity, LaptopEntity.class);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        System.out.println(responseEntity.getBody());
        System.out.println();
    }

    public void saveTest3() {
        System.out.println("Staring the Test 3");

        httpEntity = new HttpEntity<>(jsonWithoutId, httpHeaders);
        responseEntity = testRestTemplate.exchange
                ("/api/laptops/add", HttpMethod.POST, httpEntity, LaptopEntity.class);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());

        System.out.println(responseEntity.getBody());
        System.out.println();
    }
}
