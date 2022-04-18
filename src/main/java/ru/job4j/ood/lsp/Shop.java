package ru.job4j.ood.lsp;

public class Shop {

    protected int reserves;

    public void sell() {
        if (reserves < 30) {
            throw new IllegalArgumentException("Reserves are running out. It's necessary to raise the price.");
        }
    }
}
