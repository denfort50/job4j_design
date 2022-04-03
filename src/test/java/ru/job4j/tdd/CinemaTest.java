package ru.job4j.tdd;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.nullValue;

import org.junit.Ignore;
import org.junit.Test;
import java.util.Calendar;
import java.util.List;

public class CinemaTest {

    @Ignore
    @Test
    public void whenBuy() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2022, Calendar.APRIL, 5, 23, 0);
        Ticket ticket = cinema.buy(account, 1, 10, date);
        assertThat(ticket, is(new Ticket3D()));
    }

    @Ignore
    @Test
    public void whenFind() {
        Cinema cinema = new Cinema3D();
        cinema.add(new Session3D());
        List<Session> sessions = cinema.find(session -> true);
        assertThat(sessions, is(List.of(new Session3D())));
    }

    @Ignore
    @Test
    public void whenAccountUseTicketOnlyOnce() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2022, Calendar.APRIL, 5, 23, 0);
        Ticket ticket3D = cinema.buy(account, 1, 10, date);
        account.save(ticket3D);
        account.use(ticket3D);
        assertThat(account.get(ticket3D), is(false));
    }

    @Ignore
    @Test
    public void whenTicketHasRightRowAndColumn() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2022, Calendar.APRIL, 5, 23, 0);
        Ticket ticket3D = cinema.buy(account, 1, 10, date);
        assertThat(ticket3D.getColumn(), is(10));
        assertThat(ticket3D.getRow(), is(1));
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenColumnNotExistThenException() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2022, Calendar.APRIL, 5, 23, 0);
        Ticket ticket = cinema.buy(account, 1, 250, date);
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenSessionIsNotAvailableForDateThenException() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Session session = new Session3D();
        cinema.add(session);
        Calendar date = Calendar.getInstance();
        date.set(2023, Calendar.APRIL, 5, 23, 0);
        Ticket ticket = cinema.buy(account, 1, 25, date);
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenSeatHasAlreadyBoughtThenException() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Session session = new Session3D();
        cinema.add(session);
        Calendar date = Calendar.getInstance();
        date.set(2022, Calendar.APRIL, 5, 23, 0);
        Ticket ticket1 = cinema.buy(account, 1, 20, date);
        Ticket ticket2 = cinema.buy(account, 1, 20, date);
    }
}
