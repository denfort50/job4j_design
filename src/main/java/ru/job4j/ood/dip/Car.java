package ru.job4j.ood.dip;

public class Car {

    private Engine internalCombustionEngine = new Engine();
    private Engine electricEngine = new Engine();

    public void useGasoline(Engine internalCombustionEngine) {
    }

    public void useElectro(Engine electricEngine) {
    }
}
