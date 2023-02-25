package com.perezcasal.junit.stub;

import java.util.ArrayList;

public class Juice implements Drink {
    private final ArrayList<Integer> ingredients;

    public Juice() {
        this.ingredients = new ArrayList<>();
        init();
    }

    private void init() {
        int value = (int) (Math.random() * 10);
        for (int i = 0; i < value; i++) {
            ingredients.add(i);
        }
    }

    @Override
    public ArrayList<Integer> getIngredients() {
        return ingredients;
    }

    @Override
    public int countIngredients() {
        return ingredients.size();
    }
}
