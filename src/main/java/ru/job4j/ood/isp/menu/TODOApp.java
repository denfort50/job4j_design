package ru.job4j.ood.isp.menu;

import java.util.Iterator;
import java.util.Optional;

public class TODOApp implements Menu, MenuPrinter {

    private final SimpleMenu tasks = new SimpleMenu();
    private final SimpleMenuPrinter tasksPrinter = new SimpleMenuPrinter();

    @Override
    public boolean add(String parentName, String childName, ActionDelegate actionDelegate) {
        return tasks.add(parentName, childName, actionDelegate);
    }

    @Override
    public Optional<MenuItemInfo> select(String itemName) {
        return tasks.select(itemName);
    }

    @Override
    public Iterator<MenuItemInfo> iterator() {
        return tasks.iterator();
    }

    @Override
    public void print(Menu menu) {
        tasksPrinter.print(tasks);
    }
}
