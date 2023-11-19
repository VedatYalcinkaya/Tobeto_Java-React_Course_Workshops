package com.tobeto.rentacar.entities;

import jakarta.persistence.*;

import java.util.List;

@Table(name = "driving-licenses")
@Entity
public class DrivingLicense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "drivingLicense")
    private List<Customer> customers;


}
