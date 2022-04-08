package ru.job4j.ood.srp;

/**
 * Интерфейс представляет собой абстрактный Парсер, который обладает функционалом парсить и отправлять данные.
 */
public interface Parser {
    String parse(String url);
    void send(String parsedString);
}
