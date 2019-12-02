package com.rentalVehicleManager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
	    RentalVehicleManager manager = new WestMinsterVehicleManager(50);
        runApplication(manager);
    }

    public static void runApplication(RentalVehicleManager manager) throws IOException {
        boolean exit = false;
        boolean invalidInput = false;

        while (!invalidInput && !exit) {
            Scanner s = new Scanner (System.in);

            System.out.println("To Print the list of All Vehicles press 1");
            System.out.println("To Filter the Vehicles press 2");
            System.out.println("To Add a new vehicle press 3");
            System.out.println("To Delete a vehicle press 4");
            System.out.println("To open the User Application press 5");
            System.out.println("To exit press 6");

            String taskToPerform = s.nextLine();

            switch (taskToPerform) {
                // printing vehicles
                case "1":
                    manager.printAllVehicles();
                    break;
                // FilteringVehicles
                case "2":
                    String filterType;
                    do {
                        System.out.println("Press 1 if you want to filter by Type");
                        System.out.println("Press 2 if you want to filter by Make");
                        filterType = s.nextLine();
                    }while (!filterType.equals("1") && !filterType.equals("2"));

                    switch (filterType) {
                        case "1":
                            String type;
                            do {
                                System.out.println("Press 1 if you want to filter only Car");
                                System.out.println("Press 2 if you want to filter only Motor Bike");
                                System.out.println("Press 3 if you want to filter only Van");
                                type = s.nextLine();
                            } while (!type.equals("1") && !type.equals("2") && !type.equals("3"));

                            switch (type) {
                                case "1":
                                    manager.filterVehicles("type", "Car");
                                    break;
                                case "2":
                                    manager.filterVehicles("type", "Motor Bike");
                                    break;
                                case "3":
                                    manager.filterVehicles("type", "Van");
                                    break;
                                default:
                                    System.out.println("Invalid input");
                                    break;
                            }
                            break;
                        case "2":
                            System.out.println("Enter the make you want to filter: ");
                            String make = s.nextLine();

                            manager.filterVehicles("make", make);
                            break;
                        default:
                            System.out.println("Invalid input");
                            break;
                    }
                    break;
                // add new vehicle
                case "3":
                    String vehicleType;
                    do {
                        System.out.println("Press 1 if you want to add a Car");
                        System.out.println("Press 2 if you want to add a Motor Bike");
                        System.out.println("Press 3 if you want to add a Van");
                        vehicleType = s.nextLine();
                    } while (!vehicleType.equals("1") && !vehicleType.equals("2") && !vehicleType.equals("3"));

                    System.out.println("Enter the plate number: ");
                    String plateNumber = s.nextLine();

                    System.out.println("Enter the make: ");
                    String make = s.nextLine();

                    boolean amountTypeError = true;
                    double rentPerDay = 0.00;

                    while(amountTypeError) {
                        try {
                            System.out.println("Enter the Rent per Day: ");
                            rentPerDay = s.nextDouble();
                            amountTypeError = false;
                        }catch (InputMismatchException ex) {
                            System.out.println("Please enter a valid amount to proceed");
                            s.next();
                        }
                    }

                    s.nextLine();
                    System.out.println("Enter a short Description: ");
                    String description = s.nextLine();

                    boolean imagePathError = true;
                    byte[] image = new byte[0];

                    while (imagePathError) {
                        System.out.println("Enter the image path: ");
                        String path = s.nextLine();
                        try {
                            image = Files.readAllBytes(Paths.get(path));
                            imagePathError = false;
                        } catch (NoSuchFileException e) {
                            System.out.println("Sorry, The path you entered is incorrect!");
                        }
                    }

                    switch (vehicleType) {
                        case "1":
                            String ad = "";
                            while (!ad.toUpperCase().equals("Y") && !ad.toUpperCase().equals("N") && !ad.toUpperCase().equals("YES") && !ad.toUpperCase().equals("NO")) {
                                System.out.println("Is this an Aerodynamic Car? (y/n): ");
                                ad = s.nextLine();
                            }
                            boolean aeroDynamic = ad.toUpperCase().equals("Y") || ad.toUpperCase().equals("YES");

                            System.out.println("Airbag makers: ");
                            String carAirbagMakers = s.nextLine();

                            Car c = new Car();

                            c.setType("Car");
                            c.setMake(make);
                            c.setPlateNumber(plateNumber);
                            c.setRentPerDay(rentPerDay);
                            c.setDescription(description);
                            c.setImage(image);
                            c.setAirbagMakers(carAirbagMakers);
                            c.setAeroDynamic(aeroDynamic);

                            manager.addVehicle(c);
                            break;
                        case "2":
                            System.out.println("Enter the type of Helmet : ");
                            String typeOfHelmet = s.nextLine();

                            boolean tankSizeError = true;
                            double gasTankSize = 0.0;
                            while(tankSizeError) {
                                try {
                                    System.out.println("Enter the size of Gas Tank : ");
                                    gasTankSize = s.nextDouble();
                                    tankSizeError = false;
                                }catch (InputMismatchException e) {
                                    System.out.println("Gas tank size should be entered in tonne (ie: 1 or 1.5 or 3.2).");
                                    s.next();
                                }
                            }

                            MotorBike b = new MotorBike();

                            b.setType("Motor Bike");
                            b.setMake(make);
                            b.setPlateNumber(plateNumber);
                            b.setRentPerDay(rentPerDay);
                            b.setDescription(description);
                            b.setImage(image);
                            b.setTypeOfHelmet(typeOfHelmet);
                            b.setGasTankSize(gasTankSize);

                            manager.addVehicle(b);
                            break;
                        case "3":
                            boolean noOfSeatsError = true;
                            int seats = 0;
                            while (noOfSeatsError) {
                                try {
                                    System.out.println("Number of seats: ");
                                    seats = s.nextInt();
                                    noOfSeatsError = false;
                                }catch (InputMismatchException e) {
                                    System.out.println("Number of seats should be in integer.");
                                    s.next();
                                }
                            }

                            s.nextLine();
                            System.out.println("Airbag makers: ");
                            String vanAirbagMakers = s.nextLine();

                            Van v = new Van();

                            v.setType("Van");
                            v.setMake(make);
                            v.setPlateNumber(plateNumber);
                            v.setRentPerDay(rentPerDay);
                            v.setDescription(description);
                            v.setImage(image);
                            v.setSeats(seats);
                            v.setAirBagMakers(vanAirbagMakers);

                            manager.addVehicle(v);
                            break;
                        default:
                            System.out.println("Please check your input. \n");
                            break;
                    }

                    break;
                // delete a vehicle by plate-number
                case "4":
                    System.out.println("Enter the plate number of vehicle to delete: ");
                    String delPlateNumber = s.nextLine();
                    manager.deleteVehicle(delPlateNumber);
                    break;
                // opens the user application through console
                case "5":
                    manager.openUserApplication();
                // exit from application
                case "6":
                    exit = true;
                    break;
                default:
                    invalidInput = true;
                    System.out.println("Please check your input. \n");
                    break;
            }
        }
    }
}
