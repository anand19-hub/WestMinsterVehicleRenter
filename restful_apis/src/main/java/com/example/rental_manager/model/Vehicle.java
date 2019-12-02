package com.example.rental_manager.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Vehicle")
public class Vehicle {

    @Id
    private final String plateNumber;
    private final String type;
    private final String make;
    private double rentPerDay;
    private boolean available;
    private String description;
    private String image;
    private int seats;
    private boolean aeroDynamic;
    private String typeOfHelmet;
    private String airBagMakers;
    private double gasTankSize;

    public Vehicle(
            @JsonProperty("plateNumber") String plateNumber,
            @JsonProperty("type")String type,
            @JsonProperty("make")String make,
            @JsonProperty("rentPerDay")double rentPerDay,
            @JsonProperty("description")String description,
            @JsonProperty("image")String image,
            @JsonProperty("seats")int seats,
            @JsonProperty("aeroDynamic")boolean aeroDynamic,
            @JsonProperty("typeOfHelmet")String typeOfHelmet,
            @JsonProperty("airBagMakers")String airBagMakers,
            @JsonProperty("gasTankSize")double gasTankSize
    ) {
        this.plateNumber = plateNumber;
        this.type = type;
        this.make = make;
        this.rentPerDay = rentPerDay;
        this.description = description;
        this.image = image;
        this.seats = seats;
        this.aeroDynamic = aeroDynamic;
        this.typeOfHelmet = typeOfHelmet;
        this.airBagMakers = airBagMakers;
        this.gasTankSize = gasTankSize;
    }

    public String getPlateNumber() {
        return plateNumber;
    }


    public String getType() {
        return type;
    }

    public String getMake() {
        return make;
    }

    public double getRentPerDay() {
        return rentPerDay;
    }

    public void setRentPerDay(double rentPerHour) {
        this.rentPerDay = rentPerDay;
    }

    public boolean getAvailable() {return available; }

    public  void setAvailable(boolean available) { this.available = available; }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(String img) {
        this.image = img;
    }

    public  String getImage() {
        return this.image;
    }

    public boolean isAvailable() {
        return available;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public boolean isAeroDynamic() {
        return aeroDynamic;
    }

    public void setAeroDynamic(boolean aeroDynamic) {
        this.aeroDynamic = aeroDynamic;
    }

    public String getTypeOfHelmet() {
        return typeOfHelmet;
    }

    public void setTypeOfHelmet(String typeOfHelmet) {
        this.typeOfHelmet = typeOfHelmet;
    }

    public String getAirBagMakers() {
        return airBagMakers;
    }

    public void setAirBagMakers(String airBagMakers) {
        this.airBagMakers = airBagMakers;
    }

    public double getGasTankSize() {
        return gasTankSize;
    }

    public void setGasTankSize(double gasTankSize) {
        this.gasTankSize = gasTankSize;
    }

}
