package ru.job4j.set;

import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleSetTest {

    @Test
    public void whenAddNonNull() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(1));
        assertTrue(set.contains(1));
        assertFalse(set.add(1));
    }

    @Test
    public void whenAddNull() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(null));
        assertTrue(set.contains(null));
        assertFalse(set.add(null));
    }

    @Test
    public void whenWithoutAdd() {
        Set<Integer> set = new SimpleSet<>();
        assertFalse(set.contains(1));
        assertFalse(set.contains(null));
    }

    @Test
    public void whenAddNonNullAndNull() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(1));
        assertTrue(set.contains(1));
        assertTrue(set.add(null));
        assertTrue(set.contains(null));
        assertTrue(set.add(3));
        assertTrue(set.contains(3));
        assertFalse(set.add(3));
        assertFalse(set.add(null));
    }


}
