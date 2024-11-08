package com.pa.ems_offc.controller;

import com.pa.ems_offc.dto.VehicleDto;
import com.pa.ems_offc.service.VehicleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/vehicles")

public class VehicleController {
    @Autowired
    private VehicleService vehicleService;

    @PostMapping
    public ResponseEntity<VehicleDto> createVehicle(@RequestBody VehicleDto vehicleDto) {
        VehicleDto result = vehicleService.createVehicle(vehicleDto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);

    }

    // Build Get Department REST API
    @GetMapping("{id}")
    public ResponseEntity<VehicleDto> getVehicleById(@PathVariable("id") Long vehicleId) {
        VehicleDto vehicleDto = vehicleService.getVehicleById(vehicleId);
        return ResponseEntity.ok(vehicleDto);
    }

    // Build Get All Departments REST API
    @GetMapping
    public ResponseEntity<List<VehicleDto>> getAllVehicles() {
        List<VehicleDto> vehicles = vehicleService.getAllVehicles();
        return ResponseEntity.ok(vehicles);
    }
}
