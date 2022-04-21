package ru.job4j.ood.warehouse;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ControlQuality {

    private final Redistribution redistribution;
    private final Food food;

    public ControlQuality(Food food, LocalDate date) {
        this.redistribution = choseStorage(food, date);
        this.food = food;
    }

    public Redistribution choseStorage(Food food, LocalDate date) {
        Redistribution redistribution;
        double quality = calculateQuality(food, date);
        if (quality < 0.25) {
            redistribution = new Warehouse();
        } else if (quality >= 0.25 && quality < 0.75) {
            redistribution = new Shop();
        } else if (quality >= 0.75 && quality < 1) {
            food.setPrice(food.getPrice() - food.getDiscount());
            redistribution = new Shop();
        } else {
            redistribution = new Trash();
        }
        return redistribution;
    }

    public double calculateQuality(Food food, LocalDate date) {
        double daysProductLives = ChronoUnit.DAYS.between(food.getCreateDate(), food.getExpiryDate());
        double daysAfterProductManufactured = ChronoUnit.DAYS.between(food.getCreateDate(), date);
        return daysAfterProductManufactured / daysProductLives;
    }

    public void executeRedistribution() {
        redistribution.redistribute(food);
    }

    public Redistribution getRedistribution() {
        return redistribution;
    }
}
