package ru.job4j.ood.isp;

public class Actor implements Employee {
    @Override
    public void sing() {
        System.out.println("okay");
    }

    @Override
    public void code() {
        System.out.println("null");
    }

    @Override
    public void build() {
        System.out.println("null");
    }

    @Override
    public void repair() {
        System.out.println("null");
    }
}
