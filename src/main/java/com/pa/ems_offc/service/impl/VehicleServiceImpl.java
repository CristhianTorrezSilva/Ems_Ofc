package com.pa.ems_offc.service.impl;

import com.pa.ems_offc.dto.VehicleDto;
import com.pa.ems_offc.exception.ResourceNotFoundException;
import com.pa.ems_offc.mapper.VehicleMapper;
import com.pa.ems_offc.model.Vehicle;
import com.pa.ems_offc.repository.VehicleRepository;
import com.pa.ems_offc.service.VehicleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class VehicleServiceImpl implements VehicleService {

    private VehicleRepository vehicleRepository;

    @Override
    public VehicleDto createVehicle(VehicleDto vehicleDto) {
        Vehicle vehicle = VehicleMapper.mapToVehicle(vehicleDto);
        Vehicle savedVehicle = vehicleRepository.save(vehicle);
        return VehicleMapper.mapToVehicleDto(savedVehicle);
    }

    @Override
    public VehicleDto getVehicleById(Long vehicleId) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId).orElseThrow(
                () -> new ResourceNotFoundException("Vehicle is not exists with a given id: " + vehicleId)
        );
        return VehicleMapper.mapToVehicleDto(vehicle);
    }

    @Override
    public List<VehicleDto> getAllVehicles() {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        return vehicles.stream().map(VehicleMapper::mapToVehicleDto)
                .collect(Collectors.toList());
    }

    @Override
    public VehicleDto updateVehicle(Long vehicleId, VehicleDto updatedVehicle) {

        Vehicle vehicles = vehicleRepository.findById(vehicleId).orElseThrow(
                () -> new ResourceNotFoundException("Vehicle is not exists with a given id:"+ vehicleId)
        );

        vehicles.setVehicleName(updatedVehicle.getVehicleName());
        vehicles.setVehicleModel(updatedVehicle.getVehicleModel());

        Vehicle savedVehicle = vehicleRepository.save(vehicles);

        return VehicleMapper.mapToVehicleDto(savedVehicle);
    }

    @Override
    public void deleteVehicle(Long vehicleId) {
        vehicleRepository.findById(vehicleId).orElseThrow(
                () -> new ResourceNotFoundException("Vehicle is not exists with a given id: " + vehicleId)
        );

        vehicleRepository.deleteById(vehicleId);
    }

}
