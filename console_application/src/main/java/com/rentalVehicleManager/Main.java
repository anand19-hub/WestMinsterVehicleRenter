package com.rentalVehicleManager;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
	    RentalVehicleManager manager = new WestMinsterVehicleManager(50);
        boolean exit = false;
        while (!exit) {
            exit = runApplication(manager);
        }
    }

    public static boolean runApplication(RentalVehicleManager manager) throws IOException {
        boolean exit = false;

        System.out.println("To Print the list of All Vehicles press 1");
        System.out.println("To Filter the Vehicles press 2");
        System.out.println("To Add a new vehicle press 3");
        System.out.println("To Delete a vehicle press 4");
        System.out.println("To exit press 5");

        Scanner s = new Scanner (System.in);
        int taskToPerform = s.nextInt();

        switch (taskToPerform) {
            // printing vehicles
            case 1:
                manager.printAllVehicles();
                break;
            // FilteringVehicles
            case 2:
                // TODO
                break;
            // add new vehicle
            case 3:
                System.out.println("Press 1 if you want to add a Car");
                System.out.println("Press 2 if you want to add a Motor Bike");
                System.out.println("Press 3 if you want to add a Van");
                int vehicleType = s.nextInt();
                s.nextLine();
                System.out.println("Enter the plate number: ");
                String plateNumber = s.nextLine();

                System.out.println("Enter the make: ");
                String make = s.nextLine();

                switch (vehicleType) {
                    case 1:
                        Car c = new Car(plateNumber, make, "Car");
                        manager.addVehicle(c);
                        break;
                    case 2:
                        MotorBike b = new MotorBike(plateNumber, make, "Motor Bike");
                        manager.addVehicle(b);
                        break;
                    case 3:
                        Van v = new Van(plateNumber, make, "Van");
                        manager.addVehicle(v);
                        break;
                }
                break;
            // delete a vehicle by plate-number
            case 4:
                // TODO
                System.out.println("Enter the plate number of vehicle to delete: ");
                String delPlateNumber = s.nextLine();
                manager.deleteVehicle(delPlateNumber);
                break;
            // exit from application
            case 5:
                exit = true;
                break;
        }
        return exit;
    }
}
