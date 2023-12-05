package com.tobeto.rentacar.repositories;

import com.tobeto.rentacar.entities.Price;
import com.tobeto.rentacar.services.dtos.price.responses.GetListPriceResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PriceRepository extends JpaRepository<Price, Integer> {

}
