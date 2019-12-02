package com.rentalVehicleManager;

abstract class Vehicle {

    private String type;
    private String make;
    private String plateNumber;
    private boolean available;
    private double rentPerDay;
    private String description;
    private byte[] image;

    public Vehicle() {
        this.available = true;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public double getRentPerDay() {
        return rentPerDay;
    }

    public void setRentPerDay(double rentPerDay) {
        this.rentPerDay = rentPerDay;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public abstract int getSeats();
    public abstract boolean isAeroDynamic();
    public abstract String getAirbagMakers();
    public abstract String getTypeOfHelmet();
    public abstract double getGasTankSize();
}
