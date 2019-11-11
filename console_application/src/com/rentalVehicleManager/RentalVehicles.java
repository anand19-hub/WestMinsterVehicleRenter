package com.rentalVehicleManager;

import java.util.ArrayList;
import java.util.Scanner;

public class RentalVehicles implements VehicleCollection {
    private ArrayList<VehicleObjects> vehicleList;
    private int numVehicles;

    public RentalVehicles(int listLength) {
        this.numVehicles = listLength;
        vehicleList = new ArrayList<VehicleObjects>();
    }

    public void addVehicle(VehicleObjects vehicle) {
        if (vehicleList.size() < numVehicles) {
            vehicleList.add(vehicle);
        }
        else {
            System.out.println("No more parking slot available");
        }
    }

    public boolean runApplication() {
        boolean exit = false;
        System.out.println("To Add a new vehicle press 1");
        System.out.println("To print the list of the shapes press 2");
        System.out.println("To exit press 3");

        Scanner s = new Scanner (System.in);
        int taskToPerform = s.nextInt();

        switch (taskToPerform) {
            case 1:
                System.out.println("Press 1 if you want to add a Car");
                System.out.println("Press 2 if you want to add a Motor Bike");
                System.out.println("Press 3 if you want to add a Van");
                int vehicleType = s.nextInt();

                System.out.println("Enter the plate number: ");
                String plateNumber = s.nextLine();

                System.out.println("Enter the make: ");
                String make = s.nextLine();

                switch (vehicleType) {
                    case 1:
                        Car c = new Car(plateNumber, make, "Car");
                }
        }
        return exit;
    }
}
