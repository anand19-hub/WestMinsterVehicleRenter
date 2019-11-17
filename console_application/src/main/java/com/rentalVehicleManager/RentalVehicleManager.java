package com.rentalVehicleManager;

import java.io.IOException;

public interface RentalVehicleManager {
    public abstract void addVehicle(Vehicle vehicle) throws IOException;

    public abstract void printAllVehicles() throws IOException;

    public abstract void deleteVehicle(String delPlateNumber) throws IOException;
}
