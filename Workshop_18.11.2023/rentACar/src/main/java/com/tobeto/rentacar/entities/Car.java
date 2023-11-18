package com.tobeto.rentacar.entities;

import jakarta.persistence.*;

//ORM => Object Relation Mapping
@Table(name="cars")
@Entity
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

}
