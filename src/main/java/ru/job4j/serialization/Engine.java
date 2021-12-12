package ru.job4j.serialization;

public class Engine {
    private final String name;
    private final double volume;
    private final int horsePowers;

    public Engine(String name, double volume, int horsePowers) {
        this.name = name;
        this.volume = volume;
        this.horsePowers = horsePowers;
    }

    @Override
    public String toString() {
        return "Engine{"
                + "name='" + name + '\''
                + ", volume=" + volume
                + ", horsePowers=" + horsePowers
                + '}';
    }
}
