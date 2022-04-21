package ru.job4j.ood.warehouse;

import org.junit.Test;

import java.time.LocalDate;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class ControlQualityTest {

    @Test
    public void whenQualityLess25ThenSendToWarehouse() {
        Food cake = new Food("Moscow", LocalDate.of(2022, 4, 30),
                LocalDate.of(2022, 4, 5),
                1200, 500);
        ControlQuality controlQuality = new ControlQuality(cake, LocalDate.of(2022, 4, 7));
        controlQuality.executeRedistribution();
        String expectClass = "class ru.job4j.ood.warehouse.Warehouse";
        String resultClass = controlQuality.getRedistribution().getClass().toString();
        assertThat(resultClass, is(expectClass));
    }

    @Test
    public void whenQualityMore25AndLess75ThenSendToShop() {
        MacaroniFood spaghetti = new MacaroniFood("Bavette",
                LocalDate.of(2022, 8, 20), LocalDate.of(2022, 2, 20),
                100, 10, 10);
        ControlQuality controlQuality = new ControlQuality(spaghetti, LocalDate.of(2022, 5, 10));
        controlQuality.executeRedistribution();
        String expectClass = "class ru.job4j.ood.warehouse.Shop";
        String resultClass = controlQuality.getRedistribution().getClass().toString();
        assertThat(resultClass, is(expectClass));
    }

    @Test
    public void whenQualityMore75ThenSetPriceWithDiscountAndSendToShop() {
        MeatFood meatFood = new MeatFood("Meat in french", LocalDate.of(2022, 4, 24),
                LocalDate.of(2022, 4, 18),
                800, 250, true);
        ControlQuality controlQuality = new ControlQuality(meatFood, LocalDate.of(2022, 4, 23));
        controlQuality.executeRedistribution();
        int expectPrice = 550;
        int resultPrice = meatFood.getPrice();
        String expectClass = "class ru.job4j.ood.warehouse.Shop";
        String resultClass = controlQuality.getRedistribution().getClass().toString();
        assertThat(resultClass, is(expectClass));
        assertThat(resultPrice, is(expectPrice));
    }

    @Test
    public void whenQualityMore100ThenSendToTrash() {
        MilkFood yogurt = new MilkFood("Danissimo", LocalDate.of(2022, 5, 26),
                LocalDate.of(2022, 4, 10),
                90, 20, "Danon");
        ControlQuality controlQuality = new ControlQuality(yogurt, LocalDate.of(2022, 6, 10));
        controlQuality.executeRedistribution();
        String expectClass = "class ru.job4j.ood.warehouse.Trash";
        String resultClass = controlQuality.getRedistribution().getClass().toString();
        assertThat(resultClass, is(expectClass));
    }
}