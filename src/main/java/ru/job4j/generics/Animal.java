package ru.job4j.generics;

public class Animal {
    private final String name;
    private final int age;
    private final String color;

    public Animal(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    @Override
    public String toString() {
        return "name = '" + name + '\''
                + ", age = " + age
                + ", color = '" + color + '\'';
    }
}
