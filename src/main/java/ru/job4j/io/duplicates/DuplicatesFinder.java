package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DuplicatesFinder {
    public static void main(String[] args) throws IOException {
        DuplicatesVisitor visitor = new DuplicatesVisitor();
        Files.walkFileTree(Path.of("C:\\projects"), visitor);
        visitor.getDuplicates().forEach(obj -> System.out.println("Size: " + obj.getSize()
                + " | Name: " + obj.getName()));
    }
}
