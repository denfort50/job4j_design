package ru.job4j.ood.warehouse;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Trash implements Redistribution {
    private final List<Food> storage = new ArrayList<>();

    @Override
    public boolean add(Food food, LocalDate date) {
        boolean result = false;
        if (accept(food, date)) {
            storage.add(food);
            result = true;
        }
        return result;
    }

    @Override
    public boolean accept(Food food, LocalDate date) {
        boolean result = false;
        double quality = calculateQuality(food, date);
        if (quality >= 1) {
            result = true;
        }
        return result;
    }

    @Override
    public List<Food> get() {
        return List.copyOf(storage);
    }

    @Override
    public void clear() {
        storage.clear();
    }
}
