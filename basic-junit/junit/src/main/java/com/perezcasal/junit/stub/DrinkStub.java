package com.perezcasal.junit.stub;

import java.util.ArrayList;

public class DrinkStub implements Drink {
    @Override
    public int countIngredients() {
        return 3;
    }

    @Override
    public ArrayList<Integer> getIngredients() {
        ArrayList<Integer> ingredients = new ArrayList<>();
        ingredients.add(1);
        ingredients.add(2);
        ingredients.add(3);
        return ingredients;
    }
}
