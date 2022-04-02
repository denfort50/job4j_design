package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;

public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        return regularize(value, comparator);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return regularize(value, comparator.reversed());
    }

    public <T> T regularize(List<T> value, Comparator<T> comparator) {
        T result = value.get(0);
        for (T element : value) {
            int comp = comparator.compare(element, result);
            if (comp > 0) {
                result = element;
            }
        }
        return result;
    }
}
