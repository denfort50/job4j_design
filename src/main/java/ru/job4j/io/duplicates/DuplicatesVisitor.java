package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {

    Set<FileProperty> unique = new HashSet<>();
    Map<FileProperty, Path> duplicates = new HashMap<>();

    public Map<FileProperty, Path> getDuplicates() {
        return duplicates;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        FileProperty fileProperty = new FileProperty(file.toFile().length(), file.toFile().getName());
        if (unique.contains(fileProperty)) {
            duplicates.put(fileProperty, file.toAbsolutePath());
        }
        unique.add(fileProperty);
        return super.visitFile(file, attrs);
    }
}
