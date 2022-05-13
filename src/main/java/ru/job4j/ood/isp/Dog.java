package ru.job4j.ood.isp;

public class Dog implements Friend {
    @Override
    public void help() {
        System.out.println("null");
    }

    @Override
    public void giveAttention() {
        System.out.println("okay");
    }

    @Override
    public void listen() {
        System.out.println("okay");
    }

    @Override
    public void talk() {
        System.out.println("null");
    }
}
