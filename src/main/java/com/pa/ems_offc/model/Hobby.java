package com.pa.ems_offc.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_hobbies")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Hobby {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String hobbyName;
    private String hobbyDescription;

}
