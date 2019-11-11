package com.example.rental_manager.service;

import com.example.rental_manager.model.Vehicle;
import com.example.rental_manager.repo.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

// service methods - business logic lies here.
@Service
public class VehicleService {
    private final VehicleRepository vehicleRepository;

    public VehicleService(@Qualifier("mongodbRepo") VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public String addVehicle(Vehicle vehicle) {
        this.vehicleRepository.insert(vehicle);
        return "Added vehicle plate number: " + vehicle.getPlateNumber();
    }

    public List<Vehicle> getVehicles() {
        return this.vehicleRepository.findAll();
    }

    public String deleteVehicle(String plateNumber) {
          this.vehicleRepository.deleteById(plateNumber);
          return "Deleted plate number: " + plateNumber;
    }

    public List<Vehicle> filterVehicles(String filter, String option) {
        List<Vehicle> filteredList = null;
        switch (filter) {
            case "type":
                filteredList = this.vehicleRepository.findByType(option);
                break;
            case "make":
                filteredList = this.vehicleRepository.findByMake(option);
                break;
        }
        return filteredList;
    }
}
