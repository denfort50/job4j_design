package ru.job4j.ood.warehouse;

import java.util.ArrayList;
import java.util.List;

public class Trash implements Redistribution {
    private final List<Food> storage = new ArrayList<>();

    @Override
    public void redistribute(Food food) {
        storage.add(food);
    }

}
