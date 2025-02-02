package com.elifcan.product.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tblcar")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String model;
    String marka;
    Integer year;
    Integer dailyRate;
    Integer fuelType;
    Boolean isAvailable;
    Integer km;
    Double price;
}
