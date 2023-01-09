package com.perezcasal.laptopdeploy.controllers.laptops;

import com.perezcasal.laptopdeploy.entities.LaptopEntity;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class LControllerSaveTest {
    private final TestRestTemplate testRestTemplate;
    private HttpHeaders httpHeaders;
    private String jsonWithoutId;
    private String jsonWithoutAttributes;
    private String jsonWithinId;
    private ResponseEntity<LaptopEntity> responseEntity;
    private HttpEntity<String> httpEntity;

    private final String environment;

    public LControllerSaveTest(TestRestTemplate testRestTemplate, String environment) {
        this.testRestTemplate = testRestTemplate;
        this.environment = environment;
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
                    "price": 500.4
                }
                """;

        jsonWithinId = """
                {
                    "id": 1,
                    "brand": "HP",
                    "storage": "HDD",
                    "price": 2.5,
                    "releaseDate": "2023-01-03",
                    "wifi": false
                }
                """;
    }

    public void saveTest1() {
        System.out.println();
        System.out.println("Staring the Test 1: Normal Save.");

        httpEntity = new HttpEntity<>(jsonWithoutId, httpHeaders);
        responseEntity = testRestTemplate
                .exchange("/api/" + environment + "/laptops/add"
                        , HttpMethod.POST, httpEntity, LaptopEntity.class);

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
        System.out.println("Staring the Test 2: Without Attributes Save.");

        httpEntity = new HttpEntity<>(jsonWithoutAttributes, httpHeaders);
        responseEntity = testRestTemplate.exchange
                ("/api/" + environment + "/laptops/add"
                        , HttpMethod.POST, httpEntity, LaptopEntity.class);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(2, Objects.requireNonNull(responseEntity.getBody()).getId());
        assertEquals("HP", Objects.requireNonNull(responseEntity.getBody()).getBrand());
        assertEquals("HDD", Objects.requireNonNull(responseEntity.getBody()).getStorage());
        assertEquals(500.4, Objects.requireNonNull(responseEntity.getBody()).getPrice());

        System.out.println(responseEntity.getBody());
        System.out.println();
    }

    public void saveTest3() {
        System.out.println("Staring the Test 3: With Id Save.");

        httpEntity = new HttpEntity<>(jsonWithinId, httpHeaders);
        responseEntity = testRestTemplate.exchange
                ("/api/" + environment + "/laptops/add"
                        , HttpMethod.POST, httpEntity, LaptopEntity.class);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertNull(responseEntity.getBody());

        System.out.println(responseEntity.getBody());
        System.out.println();
    }

    public void saveTest4() {
        System.out.println("Staring the Test 4: Same Element Save.");

        httpEntity = new HttpEntity<>(jsonWithoutId, httpHeaders);
        responseEntity = testRestTemplate.exchange
                ("/api/" + environment + "/laptops/add"
                        , HttpMethod.POST, httpEntity, LaptopEntity.class);

        assertEquals(HttpStatus.NOT_ACCEPTABLE, responseEntity.getStatusCode());

        System.out.println(responseEntity.getBody());
        System.out.println();
    }

    public void saveTest5() {
        System.out.println("Staring the Test 5: Not Allowed.");

        httpEntity = new HttpEntity<>(jsonWithoutId, httpHeaders);
        responseEntity = testRestTemplate.exchange
                ("/api/" + environment + "/laptops/add/1"
                        , HttpMethod.POST, httpEntity, LaptopEntity.class);

        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());

        System.out.println(responseEntity.getBody());
        System.out.println();
    }
}
