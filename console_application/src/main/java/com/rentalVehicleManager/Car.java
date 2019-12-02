package com.rentalVehicleManager;

public class Car extends Vehicle {
    private boolean isAeroDynamic;
    private String airbagMakers;

    public Car()  { }

    @Override
    public int getSeats() {
        return 4;
    }
    @Override
    public String getTypeOfHelmet() {
        return null;
    }

    @Override
    public double getGasTankSize() {
        return 50;
    }

    public boolean isAeroDynamic() {
        return isAeroDynamic;
    }

    public void setAeroDynamic(boolean aeroDynamic) {
        isAeroDynamic = aeroDynamic;
    }

    public String getAirbagMakers() {
        return airbagMakers;
    }

    public void setAirbagMakers(String airBagMakers) {
        this.airbagMakers = airBagMakers;
    }
}
