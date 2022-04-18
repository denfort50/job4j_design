package ru.job4j.ood.lsp;

public class Postgraduate extends  Student {
    public Postgraduate(String diploma, String analyticalNote) {
        super(diploma, analyticalNote);
    }

    @Override
    public boolean diplomaDefense() {
        return false;
    }
}
