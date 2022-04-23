package ru.job4j.ood.warehouse;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Predicate;

public class ControlQuality {

    private final List<Redistribution> redistributions;
    private final Food food;
    private final LocalDate date;

    public ControlQuality(List<Redistribution> redistributions, Food food, LocalDate date) {
        this.redistributions = redistributions;
        this.food = food;
        this.date = date;
    }

    public String executeRedistribution() {
        String result = "";
        Predicate<Redistribution> predicate = redistribution -> redistribution.accept(food, date);
        for (Redistribution redistribution : redistributions) {
            if (predicate.test(redistribution)) {
                redistribution.add(food, date);
                result = redistribution.getClass().toString();
            }
        }
        return result;
    }
}
