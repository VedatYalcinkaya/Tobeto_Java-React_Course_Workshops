package com.tobeto.rentacar.entities;

import jakarta.persistence.*;

import java.util.List;

@Table(name = "payment-methods")
@Entity
public class PaymentMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "paymentMethod")
    private List<Payment> payments;

}
