package ru.job4j.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.*;
import java.util.stream.Collectors;

public class CSVReader {
    public static void handle(ArgsName argsName) throws Exception {
        String path = argsName.get("path");
        String delimiter = argsName.get("delimiter");
        String output = argsName.get("out");
        ArrayList<String> filter = new ArrayList<>(List.of(argsName.get("filter").split(",")));
        if ("".equals(path) || "".equals(delimiter) || "".equals(output) || filter.isEmpty()) {
            throw new IllegalArgumentException("Some arguments are absent.");
        }
        List<String> lines = new ArrayList<>();
        Scanner scanner = new Scanner(new FileInputStream(path));
        while (scanner.hasNextLine()) {
            lines.add(scanner.nextLine());
        }
        List<List<String>> data = lines.stream()
                .map(s -> Arrays.stream(s.split(delimiter)).toList()).collect(Collectors.toList());
        List<Integer> requiredColumns = new ArrayList<>();
        filter.forEach(s -> requiredColumns.add(data.get(0).indexOf(s)));
        List<String> result = data.stream()
                .map(s -> requiredColumns.stream()
                        .map(s::get).collect(Collectors.joining(delimiter))).collect(Collectors.toList());
        result.forEach(System.out::println);
        String ln = System.lineSeparator();
        try (FileOutputStream out = new FileOutputStream(output)) {
            for (String s : result) {
                out.write((s + ln).getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        ArgsName argsName = ArgsName.of(args);
        handle(argsName);
    }
}
