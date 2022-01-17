package ru.job4j.search;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Args {
    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        return values.get(key);
    }

    private void parse(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("String[] args is empty.");
        }
        Arrays.stream(args).forEach(s -> {
            if (!s.startsWith("-") || s.startsWith("-=") || s.contains("==") || !s.contains("=") || s.endsWith("=")) {
                throw new IllegalArgumentException("Arguments don't match the template.");
            }
            String[] parts = s.split("=");
            values.put(parts[0].substring(1), parts[1]);
        });
    }

    public static Args of(String[] args) {
        Args names = new Args();
        names.parse(args);
        return names;
    }
}
