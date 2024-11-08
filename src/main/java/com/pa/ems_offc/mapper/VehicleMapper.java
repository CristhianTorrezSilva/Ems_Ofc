package com.pa.ems_offc.mapper;
import com.pa.ems_offc.dto.VehicleDto;
import com.pa.ems_offc.model.Vehicle;

public class VehicleMapper {

    public static VehicleDto mapToVehicleDto(Vehicle vehicle) {
        return new VehicleDto(
                vehicle.getId(),
                vehicle.getVehicleName(),
                vehicle.getVehicleModel()
        );
    }

    //Convertir el Vehicle DTO en una Entidad JPA Vehicle
    public static Vehicle mapToVehicle(VehicleDto vehicleDto) {
        Vehicle vehicle = new Vehicle();
        vehicle.setId(vehicleDto.getId());
        vehicle.setVehicleName(vehicleDto.getVehicleName());
        vehicle.setVehicleModel(vehicleDto.getVehicleModel());
        return vehicle;
    }

}
