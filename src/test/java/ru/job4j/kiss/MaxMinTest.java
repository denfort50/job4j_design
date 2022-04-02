package ru.job4j.kiss;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

public class MaxMinTest {

    @Test
    public void maxTest() {
        ArrayList<Integer> value = new ArrayList<>(List.of(5, 7, 3, 4, 6, 8, 1, 9, 2));
        Comparator<Integer> comparator = Comparator.comparingInt(o -> o);
        MaxMin maxMin = new MaxMin();
        int result = 9;
        assertThat(result, is(maxMin.max(value, comparator)));
    }

    @Test
    public void minTest() {
        ArrayList<Integer> value = new ArrayList<>(List.of(5, 7, 3, 4, 6, 8, 1, 9, 2));
        Comparator<Integer> comparator = Comparator.comparingInt(o -> o);
        MaxMin maxMin = new MaxMin();
        int result = 1;
        assertThat(result, is(maxMin.min(value, comparator)));
    }
}