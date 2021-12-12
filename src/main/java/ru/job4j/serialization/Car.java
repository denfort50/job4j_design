package ru.job4j.serialization;

import java.util.Arrays;

public class Car {
    private final String model;
    private final boolean sportCar;
    private final int year;
    private final Engine engine;
    private final String[] pros;

    public Car(String model, boolean sportCar, int year, Engine engine, String[] pros) {
        this.model = model;
        this.sportCar = sportCar;
        this.year = year;
        this.engine = engine;
        this.pros = pros;
    }

    @Override
    public String toString() {
        return "Car{"
                + "model='" + model + '\''
                + ", sportCar=" + sportCar
                + ", volume=" + year
                + ", engine=" + engine
                + ", pros=" + Arrays.toString(pros)
                + '}';
    }
}
