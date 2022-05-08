package ru.job4j.ood.lsp.parking;

import java.util.ArrayList;
import java.util.List;

public class ParkingOffice implements Parking {

    private int passengerCarSlotsAmount;
    private int truckSlotsAmount;
    private final List<Vehicle> passengerCarSlots;
    private final List<Vehicle> truckSlots;

    public ParkingOffice(int passengerCarSlotsAmount, int truckSlotsAmount) {
        this.passengerCarSlotsAmount = passengerCarSlotsAmount;
        this.truckSlotsAmount = truckSlotsAmount;
        this.passengerCarSlots = new ArrayList<>(passengerCarSlotsAmount);
        this.truckSlots = new ArrayList<>(truckSlotsAmount);
    }


    @Override
    public boolean park(Vehicle vehicle) {
        boolean result = false;
        if (vehicle.getSize() == PassengerCar.SIZE && passengerCarSlotsAmount > 0) {
            result = passengerCarSlots.add(vehicle);
            passengerCarSlotsAmount--;
        } else if (vehicle.getSize() > PassengerCar.SIZE && truckSlotsAmount > 0) {
            result = truckSlots.add(vehicle);
            truckSlotsAmount--;
        } else if (vehicle.getSize() > PassengerCar.SIZE && passengerCarSlotsAmount >= vehicle.getSize()) {
            result = passengerCarSlots.add(vehicle);
            passengerCarSlotsAmount -= vehicle.getSize();
        }
        return result;
    }
}
