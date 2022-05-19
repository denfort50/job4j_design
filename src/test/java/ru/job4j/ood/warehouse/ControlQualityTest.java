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
        ControlQuality controlQuality = new ControlQuality(redistributionList,
                LocalDate.now().plusDays(4));
        controlQuality.executeRedistribution(cake);
        assertThat(warehouse.get().size(), is(1));
    }

    @Test
    public void whenQualityMore25AndLess75ThenSendToShop() {
        MacaroniFood spaghetti = new MacaroniFood("Bavette",
                LocalDate.now().plusDays(180), LocalDate.now(), 100, 10, 10);
        Warehouse warehouse = new Warehouse();
        Shop shop = new Shop();
        Trash trash = new Trash();
        List<Redistribution> redistributionList = new ArrayList<>(List.of(warehouse, shop, trash));
        ControlQuality controlQuality = new ControlQuality(redistributionList,
                LocalDate.now().plusDays(50));
        controlQuality.executeRedistribution(spaghetti);
        assertThat(shop.get().size(), is(1));
    }

    @Test
    public void whenQualityMore75ThenSetPriceWithDiscountAndSendToShop() {
        MeatFood meatFood = new MeatFood("Meat in french", LocalDate.now().plusDays(14),
                LocalDate.now(), 800, 250, true);
        Warehouse warehouse = new Warehouse();
        Shop shop = new Shop();
        Trash trash = new Trash();
        List<Redistribution> redistributionList = new ArrayList<>(List.of(warehouse, shop, trash));
        ControlQuality controlQuality = new ControlQuality(redistributionList,
                LocalDate.now().plusDays(11));
        controlQuality.executeRedistribution(meatFood);
        assertThat(shop.get().size(), is(1));
        assertThat(meatFood.getPrice(), is(550));
    }

    @Test
    public void whenQualityMore100ThenSendToTrash() {
        MilkFood yogurt = new MilkFood("Danissimo", LocalDate.now().plusDays(21),
                LocalDate.now(), 90, 20, "Danon");
        Warehouse warehouse = new Warehouse();
        Shop shop = new Shop();
        Trash trash = new Trash();
        List<Redistribution> redistributionList = new ArrayList<>(List.of(warehouse, shop, trash));
        ControlQuality controlQuality = new ControlQuality(redistributionList,
                LocalDate.now().plusDays(22));
        controlQuality.executeRedistribution(yogurt);
        assertThat(trash.get().size(), is(1));
    }

    @Test
    public void whenDistribute3Products() {
        Food cake = new Food("Moscow", LocalDate.now().plusDays(20),
                LocalDate.now(), 1200, 500);
        MacaroniFood spaghetti = new MacaroniFood("Bavette",
                LocalDate.now().plusDays(180), LocalDate.now(), 100, 10, 10);
        MeatFood meatFood = new MeatFood("Meat in french", LocalDate.now().plusDays(14),
                LocalDate.now(), 800, 250, true);
        MilkFood yogurt = new MilkFood("Danissimo", LocalDate.now().plusDays(21),
                LocalDate.now(), 90, 20, "Danon");
        Warehouse warehouse = new Warehouse();
        Shop shop = new Shop();
        Trash trash = new Trash();
        List<Redistribution> redistributionList = new ArrayList<>(List.of(warehouse, shop, trash));
        ControlQuality controlQuality1 = new ControlQuality(redistributionList,
                LocalDate.now().plusDays(4));
        ControlQuality controlQuality2 = new ControlQuality(redistributionList,
                LocalDate.now().plusDays(50));
        ControlQuality controlQuality3 = new ControlQuality(redistributionList,
                LocalDate.now().plusDays(11));
        ControlQuality controlQuality4 = new ControlQuality(redistributionList,
                LocalDate.now().plusDays(22));
        controlQuality1.executeRedistribution(cake);
        controlQuality2.executeRedistribution(spaghetti);
        controlQuality3.executeRedistribution(meatFood);
        controlQuality4.executeRedistribution(yogurt);
        assertThat(warehouse.get().size(), is(1));
        assertThat(shop.get().size(), is(2));
        assertThat(trash.get().size(), is(1));
    }

    @Test
    public void whenQualityLess25ThenSendToWarehouseThenSecondCheckAndSendToShop() {
        Food cake = new Food("Moscow", LocalDate.now().plusDays(20),
                LocalDate.now(), 1200, 500);
        Warehouse warehouse = new Warehouse();
        Shop shop = new Shop();
        Trash trash = new Trash();
        List<Redistribution> redistributionList = new ArrayList<>(List.of(warehouse, shop, trash));
        ControlQuality controlQuality1 = new ControlQuality(redistributionList,
                LocalDate.now().plusDays(4));
        controlQuality1.executeRedistribution(cake);
        assertThat(warehouse.get().size(), is(1));
        ControlQuality controlQuality2 = new ControlQuality(redistributionList,
                LocalDate.now().plusDays(10));
        controlQuality2.resort();
        assertThat(warehouse.get().size(), is(0));
        assertThat(shop.get().size(), is(1));
    }

    @Test
    public void whenQualityMore25AndLess75ThenSendToShopThenSecondCheckAndSendToShopWithDiscount() {
        MacaroniFood spaghetti = new MacaroniFood("Bavette",
                LocalDate.now().plusDays(180), LocalDate.now(), 100, 10, 10);
        Warehouse warehouse = new Warehouse();
        Shop shop = new Shop();
        Trash trash = new Trash();
        List<Redistribution> redistributionList = new ArrayList<>(List.of(warehouse, shop, trash));
        ControlQuality controlQuality1 = new ControlQuality(redistributionList,
                LocalDate.now().plusDays(50));
        controlQuality1.executeRedistribution(spaghetti);
        assertThat(shop.get().size(), is(1));
        assertThat(spaghetti.getPrice(), is(100));
        ControlQuality controlQuality2 = new ControlQuality(redistributionList,
                LocalDate.now().plusDays(170));
        controlQuality2.resort();
        assertThat(shop.get().size(), is(1));
        assertThat(spaghetti.getPrice(), is(90));
    }

    @Test
    public void whenQualityMore75ThenSetPriceWithDiscountAndSendToShopThenSecondCheckAndSendToTrash() {
        MeatFood meatFood = new MeatFood("Meat in french", LocalDate.now().plusDays(14),
                LocalDate.now(), 800, 250, true);
        Warehouse warehouse = new Warehouse();
        Shop shop = new Shop();
        Trash trash = new Trash();
        List<Redistribution> redistributionList = new ArrayList<>(List.of(warehouse, shop, trash));
        ControlQuality controlQuality1 = new ControlQuality(redistributionList,
                LocalDate.now().plusDays(11));
        controlQuality1.executeRedistribution(meatFood);
        assertThat(shop.get().size(), is(1));
        assertThat(meatFood.getPrice(), is(550));
        ControlQuality controlQuality2 = new ControlQuality(redistributionList,
                LocalDate.now().plusDays(15));
        controlQuality2.resort();
        assertThat(shop.get().size(), is(0));
        assertThat(trash.get().size(), is(1));
    }

    @Test
    public void whenDistribute3ProductsThenRedistribute() {
        Food cake = new Food("Moscow", LocalDate.now().plusDays(20),
                LocalDate.now(), 1200, 500);
        MacaroniFood spaghetti = new MacaroniFood("Bavette",
                LocalDate.now().plusDays(180), LocalDate.now(), 100, 10, 10);
        MeatFood meatFood = new MeatFood("Meat in french", LocalDate.now().plusDays(14),
                LocalDate.now(), 800, 250, true);
        MilkFood yogurt = new MilkFood("Danissimo", LocalDate.now().plusDays(21),
                LocalDate.now(), 90, 20, "Danon");
        Warehouse warehouse = new Warehouse();
        Shop shop = new Shop();
        Trash trash = new Trash();
        List<Redistribution> redistributionList = new ArrayList<>(List.of(warehouse, shop, trash));
        ControlQuality controlQuality1 = new ControlQuality(redistributionList,
                LocalDate.now().plusDays(4));
        ControlQuality controlQuality2 = new ControlQuality(redistributionList,
                LocalDate.now().plusDays(50));
        ControlQuality controlQuality3 = new ControlQuality(redistributionList,
                LocalDate.now().plusDays(11));
        ControlQuality controlQuality4 = new ControlQuality(redistributionList,
                LocalDate.now().plusDays(22));
        controlQuality1.executeRedistribution(cake);
        controlQuality2.executeRedistribution(spaghetti);
        controlQuality3.executeRedistribution(meatFood);
        controlQuality4.executeRedistribution(yogurt);
        assertThat(warehouse.get().size(), is(1));
        assertThat(shop.get().size(), is(2));
        assertThat(trash.get().size(), is(1));
        ControlQuality controlQuality5 = new ControlQuality(redistributionList,
                LocalDate.now().plusDays(100));
        controlQuality5.resort();
        assertThat(shop.get().size(), is(1));
        assertThat(trash.get().size(), is(3));
    }
}