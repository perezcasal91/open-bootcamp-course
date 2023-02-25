package com.perezcasal.junit.stub;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BarTest {
    static Bar bar;
    static Drink drinkStub;
    static Drink drinkMock;

    @BeforeAll
    static void beforeAll() {
        drinkStub = new DrinkStub();
        drinkMock = mock(Juice.class);
    }

    @Test
    void testUsingStub() {
        bar = new Bar(drinkStub);
        assertEquals(3, bar.getDrink().countIngredients());
    }

    @Test
    void testUsingMock() {
        when(drinkMock.countIngredients()).thenReturn(3);
        bar = new Bar(drinkMock);
        assertEquals(3, bar.getDrink().countIngredients());
    }
}