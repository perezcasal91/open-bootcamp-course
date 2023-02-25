package com.perezcasal.junit.stub;

public class Bar {
    private final Drink drink;

    public Bar(Drink drink) {
        this.drink = drink;
    }

    public Drink getDrink() {
        return drink;
    }
}
