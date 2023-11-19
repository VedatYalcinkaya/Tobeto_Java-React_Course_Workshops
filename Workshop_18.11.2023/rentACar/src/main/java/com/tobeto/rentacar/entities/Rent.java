package com.tobeto.rentacar.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Table(name = "rents")
@Entity
public class Rent
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "rent_start_date")
    private LocalDate rentStartDate;

    @Column(name = "rent_end_date")
    private LocalDate rentEndDate;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "payment_id")
    private Payment payment;

}
