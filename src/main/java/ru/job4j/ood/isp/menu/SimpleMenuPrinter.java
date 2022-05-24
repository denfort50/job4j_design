package ru.job4j.ood.isp.menu;

public class SimpleMenuPrinter implements MenuPrinter {

    private static final String INDENT = "----";

    @Override
    public void print(Menu menu) {
        for (var temp : menu) {
            var dotCount = temp.getNumber().split("\\.").length - 1;
            for (int i = 0; i < dotCount; i++) {
                System.out.print(INDENT);
            }
            String out = temp.getNumber() + " " + temp.getName();
            System.out.println((dotCount == 0 ? "" : " ") + out);
        }
    }
}
