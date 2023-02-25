package com.perezcasal.junit.management.entity;

import org.junit.jupiter.api.Test;

public class UserEntityTest {

    @Test
    void createUserTest() {
        UserEntity user = new UserEntity
                .Builder()
                .setId(1L)
                .setName("Elio")
                .setUsername("elio")
                .setPassword("admin")
                .build();
        System.out.println(user);
    }
}
