package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LogFilter {
    public static List<String> filter(String file) {
        List<String> result = new ArrayList<>();
        try {
            BufferedReader in = new BufferedReader(new FileReader(file));
            List<String> strings = in.lines().toList();
            result = strings.stream().filter(s -> {
                String[] values = s.split(" ");
                return "404".equals(values[values.length - 2]);
            }).collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> log = filter("log.txt");
        log.forEach(System.out::println);
    }
}
