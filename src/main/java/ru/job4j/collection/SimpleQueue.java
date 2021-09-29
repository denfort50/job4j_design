package ru.job4j.collection;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();
    int sizeIn = 0;
    int sizeOut = 0;

    public T poll() {
        while (sizeIn != 0) {
            out.push(in.pop());
            sizeOut++;
            sizeIn--;
        }
        T value = out.pop();
        sizeOut--;
        while (sizeOut != 0) {
            in.push(out.pop());
            sizeIn++;
            sizeOut--;
        }
        return value;
    }

    public void push(T value) {
        in.push(value);
        sizeIn++;
    }
}
