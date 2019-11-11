package com.rentalVehicleManager;

public class Main {

    public static void main(String[] args) {
	    VehicleCollection vehicle = new RentalVehicles(50);
        boolean exit = false;
        while (!exit) {
            exit = vehicle.runApplication();
        }
    }
}
