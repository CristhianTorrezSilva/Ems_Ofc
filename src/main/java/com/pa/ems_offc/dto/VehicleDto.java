package com.pa.ems_offc.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class VehicleDto {

    private Long id;
    private String vehicleName;
    private String vehicleModel;
}
