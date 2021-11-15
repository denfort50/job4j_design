package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {

    Map<FileProperty, Path> uniques = new HashMap<>();
    Map<Path, FileProperty> duplicates = new LinkedHashMap<>();


    public Map<Path, FileProperty> getDuplicates() {
        return duplicates;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        FileProperty fileProperty = new FileProperty(file.toFile().length(), file.toFile().getName());
        if (uniques.containsKey(fileProperty) && !duplicates.containsValue(fileProperty)) {
            duplicates.put(uniques.get(fileProperty), fileProperty);
            duplicates.put(file.toAbsolutePath(), fileProperty);
        } else if (uniques.containsKey(fileProperty) && duplicates.containsValue(fileProperty)) {
            duplicates.put(file.toAbsolutePath(), fileProperty);
        }
        uniques.put(fileProperty, file.toAbsolutePath());
        return super.visitFile(file, attrs);
    }
}
