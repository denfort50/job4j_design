package ru.job4j.jdbc;

import java.io.FileReader;
import java.io.Reader;
import java.sql.*;
import java.util.Properties;
import java.util.StringJoiner;

public class TableEditor implements AutoCloseable {
    private Connection connection;

    private final Properties properties;

    public TableEditor(Properties properties) throws ClassNotFoundException, SQLException {
        this.properties = properties;
        initConnection();
    }

    private void initConnection() throws ClassNotFoundException, SQLException {
        Class.forName(properties.getProperty("hibernate.connection.driver_class"));
        String url = properties.getProperty("hibernate.connection.url");
        String login = properties.getProperty("hibernate.connection.username");
        String password = properties.getProperty("hibernate.connection.password");
        connection = DriverManager.getConnection(url, login, password);
    }

    public void createStatement(String sql) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        }
    }

    public void createTable(String tableName) throws SQLException {
        createStatement(String.format("create table if not exists %s(%s);", tableName, "id serial primary key"));
    }

    public void dropTable(String tableName) throws SQLException {
        createStatement(String.format("drop table %s;", tableName));
    }

    public void addColumn(String tableName, String columnName, String type) throws SQLException {
        createStatement(String.format("alter table %s add column if not exists %s %s;", tableName, columnName, type));
    }

    public void dropColumn(String tableName, String columnName) throws SQLException {
        createStatement(String.format("alter table %s drop column %s;", tableName, columnName));
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) throws SQLException {
        createStatement(String.format("alter table %s rename column %s to %s;", tableName, columnName, newColumnName));
    }

    public static String getTableScheme(Connection connection, String tableName) throws Exception {
        var rowSeparator = "-".repeat(30).concat(System.lineSeparator());
        var header = String.format("%-15s|%-15s%n", "NAME", "TYPE");
        var buffer = new StringJoiner(rowSeparator, rowSeparator, rowSeparator);
        buffer.add(header);
        try (var statement = connection.createStatement()) {
            var selection = statement.executeQuery(String.format(
                    "select * from %s limit 1", tableName
            ));
            var metaData = selection.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                buffer.add(String.format("%-15s|%-15s%n",
                        metaData.getColumnName(i), metaData.getColumnTypeName(i))
                );
            }
        }
        return buffer.toString();
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        try (Reader in = new FileReader("app.properties")) {
            properties.load(in);
        }
        try (TableEditor tableEditor = new TableEditor(properties)) {

            tableEditor.createTable("apple");
            System.out.println(getTableScheme(tableEditor.connection, "apple"));

            tableEditor.addColumn("apple", "device", "varchar(255)");
            System.out.println(getTableScheme(tableEditor.connection, "apple"));

            tableEditor.addColumn("apple", "year", "date");
            System.out.println(getTableScheme(tableEditor.connection, "apple"));

            tableEditor.dropColumn("apple", "year");
            System.out.println(getTableScheme(tableEditor.connection, "apple"));

            tableEditor.renameColumn("apple", "device", "name");
            System.out.println(getTableScheme(tableEditor.connection, "apple"));

            tableEditor.dropTable("apple");
        }
    }
}
