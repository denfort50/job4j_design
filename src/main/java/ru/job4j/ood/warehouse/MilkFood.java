package ru.job4j.ood.warehouse;

import java.time.LocalDate;

public class MilkFood extends Food {

    private String manufacturer;

    public MilkFood(String name, LocalDate expiryDate, LocalDate createDate, int price, int discount, String manufacturer) {
        super(name, expiryDate, createDate, price, discount);
        this.manufacturer = manufacturer;
    }
}
