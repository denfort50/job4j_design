package ru.job4j.ood.warehouse;

import java.time.LocalDate;
import java.util.List;

public class ControlQuality {

    private final List<Redistribution> redistributions;
    private final LocalDate date;

    public ControlQuality(List<Redistribution> redistributions, LocalDate date) {
        this.redistributions = redistributions;
        this.date = date;
    }

    public void executeRedistribution(Food food) {
        for (Redistribution redistribution : redistributions) {
            if (redistribution.accept(food, date)) {
                redistribution.add(food, date);
                break;
            }
        }
    }

    public void resort() {
        redistributions.forEach(redistribution -> {
            List<Food> food = redistribution.get();
            redistribution.clear();
            food.forEach(this::executeRedistribution);
        });
    }
}
