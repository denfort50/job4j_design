package ru.job4j.ood.isp.menu;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class TODOAppTest {

    public static final ActionDelegate STUB_ACTION = System.out::println;
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void whenAddTasksThenPrintOnConsole() {
        TODOApp todoApp = new TODOApp();
        todoApp.add(Menu.ROOT, "Сделать задачу на курсе java", STUB_ACTION);
        todoApp.add(Menu.ROOT, "Сходить на работу", STUB_ACTION);
        todoApp.add("Сходить на работу", "Дописать документацию CRE", STUB_ACTION);
        todoApp.add("Сходить на работу", "Дописать документацию AFS", STUB_ACTION);
        todoApp.add("Сходить на работу", "Разобраться с XSELL задачей", STUB_ACTION);
        todoApp.add(Menu.ROOT, "Сходить в магазин", STUB_ACTION);
        todoApp.print(todoApp);
        String ln = System.lineSeparator();
        assertEquals("1. Сделать задачу на курсе java" + ln
                + "2. Сходить на работу" + ln
                + "---- 2.1. Дописать документацию CRE" + ln
                + "---- 2.2. Дописать документацию AFS" + ln
                + "---- 2.3. Разобраться с XSELL задачей" + ln
                + "3. Сходить в магазин" + ln, outputStreamCaptor.toString());
    }

    @After
    public void tearDown() {
        System.setOut(standardOut);
    }
}
