package ru.job4j.ood.warehouse;

import java.time.LocalDate;

public class MeatFood extends Food {

    private boolean redMeat;

    public MeatFood(String name, LocalDate expiryDate, LocalDate createDate, int price, int discount, boolean redMeat) {
        super(name, expiryDate, createDate, price, discount);
        this.redMeat = redMeat;
    }
}
