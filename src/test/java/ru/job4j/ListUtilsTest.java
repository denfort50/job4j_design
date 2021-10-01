package ru.job4j;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class ListUtilsTest {

    @Test
    public void whenAddBefore() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 1, 2);
        assertThat(input, is(Arrays.asList(1, 2, 3)));
    }

    @Test
    public void whenAddBeforeFirst() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 0, 2);
        assertThat(input, is(Arrays.asList(2, 1, 3)));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddBeforeWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 3, 2);
    }

    @Test
    public void whenAddAfterLast() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2));
        ListUtils.addAfter(input, 2, 3);
        assertThat(input, is(Arrays.asList(0, 1, 2, 3)));
    }

    @Test
    public void whenRemoveIf() {
        List<Integer> input = new ArrayList<>(Arrays.asList(-3, -2, -1, 0, 1, 2, 3));
        ListUtils.removeIf(input, x -> x < 0);
        assertThat(input, is(Arrays.asList(0, 1, 2, 3)));
    }

    @Test
    public void whenReplaceIf() {
        List<Integer> input = new ArrayList<>(Arrays.asList(-3, -2, -1, 0, 1, 2, 3));
        ListUtils.replaceIf(input, x -> x < 0, 0);
        assertThat(input, is(Arrays.asList(0, 0, 0, 0, 1, 2, 3)));
    }

    @Test
    public void whenRemoveAll() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5));
        List<Integer> elements = new ArrayList<>(Arrays.asList(0, 3, 4, 5));
        ListUtils.removeAll(input, elements);
        assertThat(input, is(Arrays.asList(1, 2)));
    }

}
