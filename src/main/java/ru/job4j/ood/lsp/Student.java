package ru.job4j.ood.lsp;

public class Student {

    protected String diploma;
    protected String analyticalNote;

    public Student(String diploma, String analyticalNote) {
        this.diploma = diploma;
        this.analyticalNote = analyticalNote;
    }

    public boolean diplomaDefense() {
        if (!analyticalNote.isEmpty()) {
            throw new IllegalArgumentException("Analytical note must be done.");
        }
        return false;
    }
}
