package ru.job4j.generics;

public class Predator extends Animal {
    private final String favoriteMeal;

    public Predator(String name, int age, String color, String favoriteMeal) {
        super(name, age, color);
        this.favoriteMeal = favoriteMeal;
    }

    @Override
    public String toString() {
        return super.toString()
                + ", favoriteMeal = '" + favoriteMeal + '\'';
    }
}
