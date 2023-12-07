package com.tobeto.rentacar.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Table(name = "gears")
@Entity
@Getter
@Setter
public class Gear {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "type")
    private String type;

    @Column(name = "gear_count")
    private String gearCount;

    @OneToMany(mappedBy = "gear")
    @JsonIgnore
    private List<Car> cars;

}
