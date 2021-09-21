package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIt implements Iterator<Integer> {
    private final int[][] data;
    private int row = 0;
    private int column = 0;

    public MatrixIt(int[][] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        boolean result = false;
        if (data.length != 0 && data[row].length != 0) {
            result = column < data[row].length;
            if (!result) {
                while (row < data.length) {
                    row++;
                    column = 0;
                    result = row < data.length && column < data[row].length;
                    if (result) {
                        break;
                    }
                }
            }
        } else {
            while (row < data.length) {
                row++;
                column = 0;
                result = row < data.length && column < data[row].length;
                if (result) {
                    break;
                }
            }
        }
        return result;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[row][column++];

    }
}
