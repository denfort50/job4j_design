package ru.job4j.io;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArgsName {
    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        return values.get(key);
    }

    private void parse(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("String[] args is empty.");
        }
        Arrays.stream(args).forEach(s -> {
            String[] parts = s.split("=");
            if (parts.length == 1) {
                throw new IllegalArgumentException("One of argument is absent.");
            } else {
                values.put(parts[0].substring(1), parts[1]);
            }
        });
    }

        public static ArgsName of(String[]args) {
            ArgsName names = new ArgsName();
            names.parse(args);
            return names;
        }

    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(new String[] {"-Xmx=512", "-encoding=UTF-8"});
        System.out.println(jvm.get("Xmx"));

        ArgsName zip = ArgsName.of(new String[] {"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(zip.get("out"));
    }
}
