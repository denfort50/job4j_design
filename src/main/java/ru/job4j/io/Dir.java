package ru.job4j.io;

import java.io.File;
import java.util.Objects;

public class Dir {
    public static void main(String[] args) {
        File file = new File("c:\\projects");
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("Not exist %s", file.getAbsoluteFile()));
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(String.format("Not directory %s", file.getAbsoluteFile()));
        }
        System.out.printf("Directory name: %s | ", file.getName());
        System.out.printf("length: %s Kb%n ", file.length() / 1024);
        System.out.println("=== Internal files ===");
        for (File subfile : Objects.requireNonNull(file.listFiles())) {
            System.out.println("File name: " + subfile.getName() + " | length = " + subfile.length() / 1024 + " Kb");
        }
    }
}
