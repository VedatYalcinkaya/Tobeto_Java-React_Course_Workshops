package com.tobeto.rentacar.repositories;

import com.tobeto.rentacar.entities.Rent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentRepository extends JpaRepository<Rent, Integer> {
}
