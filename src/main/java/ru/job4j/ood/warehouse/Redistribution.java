package ru.job4j.ood.warehouse;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public interface Redistribution {

    boolean add(Food food, LocalDate date);

    boolean accept(Food food, LocalDate date);

    default double calculateQuality(Food food, LocalDate date) {
        double daysProductLives = ChronoUnit.DAYS.between(food.getCreateDate(), food.getExpiryDate());
        double daysAfterProductManufactured = ChronoUnit.DAYS.between(food.getCreateDate(), date);
        return daysAfterProductManufactured / daysProductLives;
    }
}
