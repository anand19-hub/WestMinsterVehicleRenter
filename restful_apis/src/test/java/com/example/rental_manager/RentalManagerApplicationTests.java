package com.example.rental_manager;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import com.example.rental_manager.model.Vehicle;
import com.example.rental_manager.repo.VehicleRepository;
import com.example.rental_manager.service.VehicleService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest
class RentalManagerApplicationTests {
    @Autowired
    private VehicleService service;

    @MockBean
    private VehicleRepository repository;

    @Test
    public void getVehiclesTest() {
        when(repository.findAll()).thenReturn(Stream
            .of(new Vehicle(
                    "WP-01-2290",
                    "Car",
                    "BMW",
                    3500.00,
                    "Some Dummy description",
                    "",
                    4,
                    true,
                    null,
                    "TRW",
                    50
            ), new Vehicle(
                "WP-01-2290",
                "Motor Bike",
                "Yamaha",
                500.50,
                "Some Dummy description",
                "",
                2,
                false,
                "Full Face",
                null,
                1.8
        )).collect(Collectors.toList()));
        assertEquals(2, service.getVehicles().size());
    }

    @Test
    public void addVehicleTest() {
        Vehicle vehicle = new Vehicle(
                "WP-01-2290",
                "Motor Bike",
                "Yamaha",
                500.50,
                "Some Dummy description",
                "",
                2,
                false,
                "Full Face",
                null,
                1.8
        );
        when(repository.insert(vehicle)).thenReturn(vehicle);
        assertEquals("Added vehicle plate number: WP-01-2290", service.addVehicle(vehicle));
    }

    @Test
    public void deleteVehicleTest() {
        String plateNum = "WP-01-2290";
        service.deleteVehicle(plateNum);
        verify(repository, times(1)).deleteById(plateNum);
    }
}
