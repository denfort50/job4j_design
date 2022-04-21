package ru.job4j.ood.warehouse;

import java.time.LocalDate;

public class MacaroniFood extends Food {

    int cookingTime;

    public MacaroniFood(String name, LocalDate expiryDate, LocalDate createDate, int price, int discount, int cookingTime) {
        super(name, expiryDate, createDate, price, discount);
        this.cookingTime = cookingTime;
    }
}
