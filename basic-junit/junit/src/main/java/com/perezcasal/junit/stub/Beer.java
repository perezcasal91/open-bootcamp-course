package com.perezcasal.junit.stub;

import java.util.ArrayList;

public class Beer implements Drink {

    @Override
    public int countIngredients() {
        return 30;
    }

    @Override
    public ArrayList<Integer> getIngredients() {
        return null;
    }
}
