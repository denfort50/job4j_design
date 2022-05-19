package ru.job4j.ood.warehouse;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public interface Redistribution {

    boolean add(Food food, LocalDate date);

    List<Food> get();

    boolean accept(Food food, LocalDate date);

    void clear();

    default double calculateQuality(Food food, LocalDate date) {
        double daysProductLives = ChronoUnit.DAYS.between(food.getCreateDate(), food.getExpiryDate());
        double daysAfterProductManufactured = ChronoUnit.DAYS.between(food.getCreateDate(), date);
        return daysAfterProductManufactured / daysProductLives;
    }
}
