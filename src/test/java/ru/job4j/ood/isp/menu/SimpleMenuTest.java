package ru.job4j.ood.isp.menu;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

public class SimpleMenuTest {

    public static final ActionDelegate STUB_ACTION = System.out::println;

    @Test
    public void whenAddThenReturnSame() {
        Menu menu = new SimpleMenu();
        menu.add(Menu.ROOT, "Сходить в магазин", STUB_ACTION);
        menu.add(Menu.ROOT, "Покормить собаку", STUB_ACTION);
        menu.add("Сходить в магазин", "Купить продукты", STUB_ACTION);
        menu.add("Купить продукты", "Купить хлеб", STUB_ACTION);
        menu.add("Купить продукты", "Купить молоко", STUB_ACTION);
        assertEquals(new Menu.MenuItemInfo(
                        "Сходить в магазин", List.of("Купить продукты"), STUB_ACTION, "1."),
                menu.select("Сходить в магазин").get());
        assertEquals(new Menu.MenuItemInfo(
                        "Купить продукты", List.of("Купить хлеб", "Купить молоко"), STUB_ACTION, "1.1."),
                menu.select("Купить продукты").get());
        assertEquals(new Menu.MenuItemInfo(
                        "Покормить собаку", List.of(), STUB_ACTION, "2."),
                menu.select("Покормить собаку").get());
        menu.forEach(i -> System.out.println(i.getNumber() + i.getName()));
    }

    @Test
    public void whenAddThenReturnSelect() {
        Menu menu = new SimpleMenu();
        menu.add(Menu.ROOT, "Сходить в магазин", STUB_ACTION);
        menu.add(Menu.ROOT, "Покормить собаку", STUB_ACTION);
        menu.add("Сходить в магазин", "Купить продукты", STUB_ACTION);
        menu.add("Купить продукты", "Купить хлеб", STUB_ACTION);
        menu.add("Купить продукты", "Купить молоко", STUB_ACTION);
        menu.add("Купить молоко", "Молоко 2,5% жирности", STUB_ACTION);
        menu.add("Купить молоко", "Молоко 4,0% жирности", STUB_ACTION);
        assertEquals(new Menu.MenuItemInfo(
                "Купить молоко", List.of("Молоко 2,5% жирности", "Молоко 4,0% жирности"), STUB_ACTION, "1.1.2."),
                menu.select("Купить молоко").get());
        assertEquals(new Menu.MenuItemInfo(
                        "Молоко 4,0% жирности", List.of(), STUB_ACTION, "1.1.2.2."),
                menu.select("Молоко 4,0% жирности").get());
    }

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void whenAddThenReturnListOnConsole() {
        Menu menu = new SimpleMenu();
        menu.add(Menu.ROOT, "Сходить в магазин", STUB_ACTION);
        menu.add(Menu.ROOT, "Покормить собаку", STUB_ACTION);
        menu.add("Сходить в магазин", "Купить продукты", STUB_ACTION);
        menu.add("Купить продукты", "Купить хлеб", STUB_ACTION);
        menu.add("Купить продукты", "Купить молоко", STUB_ACTION);
        menu.add("Купить молоко", "Молоко 2,5% жирности", STUB_ACTION);
        menu.add("Купить молоко", "Молоко 4,0% жирности", STUB_ACTION);
        SimpleMenuPrinter simpleMenuPrinter = new SimpleMenuPrinter();
        simpleMenuPrinter.print(menu);
        String ln = System.lineSeparator();
        assertEquals("1. Сходить в магазин" + ln
                        + "---- 1.1. Купить продукты" + ln
                        + "-------- 1.1.1. Купить хлеб" + ln
                        + "-------- 1.1.2. Купить молоко" + ln
                        + "------------ 1.1.2.1. Молоко 2,5% жирности" + ln
                        + "------------ 1.1.2.2. Молоко 4,0% жирности" + ln
                        + "2. Покормить собаку" + ln,
                outputStreamCaptor.toString());
    }

    @After
    public void tearDown() {
        System.setOut(standardOut);
    }
}
