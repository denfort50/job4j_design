package ru.job4j.question;

import org.junit.Test;

import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.*;

public class AnalizeTest {

    @Test
    public void whenNotChanged() {
        User u1 = new User(1, "A");
        User u2 = new User(2, "B");
        User u3 = new User(3, "C");
        Set<User> previous = Set.of(u1, u2, u3);
        Set<User> current = Set.of(u1, u2, u3);
        assertThat(
                Analize.diff(previous, current),
                is(new Info(0, 0, 0))
        );
    }

    @Test
    public void whenOneChanged() {
        User u1 = new User(1, "A");
        User u2 = new User(2, "B");
        User u3 = new User(3, "C");
        Set<User> previous = Set.of(u1, u2, u3);
        Set<User> current = Set.of(u1, new User(2, "BB"), u3);
        assertThat(
                Analize.diff(previous, current),
                is(new Info(0, 1, 0))
        );
    }

    @Test
    public void whenOneDeleted() {
        User u1 = new User(1, "A");
        User u2 = new User(2, "B");
        User u3 = new User(3, "C");
        Set<User> previous = Set.of(u1, u2, u3);
        Set<User> current = Set.of(u1, u3);
        assertThat(
                Analize.diff(previous, current),
                is(new Info(0, 0, 1))
        );
    }

    @Test
    public void whenOneAdded() {
        User u1 = new User(1, "A");
        User u2 = new User(2, "B");
        User u3 = new User(3, "C");
        Set<User> previous = Set.of(u1, u2, u3);
        Set<User> current = Set.of(u1, u2, u3, new User(4, "D"));
        assertThat(
                Analize.diff(previous, current),
                is(new Info(1, 0, 0))
        );
    }

    @Test
    public void whenAllChanged() {
        User u1 = new User(1, "A");
        User u2 = new User(2, "B");
        User u3 = new User(3, "C");
        Set<User> previous = Set.of(u1, u2, u3);
        Set<User> current = Set.of(new User(1, "AA"), u2, new User(4, "D"));
        assertThat(
                Analize.diff(previous, current),
                is(new Info(1, 1, 1))
        );
    }

    @Test
    public void whenTwoChangedAndOneDeleted() {
        User u1 = new User(1, "A");
        User u2 = new User(2, "B");
        User u3 = new User(3, "C");
        Set<User> previous = Set.of(u1, u2, u3);
        Set<User> current = Set.of(new User(2, "BB"), new User(3, "CC"));
        assertThat(
                Analize.diff(previous, current),
                is(new Info(0, 2, 1))
        );
    }

    @Test
    public void whenTwoDeletedAndTwoAddedAndTwoChanged() {
        User u1 = new User(1, "A");
        User u2 = new User(2, "B");
        User u3 = new User(3, "C");
        User u4 = new User(4, "D");
        User u5 = new User(5, "E");
        User u6 = new User(6, "F");
        Set<User> previous = Set.of(u1, u2, u3, u4, u5, u6);
        Set<User> current = Set.of(
                new User(1, "AA"), new User(2, "BB"), u5,
                u6, new User(7, "G"), new User(8, "H"));
        assertThat(
                Analize.diff(previous, current),
                is(new Info(2, 2, 2))
        );
    }

}
