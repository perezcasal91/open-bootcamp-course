package com.perezcasal.laptopdeploy.controllers.laptops;

import com.perezcasal.laptopdeploy.entities.LaptopEntity;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class LControllerUpdateTest {
    private final TestRestTemplate testRestTemplate;
    private HttpHeaders httpHeaders;
    private String jsonWithoutId;
    private String jsonWithinOtherId;
    private ResponseEntity<LaptopEntity> responseEntity;
    private HttpEntity<String> httpEntity;
    private final String environment;

    public LControllerUpdateTest(TestRestTemplate testRestTemplate, String environment) {
        this.testRestTemplate = testRestTemplate;
        this.environment = environment;
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
                    "brand": "MAC",
                    "storage": "SDD",
                    "price": 5.5,
                    "releaseDate": "2023-01-04",
                    "wifi": true
                }
                """;

        jsonWithinOtherId = """
                {
                    "id": 2,
                    "brand": "HP",
                    "storage": "HDD",
                    "price": 2.5,
                    "releaseDate": "2023-01-03",
                    "wifi": false
                }
                """;
    }

    public void updateTest1() {
        System.out.println();
        System.out.println("Staring the Test 1: Normal Update.");

        httpEntity = new HttpEntity<>(jsonWithoutId, httpHeaders);
        responseEntity = testRestTemplate
                .exchange("/api/" + environment + "/laptops/3"
                        , HttpMethod.PUT, httpEntity, LaptopEntity.class);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(3, Objects.requireNonNull(responseEntity.getBody()).getId());
        assertEquals("MAC", Objects.requireNonNull(responseEntity.getBody()).getBrand());
        assertEquals("SDD", Objects.requireNonNull(responseEntity.getBody()).getStorage());
        assertEquals(5.5, Objects.requireNonNull(responseEntity.getBody()).getPrice());
        assertEquals(LocalDate.of(2023, 1, 4),
                Objects.requireNonNull(responseEntity.getBody()).getReleaseDate());
        assertEquals(true, Objects.requireNonNull(responseEntity.getBody()).getWifi());

        System.out.println(responseEntity.getBody());
        System.out.println();
    }

    public void updateTest2() {
        System.out.println("Staring the Test 2: Not Found.");

        httpEntity = new HttpEntity<>(jsonWithoutId, httpHeaders);
        responseEntity = testRestTemplate.exchange
                ("/api/" + environment + "/laptops/7"
                        , HttpMethod.PUT, httpEntity, LaptopEntity.class);

        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());

        System.out.println(responseEntity.getBody());
        System.out.println();
    }

    public void updateTest3() {
        System.out.println("Staring the Test 3: Different Id.");

        httpEntity = new HttpEntity<>(jsonWithinOtherId, httpHeaders);
        responseEntity = testRestTemplate.exchange
                ("/api/" + environment + "/laptops/3"
                        , HttpMethod.PUT, httpEntity, LaptopEntity.class);

        assertEquals(HttpStatus.NOT_ACCEPTABLE, responseEntity.getStatusCode());
        assertNull(responseEntity.getBody());

        System.out.println(responseEntity.getBody());
        System.out.println();
    }

    public void updateTest4() {
        System.out.println("Staring the Test 4: Not Id");

        httpEntity = new HttpEntity<>(jsonWithoutId, httpHeaders);
        responseEntity = testRestTemplate.exchange
                ("/api/" + environment + "/laptops/"
                        , HttpMethod.PUT, httpEntity, LaptopEntity.class);

        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());

        System.out.println(responseEntity.getBody());
        System.out.println();
    }

    public void updateTest5() {
        System.out.println("Staring the Test 5: Wrong address.");

        httpEntity = new HttpEntity<>(jsonWithoutId, httpHeaders);
        responseEntity = testRestTemplate.exchange
                ("/api/" + environment + "/laptops"
                        , HttpMethod.PUT, httpEntity, LaptopEntity.class);

        assertEquals(HttpStatus.METHOD_NOT_ALLOWED, responseEntity.getStatusCode());

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
        responseEntity = testRestTemplate
                .exchange("/api/" + environment + "/laptops/add"
                        , HttpMethod.POST, httpEntity, LaptopEntity.class);
    }
}
