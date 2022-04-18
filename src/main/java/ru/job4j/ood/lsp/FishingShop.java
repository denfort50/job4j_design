package ru.job4j.ood.lsp;

public class FishingShop extends Shop {

    protected int reserves;

    @Override
    public void sell() {
        if (reserves < 10) {
            throw new IllegalArgumentException("Reserves are running out. It's necessary to raise the price.");
        }
    }
}
