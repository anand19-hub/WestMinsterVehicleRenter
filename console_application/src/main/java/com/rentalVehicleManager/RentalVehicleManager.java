package com.rentalVehicleManager;

public interface RentalVehicleManager {
    void addVehicle(Vehicle vehicle);

    void printAllVehicles();

    void deleteVehicle(String delPlateNumber);

    void filterVehicles(String filter, String option);

    void writeToCSV();

    void openUserApplication();
}
