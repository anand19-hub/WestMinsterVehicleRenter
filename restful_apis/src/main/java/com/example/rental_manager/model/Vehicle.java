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
    private double rentPerHour;
    private String description;

    public Vehicle(
            @JsonProperty("plateNumber") String plateNumber,
            @JsonProperty("type")String type,
            @JsonProperty("make")String make
    ) {
        this.plateNumber = plateNumber;
        this.type = type;
        this.make = make;
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

    public double getRentPerHour() {
        return rentPerHour;
    }

    public void setRentPerHour(double rentPerHour) {
        this.rentPerHour = rentPerHour;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
