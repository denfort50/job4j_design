package ru.job4j.ood.dip;

public class Phone {

    private int number;
    private String brand;
    private String model;
    private int batteryCapacity;

    public Phone(int number, String brand, String model, int batteryCapacity) {
        this.number = number;
        this.brand = brand;
        this.model = model;
        this.batteryCapacity = batteryCapacity;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }
}
