package com.rentalVehicleManager;

abstract class Vehicle {
    public String type;
    public String plateNumber;
    public String make;

    public Vehicle(String plateNumber, String make, String type) {
        this.plateNumber = plateNumber;
        this.make = make;
        this.type = type;
    }
}
