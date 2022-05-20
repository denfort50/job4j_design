package ru.job4j.ood.isp.menu;

import java.util.Iterator;

public class SimpleMenuPrinter implements MenuPrinter {

    private static final String INDENT = "----";

    @Override
    public void print(Menu menu) {
        Iterator<Menu.MenuItemInfo> iterator = menu.iterator();
        while (iterator.hasNext()) {
            Menu.MenuItemInfo temp = iterator.next();
            var dotCount = temp.getNumber().split("\\.").length - 1;
            for (int i = 0; i < dotCount; i++) {
                System.out.print(INDENT);
            }
            String out = temp.getNumber() + " " + temp.getName();
            if (dotCount == 0) {
                System.out.println(out);
            } else {
                System.out.println(" " + out);
            }
        }
    }
}
