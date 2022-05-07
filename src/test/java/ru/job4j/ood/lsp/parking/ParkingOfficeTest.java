package ru.job4j.ood.lsp.parking;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class ParkingOfficeTest {

    @Test
    public void when2TrucksTo1PassengerCarSlotsAnd1TruckSlotsThenTrue() {
        Parking parking = new ParkingOffice(2, 1);
        Vehicle truck1 = new Truck(3);
        Vehicle truck2 = new Truck(2);
        parking.park(truck1);
        assertTrue(parking.park(truck2));
    }

    @Test
    public void when2TrucksTo1PassengerCarSlotsAnd1TruckSlotsThenFalse() {
        Parking parking = new ParkingOffice(2, 1);
        Vehicle truck1 = new Truck(2);
        Vehicle truck2 = new Truck(3);
        parking.park(truck1);
        assertFalse(parking.park(truck2));
    }

    @Test
    public void when3PassengerCarsTo2PassengerCarSlotsAnd1TruckSlotsThenTrue() {
        Parking parking = new ParkingOffice(2, 1);
        Vehicle passengerCar1 = new PassengerCar();
        Vehicle passengerCar2 = new PassengerCar();
        Vehicle passengerCar3 = new PassengerCar();
        parking.park(passengerCar1);
        parking.park(passengerCar2);
        assertTrue(parking.park(passengerCar3));
    }

    @Test
    public void when3PassengerCarsTo1PassengerCarSlotsAnd2TruckSlotsThenTrue() {
        Parking parking = new ParkingOffice(1, 2);
        Vehicle passengerCar1 = new PassengerCar();
        Vehicle passengerCar2 = new PassengerCar();
        Vehicle passengerCar3 = new PassengerCar();
        parking.park(passengerCar1);
        parking.park(passengerCar2);
        assertTrue(parking.park(passengerCar3));
    }


    @Test
    public void when3PassengerCarsAnd2TrucksTo3PassengerCarSlotsAnd2TruckSlotsThenTrue() {
        Parking parking = new ParkingOffice(3, 2);
        Vehicle passengerCar1 = new PassengerCar();
        Vehicle passengerCar2 = new PassengerCar();
        Vehicle passengerCar3 = new PassengerCar();
        Vehicle truck1 = new Truck(2);
        Vehicle truck2 = new Truck(3);
        parking.park(passengerCar1);
        parking.park(passengerCar2);
        parking.park(truck1);
        assertTrue(parking.park(passengerCar3));
        assertTrue(parking.park(truck2));
    }

    @Test
    public void when3PassengerCarsAnd2TrucksTo8PassengerCarSlotsThenTrue() {
        Parking parking = new ParkingOffice(8, 0);
        Vehicle passengerCar1 = new PassengerCar();
        Vehicle passengerCar2 = new PassengerCar();
        Vehicle passengerCar3 = new PassengerCar();
        Vehicle truck1 = new Truck(2);
        Vehicle truck2 = new Truck(3);
        parking.park(passengerCar1);
        parking.park(passengerCar2);
        parking.park(passengerCar3);
        parking.park(truck1);
        assertTrue(parking.park(truck2));
    }

    @Test
    public void when3PassengerCarsAnd2TrucksTo7PassengerCarSlotsThenFalse() {
        Parking parking = new ParkingOffice(7, 0);
        Vehicle passengerCar1 = new PassengerCar();
        Vehicle passengerCar2 = new PassengerCar();
        Vehicle passengerCar3 = new PassengerCar();
        Vehicle truck1 = new Truck(2);
        Vehicle truck2 = new Truck(3);
        parking.park(passengerCar1);
        parking.park(passengerCar2);
        parking.park(passengerCar3);
        parking.park(truck1);
        assertFalse(parking.park(truck2));
    }

    @Test
    public void when3PassengerCarsAnd2TrucksTo2PassengerCarSlotsAnd3TruckSlotsThenTrue() {
        Parking parking = new ParkingOffice(2, 3);
        Vehicle passengerCar1 = new PassengerCar();
        Vehicle passengerCar2 = new PassengerCar();
        Vehicle passengerCar3 = new PassengerCar();
        Vehicle truck1 = new Truck(2);
        Vehicle truck2 = new Truck(3);
        parking.park(passengerCar1);
        parking.park(passengerCar2);
        parking.park(passengerCar3);
        parking.park(truck1);
        assertTrue(parking.park(truck2));
    }

    @Test
    public void when3PassengerCarsAnd2TrucksTo1PassengerCarSlotsAnd3TruckSlotsThenFalse() {
        Parking parking = new ParkingOffice(1, 3);
        Vehicle passengerCar1 = new PassengerCar();
        Vehicle passengerCar2 = new PassengerCar();
        Vehicle passengerCar3 = new PassengerCar();
        Vehicle truck1 = new Truck(2);
        Vehicle truck2 = new Truck(3);
        parking.park(truck1);
        parking.park(truck2);
        parking.park(passengerCar1);
        parking.park(passengerCar2);
        assertFalse(parking.park(passengerCar3));
    }

}
