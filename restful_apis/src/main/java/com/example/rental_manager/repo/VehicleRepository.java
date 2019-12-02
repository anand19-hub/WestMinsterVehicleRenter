package com.example.rental_manager.repo;

import com.example.rental_manager.model.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

// this is the stereotype to access database.
// extending with mango repository for crud methods.
@Repository("mongodbRepo")
public interface VehicleRepository extends MongoRepository<Vehicle, String> {
    // can have additional methods in-case if some functionality is not available in mongo repository

    List<Vehicle> findByType(String typeOptn);
    List<Vehicle> findByMake(String makeOptn);
    Vehicle findByPlateNumber(String plateNum);
}
