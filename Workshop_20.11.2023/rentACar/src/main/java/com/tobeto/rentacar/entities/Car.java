package com.tobeto.rentacar.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

// Repository, DAO, DAL
// Data Access Object
// Data Access Layer

//ORM => Object Relation Mapping
@Table(name="cars")
@Entity
@Getter
@Setter
public class Car {
    @Id
    @Column(name = "id") //name = kolon_adı
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;// classın içindeki alan dı

    @Column(name = "model_year")
    private int modelYear;

    @Column(name = "engine_displacement")
    private int engineDisplacement;

    // TODO: İlişkisel tabloların alanları eklenecek

    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;

    @ManyToOne
    @JoinColumn(name = "gear_id")
    private Gear gear;

    @ManyToOne
    @JoinColumn(name = "fuel_type_id")
    private FuelType fuelType;

    @ManyToOne
    @JoinColumn(name = "price_id")
    private Price price;

    @OneToMany(mappedBy = "car")
    @JsonIgnore
    private List<Rent> rents;

}
