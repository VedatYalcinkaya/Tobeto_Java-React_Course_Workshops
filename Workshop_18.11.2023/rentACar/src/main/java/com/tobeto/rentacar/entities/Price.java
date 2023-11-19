package com.tobeto.rentacar.entities;

import jakarta.persistence.*;

import java.util.List;

@Table(name = "prices")
@Entity
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "daily_price")
    private double dailyPrice;

    @Column(name = "weekly_price")
    private double weeklyPrice;

    @Column(name = "monthly_price")
    private double monthlyPrice;

    @OneToMany(mappedBy = "price")
    private List<Car> cars;
}
