package com.rentalVehicleManager;

public class MotorBike extends Vehicle {
    private String typeOfHelmet;
    private double gasTankSize;

    public MotorBike() { }

    @Override
    public int getSeats() {
        return 2;
    }

    @Override
    public boolean isAeroDynamic() {
        return false;
    }

    @Override
    public String getAirbagMakers() {
        return null;
    }

    public String getTypeOfHelmet() {
        return typeOfHelmet;
    }

    public void setTypeOfHelmet(String typeOfHelmets) {
        this.typeOfHelmet = typeOfHelmets;
    }

    public double getGasTankSize() {
        return gasTankSize;
    }

    public void setGasTankSize(double gasTankSize) {
        this.gasTankSize = gasTankSize;
    }
}
