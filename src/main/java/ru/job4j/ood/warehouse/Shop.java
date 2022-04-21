package ru.job4j.ood.warehouse;

import java.util.ArrayList;
import java.util.List;

public class Shop implements Redistribution {
    private final List<Food> storage = new ArrayList<>();

    @Override
    public void redistribute(Food food) {
        storage.add(food);
    }

}
