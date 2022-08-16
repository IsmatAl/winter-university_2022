package com.nortal.mega.persistence.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "building")
public class BuildingDbo {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "index")
    private String index;
    @Column(name = "sector_code")
    private String sectorCode;
    @Column(name = "energy_unit_max")
    private Integer energyUnitMax;
    @Column(name = "energy_units")
    private Integer energyUnits;
}
