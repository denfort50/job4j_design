package ru.job4j.io;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EvenNumberFile {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("even.txt")) {
            StringBuilder text = new StringBuilder();
            int read;
            while ((read = in.read()) != -1) {
                text.append((char) read);
            }
            List<Integer> listOfNumbers = new ArrayList<>();
            Arrays.stream(text.toString().split(System.lineSeparator()))
                    .forEach(s -> listOfNumbers.add(Integer.parseInt(s)));
            listOfNumbers.forEach(number -> {
                if (number % 2 == 0) {
                    System.out.println(number + " – четное число");
                } else {
                    System.out.println(number + " – нечетное число");
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
