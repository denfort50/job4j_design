package ru.job4j.tdd;

public class AccountCinema implements Account {

    @Override
    public boolean save(Ticket ticket) {
        return false;
    }

    @Override
    public void use(Ticket ticket) {
    }

    @Override
    public boolean get(Ticket ticket) {
        return false;
    }
}
