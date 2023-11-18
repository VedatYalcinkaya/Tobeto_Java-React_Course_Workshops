package com.tobeto.rentacar.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;

@Table(name = "models")
@Entity
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "model")
    private List<Car> cars;

    //one-to-many ilişkilerde list olan değişlken @OneToMany
    //direkt class olan değişken @ManyToOne


}
