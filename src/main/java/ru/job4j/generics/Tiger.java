package ru.job4j.generics;

public class Tiger extends Predator {
    private final String typeOfSkin;

    public Tiger(String name, int age, String color, String favoriteMeal, String typeOfSkin) {
        super(name, age, color, favoriteMeal);
        this.typeOfSkin = typeOfSkin;
    }

    @Override
    public String toString() {
        return super.toString()
                + ", typeOfSkin = '" + typeOfSkin + '\'';
    }
}
