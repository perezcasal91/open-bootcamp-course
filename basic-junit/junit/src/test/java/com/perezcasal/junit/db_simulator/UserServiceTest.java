package com.perezcasal.junit.db_simulator;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


class UserServiceTest {
    static UserDB userDBStub;
    static UserService userServiceStub;
    static User userE;
    static User userD;
    static ArrayList<User> users;

    @BeforeAll
    static void beforeAll() {
        userD = new User.Builder()
                .setName("Day")
                .setLastname("Leon")
                .setUsername("day")
                .setEmail("day@gmail.com")
                .setAccessLevel(1)
                .build();

        userE = new User.Builder()
                .setName("Elio")
                .setLastname("Perez")
                .setUsername("elio")
                .setEmail("elio@gmail.com")
                .setAccessLevel(1)
                .build();

        users = new ArrayList<>();
        users.add(userE);
        users.add(userD);
    }

    @BeforeEach
    void beforeEach() {
        userDBStub = new UserDBStub();
        userServiceStub = new UserService(userDBStub);
    }

    @Test
    void saveUsingStub() {
        boolean saved = userServiceStub.add(userE);
        assertFalse(saved);

        User savedUser = userServiceStub.get("elio");
        assertEquals(userE.getUsername(), savedUser.getUsername());
    }

    @Nested
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    @ExtendWith(MockitoExtension.class)
    public class UsingMock {
        @Spy
        static UserDB userDBMock;
        @InjectMocks
        static UserService userServiceMock;

        @Test
        @Order(1)
        void getAllUsersUsingMock() {
            when(userDBMock.getAllUsers()).thenReturn(users);

            System.out.println(userDBMock.getAllUsers());

            assertTrue(userServiceMock.getAll().size() > 0);
        }

        @Test
        @Order(2)
        void saveUsingMock() {
            when(userDBMock.save(userD)).thenReturn(true);

            boolean saved = userServiceMock.add(userD);

            System.out.println(saved);

            assertTrue(saved);
        }

        @Test
        @Order(3)
        void getUserByUsername() {
            when(userDBMock.getUserByUsername(userDBMock.getAllUsers(), "day")).thenReturn(userD);

            User found = userServiceMock.get("day");

            System.out.println(found);

            assertEquals(found.getUsername(), userD.getUsername());
        }

        @Test
        @Order(4)
        void deleteUsingMock() {
            when(userDBMock.delete(userE)).thenReturn(true);

            when(userServiceMock.get(userE.getUsername())).thenReturn(userE);

            boolean deleted = userServiceMock.remove(userE.getUsername());

            System.out.println(deleted);

            assertTrue(deleted);
        }
    }
}