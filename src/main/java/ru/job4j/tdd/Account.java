package ru.job4j.tdd;

public interface Account {

    boolean save(Ticket ticket);

    void use(Ticket ticket);

    boolean get(Ticket ticket);
}
