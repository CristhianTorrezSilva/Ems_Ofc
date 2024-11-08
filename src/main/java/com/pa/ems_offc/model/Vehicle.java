package com.pa.ems_offc.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_vehicles")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Vehicle {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String vehicleName;
    private String vehicleModel;
}
