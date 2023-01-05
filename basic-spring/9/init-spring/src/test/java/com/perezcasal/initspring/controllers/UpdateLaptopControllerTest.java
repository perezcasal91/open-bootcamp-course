package com.perezcasal.initspring.controllers;

import com.perezcasal.initspring.entities.LaptopEntity;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class UpdateLaptopControllerTest {
    private final TestRestTemplate testRestTemplate;
    private HttpHeaders httpHeaders;
    private String jsonWithoutId;
    private ResponseEntity<LaptopEntity> responseEntity;
    private HttpEntity<String> httpEntity;

    public UpdateLaptopControllerTest(TestRestTemplate testRestTemplate) {
        this.testRestTemplate = testRestTemplate;
        initHeaders();
        initJSON();
        save();
    }
    private void initHeaders() {
        httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
    }

    private void initJSON() {
        jsonWithoutId = """
                {
                    "brand": "Acer",
                    "storage": "SDD",
                    "price": 5.5,
                    "releaseDate": "2023-01-05",
                    "wifi": true
                }
                """;
    }

    public void updateTest1() {
        System.out.println();
        System.out.println("Staring the Test 1: Normal Update.");

        httpEntity = new HttpEntity<>(jsonWithoutId, httpHeaders);
        responseEntity = testRestTemplate.exchange("/api/laptops/3", HttpMethod.PUT, httpEntity, LaptopEntity.class);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(3, Objects.requireNonNull(responseEntity.getBody()).getId());
        assertEquals("Acer", Objects.requireNonNull(responseEntity.getBody()).getBrand());
        assertEquals("SDD", Objects.requireNonNull(responseEntity.getBody()).getStorage());
        assertEquals(5.5, Objects.requireNonNull(responseEntity.getBody()).getPrice());
        assertEquals(LocalDate.of(2023, 1, 5),
                Objects.requireNonNull(responseEntity.getBody()).getReleaseDate());
        assertEquals(true, Objects.requireNonNull(responseEntity.getBody()).getWifi());

        System.out.println(responseEntity.getBody());
        System.out.println();
    }

    public void updateTest2() {
        System.out.println("Staring the Test 2: Wrong address.");

        httpEntity = new HttpEntity<>(jsonWithoutId, httpHeaders);
        responseEntity = testRestTemplate.exchange
                ("/api/books", HttpMethod.PUT, httpEntity, LaptopEntity.class);

        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());

        System.out.println(responseEntity.getBody());
        System.out.println();
    }

    private void save() {
       String json = """
                {
                    "brand": "HP",
                    "storage": "HDD",
                    "price": 2.5,
                    "releaseDate": "2023-01-03",
                    "wifi": false
                }
                """;
        httpEntity = new HttpEntity<>(json, httpHeaders);
        responseEntity = testRestTemplate.exchange("/api/books/add", HttpMethod.POST, httpEntity, LaptopEntity.class);
    }
}
