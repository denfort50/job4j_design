package ru.job4j.ood.lsp.parking;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

@Ignore
public class ParkingOfficeTest {

    @Ignore
    @Test
    public void when2PassengerCarsTo2PassengerCarSlotsAnd1TruckSlotsThenTrue() {
        Parking parking = new ParkingOffice(2, 1);
        Vehicle passengerCar1 = new PassengerCar();
        Vehicle passengerCar2 = new PassengerCar();
        parking.park(passengerCar1);
        assertTrue(parking.park(passengerCar2));
    }

    @Ignore
    @Test
    public void when2PassengerCarsTo1PassengerCarSlotsAnd1TruckSlotsThenFalse() {
        Parking parking = new ParkingOffice(1, 1);
        Vehicle passengerCar1 = new PassengerCar();
        Vehicle passengerCar2 = new PassengerCar();
        parking.park(passengerCar1);
        assertFalse(parking.park(passengerCar2));
    }

    @Ignore
    @Test
    public void when2TrucksTo1PassengerCarSlotsAnd2TruckSlotsThenTrue() {
        Parking parking = new ParkingOffice(1, 2);
        Vehicle truck1 = new Truck(2);
        Vehicle truck2 = new Truck(3);
        parking.park(truck1);
        assertTrue(parking.park(truck2));
    }

    @Ignore
    @Test
    public void when2TrucksTo2PassengerCarSlotsAnd1TruckSlotsThenTrue() {
        Parking parking = new ParkingOffice(2, 1);
        Vehicle truck1 = new Truck(3);
        Vehicle truck2 = new Truck(2);
        parking.park(truck1);
        assertTrue(parking.park(truck2));
    }

    @Ignore
    @Test
    public void when2TrucksTo2PassengerCarSlotsAnd1TruckSlotsThenFalse() {
        Parking parking = new ParkingOffice(2, 1);
        Vehicle truck1 = new Truck(2);
        Vehicle truck2 = new Truck(3);
        parking.park(truck1);
        assertFalse(parking.park(truck2));
    }

    @Ignore
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

    @Ignore
    @Test
    public void when3PassengerCarsAnd3TrucksTo3PassengerCarSlotsAnd2TruckSlotsThenFalse() {
        Parking parking = new ParkingOffice(3, 2);
        Vehicle passengerCar1 = new PassengerCar();
        Vehicle passengerCar2 = new PassengerCar();
        Vehicle passengerCar3 = new PassengerCar();
        Vehicle truck1 = new Truck(2);
        Vehicle truck2 = new Truck(3);
        Vehicle truck3 = new Truck(2);
        parking.park(passengerCar1);
        parking.park(passengerCar2);
        parking.park(passengerCar3);
        parking.park(truck1);
        parking.park(truck2);
        assertFalse(parking.park(truck3));
    }

    @Ignore
    @Test
    public void when3PassengerCarsAnd3TrucksTo8PassengerCarSlotsAnd1TruckSlotsThenTrue() {
        Parking parking = new ParkingOffice(8, 1);
        Vehicle passengerCar1 = new PassengerCar();
        Vehicle passengerCar2 = new PassengerCar();
        Vehicle passengerCar3 = new PassengerCar();
        Vehicle truck1 = new Truck(2);
        Vehicle truck2 = new Truck(2);
        Vehicle truck3 = new Truck(3);
        parking.park(passengerCar1);
        parking.park(passengerCar2);
        parking.park(passengerCar3);
        parking.park(truck1);
        parking.park(truck2);
        assertTrue(parking.park(truck3));
    }

    @Ignore
    @Test
    public void when3PassengerCarsAnd3TrucksTo7PassengerCarSlotsAnd1TruckSlotsThenFalse() {
        Parking parking = new ParkingOffice(7, 1);
        Vehicle passengerCar1 = new PassengerCar();
        Vehicle passengerCar2 = new PassengerCar();
        Vehicle passengerCar3 = new PassengerCar();
        Vehicle truck1 = new Truck(2);
        Vehicle truck2 = new Truck(2);
        Vehicle truck3 = new Truck(3);
        parking.park(passengerCar1);
        parking.park(passengerCar2);
        parking.park(passengerCar3);
        parking.park(truck1);
        parking.park(truck2);
        assertFalse(parking.park(truck3));
    }

    @Ignore
    @Test
    public void when3PassengerCarsAnd3TrucksTo7PassengerCarSlotsAnd1TruckSlotsThenTrue() {
        Parking parking = new ParkingOffice(7, 1);
        Vehicle passengerCar1 = new PassengerCar();
        Vehicle passengerCar2 = new PassengerCar();
        Vehicle passengerCar3 = new PassengerCar();
        Vehicle truck1 = new Truck(3);
        Vehicle truck2 = new Truck(2);
        Vehicle truck3 = new Truck(2);
        parking.park(passengerCar1);
        parking.park(passengerCar2);
        parking.park(passengerCar3);
        parking.park(truck1);
        parking.park(truck2);
        assertTrue(parking.park(truck3));
    }

}
