package ru.job4j.search;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.function.Predicate;

public class Searcher {

    public static void handle(Args arguments) throws IOException {
        String directory = arguments.get("d");
        String name = arguments.get("n");
        String typeOfSearch = arguments.get("t");
        String nameOfResultFile = arguments.get("o");
        validateArgs(directory, name, typeOfSearch, nameOfResultFile);
        Predicate<Path> pathPredicate = getSearchCondition(name, typeOfSearch);
        SearchFile searchFile = new SearchFile(pathPredicate);
        Files.walkFileTree(Path.of(directory), searchFile);
        List<Path> result = searchFile.getPaths();
        writeResultToFile(result, nameOfResultFile);
    }

    public static void validateArgs(String directory, String name, String typeOfSearch, String nameOfFileResult) {
        if (!new File(directory).isDirectory()) {
            throw new IllegalArgumentException("The entered path is not a directory.");
        }
        if (!"name".equals(typeOfSearch) && !"mask".equals(typeOfSearch) && !"regex".equals(typeOfSearch)) {
            throw new IllegalArgumentException("The type of search is specified incorrect.");
        }
        if ("name".equals(typeOfSearch) && !name.matches("[a-zA-Z]*\\.[a-z]+")) {
            throw new IllegalArgumentException("The name must contain letters and numbers.");
        }
        if ("mask".equals(typeOfSearch) && !name.contains("*.")) {
            throw new IllegalArgumentException("The mask must contain \"*.\".");
        }
        if ("regex".contains(typeOfSearch) && name.matches("[a-zA-Z]*\\.[a-z]+")) {
            throw new IllegalArgumentException("Use sin-taxis of regular expressions.");
        }
        if ("".equals(nameOfFileResult)) {
            throw new IllegalArgumentException("The name of result file is not specified.");
        }
    }

    public static Predicate<Path> getSearchCondition(String name, String typeOfSearch) {
        Predicate<Path> condition = null;
        if ("name".equals(typeOfSearch)) {
            condition = path -> name.equals(path.toFile().getName());
        }
        if ("mask".equals(typeOfSearch)) {
            String regex = name.replace(".", "\\.").replace("*", ".*");
            condition = path -> path.toFile().getName().matches(regex);
        }
        if ("regex".equals(typeOfSearch)) {
            condition = path -> path.toFile().getName().matches(name);
        }
        return condition;
    }

    public static void writeResultToFile(List<Path> pathList, String output) {
        try (FileOutputStream out = new FileOutputStream(output)) {
            for (Path path : pathList) {
                out.write((path.toAbsolutePath() + System.lineSeparator()).getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        if (args.length != 4) {
            throw new IllegalArgumentException("The program needs four arguments.");
        }
        Args arguments = Args.of(args);
        handle(arguments);
    }
}
