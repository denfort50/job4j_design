package ru.job4j.ood.warehouse;

import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class ControlQualityTest {

    @Test
    public void whenQualityLess25ThenSendToWarehouse() {
        Food cake = new Food("Moscow", LocalDate.now().plusDays(20),
                LocalDate.now(), 1200, 500);
        Warehouse warehouse = new Warehouse();
        Shop shop = new Shop();
        Trash trash = new Trash();
        List<Redistribution> redistributionList = new ArrayList<>(List.of(warehouse, shop, trash));
        ControlQuality controlQuality = new ControlQuality(redistributionList, cake,
                LocalDate.now().plusDays(4));
        String expectClass = "class ru.job4j.ood.warehouse.Warehouse";
        String resultClass = controlQuality.executeRedistribution();
        assertThat(resultClass, is(expectClass));
    }

    @Test
    public void whenQualityMore25AndLess75ThenSendToShop() {
        MacaroniFood spaghetti = new MacaroniFood("Bavette",
                LocalDate.now().plusDays(180), LocalDate.now(), 100, 10, 10);
        Warehouse warehouse = new Warehouse();
        Shop shop = new Shop();
        Trash trash = new Trash();
        List<Redistribution> redistributionList = new ArrayList<>(List.of(warehouse, shop, trash));
        ControlQuality controlQuality = new ControlQuality(redistributionList, spaghetti,
                LocalDate.now().plusDays(50));
        String expectClass = "class ru.job4j.ood.warehouse.Shop";
        String resultClass = controlQuality.executeRedistribution();
        assertThat(resultClass, is(expectClass));
    }

    @Test
    public void whenQualityMore75ThenSetPriceWithDiscountAndSendToShop() {
        MeatFood meatFood = new MeatFood("Meat in french", LocalDate.now().plusDays(14),
                LocalDate.now(), 800, 250, true);
        Warehouse warehouse = new Warehouse();
        Shop shop = new Shop();
        Trash trash = new Trash();
        List<Redistribution> redistributionList = new ArrayList<>(List.of(warehouse, shop, trash));
        ControlQuality controlQuality = new ControlQuality(redistributionList, meatFood,
                LocalDate.now().plusDays(11));
        String expectClass = "class ru.job4j.ood.warehouse.Shop";
        String resultClass = controlQuality.executeRedistribution();
        assertThat(resultClass, is(expectClass));
        int expectPrice = 550;
        int resultPrice = meatFood.getPrice();
        assertThat(resultPrice, is(expectPrice));
    }

    @Test
    public void whenQualityMore100ThenSendToTrash() {
        MilkFood yogurt = new MilkFood("Danissimo", LocalDate.now().plusDays(21),
                LocalDate.now(), 90, 20, "Danon");
        Warehouse warehouse = new Warehouse();
        Shop shop = new Shop();
        Trash trash = new Trash();
        List<Redistribution> redistributionList = new ArrayList<>(List.of(warehouse, shop, trash));
        ControlQuality controlQuality = new ControlQuality(redistributionList, yogurt,
                LocalDate.now().plusDays(22));
        String expectClass = "class ru.job4j.ood.warehouse.Trash";
        String resultClass = controlQuality.executeRedistribution();
        assertThat(resultClass, is(expectClass));
    }

    @Test
    public void whenDistribute3Products() {
        Food cake = new Food("Moscow", LocalDate.now().plusDays(20),
                LocalDate.now(), 1200, 500);
        MacaroniFood spaghetti = new MacaroniFood("Bavette",
                LocalDate.now().plusDays(180), LocalDate.now(), 100, 10, 10);
        MilkFood yogurt = new MilkFood("Danissimo", LocalDate.now().plusDays(21),
                LocalDate.now(), 90, 20, "Danon");
        Warehouse warehouse = new Warehouse();
        Shop shop = new Shop();
        Trash trash = new Trash();
        List<Redistribution> redistributionList = new ArrayList<>(List.of(warehouse, shop, trash));
        ControlQuality controlQuality1 = new ControlQuality(redistributionList, cake,
                LocalDate.now().plusDays(4));
        ControlQuality controlQuality2 = new ControlQuality(redistributionList, spaghetti,
                LocalDate.now().plusDays(50));
        ControlQuality controlQuality3 = new ControlQuality(redistributionList, yogurt,
                LocalDate.now().plusDays(22));
        String expectClass1 = "class ru.job4j.ood.warehouse.Warehouse";
        String resultClass1 = controlQuality1.executeRedistribution();
        assertThat(resultClass1, is(expectClass1));
        String expectClass2 = "class ru.job4j.ood.warehouse.Shop";
        String resultClass2 = controlQuality2.executeRedistribution();
        assertThat(resultClass2, is(expectClass2));
        String expectClass3 = "class ru.job4j.ood.warehouse.Trash";
        String resultClass3 = controlQuality3.executeRedistribution();
        assertThat(resultClass3, is(expectClass3));
    }
}