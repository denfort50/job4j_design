package ru.job4j.io;

import java.io.*;
import java.util.Objects;

public class Analysis {
    public void unavailable(String source, String target) {
        try (BufferedReader in = new BufferedReader(new FileReader(source));
             PrintWriter out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(target)))) {
            String start = "";
            String stop = "";
            while (in.ready()) {
                String[] parts = in.readLine().split(" ");
                if ((parts[0].equals("400") || parts[0].equals("500")) && start.isEmpty()) {
                    start = parts[1];
                } else if (!Objects.equals(start, "") && (parts[0].equals("200") || parts[0].equals("300"))) {
                    stop = parts[1];
                }
                if (!Objects.equals(start, "") && !Objects.equals(stop, "")) {
                    System.out.println(start + " " + stop);
                    out.println(start + ";" + stop);
                    start = "";
                    stop = "";
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String source = "./data/server.log";
        String target = "./data/unavailable.csv";
        Analysis analysis = new Analysis();
        analysis.unavailable(source, target);
    }
}
