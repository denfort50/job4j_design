package ru.job4j.ood.srp;

import java.util.List;

/**
 * Интерфейс Повар представляет собой абстрактного повара с набором обязанностей.
 */
public interface Cook {
    List<String> buyIngredients(List<String> names);
    void cook(List<String> ingredients);
}
