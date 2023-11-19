package com.tobeto.rentacar.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Table(name = "customers")
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column (name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "address")
    private String address;

    @Column(name = "tc_no")
    private String tcNo;

    @Column(name = "passport_no")
    private String passportNo;

    @Column(name = "e-mail")
    private String eMail;

    @Column(name = "phone")
    private String phone;

    @OneToMany(mappedBy = "customer")
    private List<Rent> rents;

    @ManyToOne
    @JoinColumn(name = "driving_license_id")
    private DrivingLicense drivingLicense;



}
