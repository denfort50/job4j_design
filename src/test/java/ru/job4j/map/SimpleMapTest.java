package ru.job4j.map;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

public class SimpleMapTest {

    @Test
    public void whenPutTrue() {
        Map<String, Integer> mapOfFriends = new SimpleMap<>();
        assertThat(mapOfFriends.put("Denis", 26), is(true));
    }

    @Test
    public void whenPutFalse() {
        Map<String, Integer> mapOfFriends = new SimpleMap<>();
        mapOfFriends.put("Denis", 26);
        mapOfFriends.put("Alexandr", 26);
        mapOfFriends.put("Leonid", 27);
        mapOfFriends.put("Ekaterina", 29);
        mapOfFriends.put("Yriy", 25);
        mapOfFriends.put("Sergey", 26);
        assertThat(mapOfFriends.put("Vladislav", 25), is(false));
    }

    @Test
    public void whenPutThenExpand() {
        Map<String, Integer> mapOfFriends = new SimpleMap<>();
        mapOfFriends.put("Denis", 26);
        mapOfFriends.put("Alexandr", 26);
        mapOfFriends.put("Leonid", 27);
        mapOfFriends.put("Ekaterina", 29);
        mapOfFriends.put("Yriy", 25);
        assertThat(mapOfFriends.getCapacity(), is(8));
        mapOfFriends.put("Sergey", 26);
        assertThat(mapOfFriends.getCapacity(), is(16));
    }

    @Test
    public void whenGetValue() {
        Map<String, Integer> mapOfFriends = new SimpleMap<>();
        mapOfFriends.put("Denis", 26);
        assertThat(mapOfFriends.get("Denis"), is(26));
    }

    @Test
    public void whenGetNull() {
        Map<String, Integer> mapOfFriends = new SimpleMap<>();
        assertThat(mapOfFriends.get("Denis"), is(nullValue()));
    }

    @Test
    public void whenRemoveTrue() {
        Map<String, Integer> mapOfFriends = new SimpleMap<>();
        mapOfFriends.put("Alexandr", 26);
        assertThat(mapOfFriends.remove("Alexandr"), is(true));
        assertThat(mapOfFriends.get("Alexandr"), is(nullValue()));
    }

    @Test
    public void whenRemoveFalse() {
        Map<String, Integer> mapOfFriends = new SimpleMap<>();
        assertThat(mapOfFriends.remove("Denis"), is(false));
    }

    @Test
    public void whenGetIteratorFromEmptySimpleMapThenHasNextReturnFalse() {
        Map<String, Integer> mapOfFriends = new SimpleMap<>();
        Iterator<String> iterator = mapOfFriends.iterator();
        assertThat(iterator.hasNext(), is(false));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenGetIteratorFromEmptySimpleMapThenNextThrowException() {
        Map<String, Integer> mapOfFriends = new SimpleMap<>();
        Iterator<String> iterator = mapOfFriends.iterator();
        iterator.next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenIncreaseSimpleMapWhileIterationThenException() {
        Map<String, Integer> mapOfFriends = new SimpleMap<>();
        Iterator<String> iterator = mapOfFriends.iterator();
        mapOfFriends.put("Alexandr", 26);
        assertThat(iterator.next(), is("Alexandr"));
    }

    @Test
    public void whenCheckIterator() {
        Map<String, Integer> mapOfFriends = new SimpleMap<>();
        mapOfFriends.put("Leonid", 27);
        mapOfFriends.put("Ekaterina", 29);
        Iterator<String> iterator = mapOfFriends.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is("Leonid"));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is("Ekaterina"));
        assertThat(iterator.hasNext(), is(false));
    }

}
