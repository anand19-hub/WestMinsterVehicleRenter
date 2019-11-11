package com.example.rental_manager.api;

import com.example.rental_manager.model.Vehicle;
import com.example.rental_manager.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// used to create RESTful web services.
// takes care of mapping request data to the defined request handler method.
// Once response body is generated from the handler method, it converts it to JSON or XML response.
@RestController
public class VehicleController {

    @Autowired
    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PutMapping("/addVehicle")
    public String addVehicle(@RequestBody  Vehicle vehicle) {
        return this.vehicleService.addVehicle(vehicle);
    }

    @GetMapping("/getAllVehicles")
    public List<Vehicle>  getVehicles() {
        return  this.vehicleService.getVehicles();
    }

    @DeleteMapping("/delete/{plateNumber}")
    public String deleteVehicle(@PathVariable("plateNumber") String plateNumber) {
        return this.vehicleService.deleteVehicle(plateNumber);
    }

    @GetMapping("/filterVehicles/{filter}/{option}")
    public List<Vehicle> filterVehicles(@PathVariable("filter") String filter, @PathVariable("option") String option ) {
        return this.vehicleService.filterVehicles(filter,option);
    }
}
