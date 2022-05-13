package ru.job4j.ood.isp;

public class Plane implements Transport {
    @Override
    public void drive() {
        System.out.println("null");
    }

    @Override
    public void ride() {
        System.out.println("null");
    }

    @Override
    public void fly() {
        System.out.println("okay");
    }

    @Override
    public void sail() {
        System.out.println("null");
    }
}
