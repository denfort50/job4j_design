package ru.job4j.spammer;

import ru.job4j.jdbc.TableEditor;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ImportDB {

    private Properties cfg;
    private String dump;

    public ImportDB(Properties cfg, String dump) {
        this.cfg = cfg;
        this.dump = dump;
    }

    public List<User> load() throws IOException {
        List<User> users = new ArrayList<>();
        try (BufferedReader rd = new BufferedReader(new FileReader(dump))) {
            rd.lines().forEach(s -> {
                String[] values = s.split(";");
                users.add(new User(values[0], values[1]));
            });
        }
        return users;
    }

    public void save(List<User> users) throws ClassNotFoundException, SQLException {
        Class.forName(cfg.getProperty("hibernate.connection.driver_class"));
        try (Connection cnt = DriverManager.getConnection(
                cfg.getProperty("hibernate.connection.url"),
                cfg.getProperty("hibernate.connection.username"),
                cfg.getProperty("hibernate.connection.password")
        )) {
            for (User user : users) {
                try (PreparedStatement ps = cnt.prepareStatement("insert into users(name, email) values (?, ?)")) {
                    ps.setString(1, user.name);
                    ps.setString(2, user.email);
                    ps.execute();
                }
            }
        }
    }

    private static class User {
        String name;
        String email;

        public User(String name, String email) {
            this.name = name;
            this.email = email;
        }
    }


    public static void main(String[] args) throws Exception {
        Properties cfg = new Properties();
        try (FileInputStream in = new FileInputStream("./app.properties")) {
            cfg.load(in);
        }
        TableEditor tableEditor = new TableEditor(cfg);
        tableEditor.createTable("users");
        tableEditor.addColumn("users", "name", "varchar(255)");
        tableEditor.addColumn("users", "email", "varchar(255)");
        ImportDB db = new ImportDB(cfg, "./src/main/java/ru/job4j/spammer/dump.txt");
        db.save(db.load());
    }
}
