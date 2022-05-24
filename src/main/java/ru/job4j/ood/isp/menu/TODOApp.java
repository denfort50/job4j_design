package ru.job4j.ood.isp.menu;

import java.util.Optional;
import java.util.Scanner;

public class TODOApp {

    private final SimpleMenu tasks = new SimpleMenu();
    private final SimpleMenuPrinter tasksPrinter = new SimpleMenuPrinter();
    public static final ActionDelegate STUB_ACTION = System.out::println;

    public boolean add(String parentName, String childName, ActionDelegate actionDelegate) {
        return tasks.add(parentName, childName, actionDelegate);
    }

    public Optional<Menu.MenuItemInfo> select(String itemName) {
        return tasks.select(itemName);
    }

    public SimpleMenu getTasks() {
        return tasks;
    }

    public void showMenu(Menu menu) {
        tasksPrinter.print(tasks);
    }

    public void init() {
        boolean run = true;
        while (run) {
            String actions = "------------------------------" + System.lineSeparator()
                    + "1. Показать меню" + System.lineSeparator()
                    + "2. Добавить задание" + System.lineSeparator()
                    + "3. Взяться за задание" + System.lineSeparator()
                    + "4. Выход из приложения";
            System.out.println(actions + System.lineSeparator() + "Выберите действие:");
            Scanner scanner1 = new Scanner(System.in);
            int in = scanner1.nextInt();
            if (in < 1 || in > 4) {
                System.out.println("Некорректный выбор. Доступные опции: 1 - 4");
                continue;
            }
            if (in == 1) {
                showMenu(tasks);
            } else if (in == 2) {
                System.out.println("Введите название родительской задачи или root:");
                Scanner scanner2 = new Scanner(System.in);
                String parentName = scanner2.nextLine();
                System.out.println("Введите название дочерней задачи:");
                Scanner scanner3 = new Scanner(System.in);
                String childName = scanner3.nextLine();
                if ("root".equals(parentName)) {
                    add(SimpleMenu.ROOT, childName, STUB_ACTION);
                } else {
                    add(parentName, childName, STUB_ACTION);
                }
            } else if (in == 3) {
                System.out.println("Введите название задачи:");
                Scanner scanner4 = new Scanner(System.in);
                String name = scanner4.nextLine();
                select(name);
            } else {
                run = false;
            }
        }
    }

    public static void main(String[] args) {
        TODOApp todoApp = new TODOApp();
        todoApp.add(Menu.ROOT, "сделать зарядку", STUB_ACTION);
        todoApp.add(Menu.ROOT, "исправить задачу java", STUB_ACTION);
        todoApp.add(Menu.ROOT, "приготовить завтрак", STUB_ACTION);
        todoApp.add(Menu.ROOT, "сходить на работу", STUB_ACTION);
        todoApp.add(Menu.ROOT, "почитать книжку", STUB_ACTION);
        todoApp.init();
    }
}
