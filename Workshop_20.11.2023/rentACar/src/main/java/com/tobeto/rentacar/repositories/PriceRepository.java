package com.tobeto.rentacar.repositories;

import com.tobeto.rentacar.entities.Price;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRepository extends JpaRepository<Price, Integer> {

}
