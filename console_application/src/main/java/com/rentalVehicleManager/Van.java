package com.rentalVehicleManager;

public class Van extends Vehicle{
    private int seats;
    private String airbagMakers;

    public Van() { }

    @Override
    public boolean isAeroDynamic() {
        return false;
    }

    @Override
    public String getTypeOfHelmet() {
        return null;
    }

    @Override
    public double getGasTankSize() {
        return 60;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public String getAirbagMakers() {
        return airbagMakers;
    }

    public void setAirBagMakers(String airBagMakers) {
        this.airbagMakers = airBagMakers;
    }
}
