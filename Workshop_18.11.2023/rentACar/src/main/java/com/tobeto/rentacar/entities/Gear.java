package com.tobeto.rentacar.entities;

import jakarta.persistence.*;

import java.util.List;

@Table(name = "gears")
@Entity
public class Gear {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "type")
    private String type;

    @Column(name = "gear_count")
    private String gearCount;

    @OneToMany(mappedBy = "gear")
    private List<Car> cars;

}
