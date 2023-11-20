package com.tobeto.rentacar.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Table(name = "customers")
@Entity
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
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
    @JsonIgnore
    private List<Rent> rents;

    @ManyToOne
    @JoinColumn(name = "driving_license_id")
    private DrivingLicense drivingLicense;



}
