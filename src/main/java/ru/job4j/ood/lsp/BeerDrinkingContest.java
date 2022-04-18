package ru.job4j.ood.lsp;

public class BeerDrinkingContest extends Contest {

    protected int age;

    @Override
    public void compete() {
        if (age < 18) {
            throw new IllegalArgumentException("Age is not valid.");
        }
        super.compete();
    }
}
