package ru.job4j.ood.isp.menu;

import java.util.Iterator;

public class SimpleMenuPrinter implements MenuPrinter {
    @Override
    public void print(Menu menu) {
        Iterator<Menu.MenuItemInfo> iterator = menu.iterator();
        while (iterator.hasNext()) {
            Menu.MenuItemInfo temp = iterator.next();
            if (temp.getNumber().matches("^(\\d\\.)$")) {
                System.out.println(temp.getNumber() + " " + temp.getName());
            } else if (temp.getNumber().matches("^(\\d\\.){2}$")) {
                System.out.println("---- " + temp.getNumber() + " " + temp.getName());
            } else if (temp.getNumber().matches("^(\\d\\.){3}$")) {
                System.out.println("-------- " + temp.getNumber() + " " + temp.getName());
            } else if (temp.getNumber().matches("^(\\d\\.){4}$")) {
                System.out.println("------------ " + temp.getNumber() + " " + temp.getName());
            } else {
                System.out.println("---------------- " + temp.getNumber() + " " + temp.getName());
            }
        }
    }
}
