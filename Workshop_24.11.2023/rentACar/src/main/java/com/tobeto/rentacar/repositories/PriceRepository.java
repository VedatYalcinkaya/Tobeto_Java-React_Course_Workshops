package com.tobeto.rentacar.repositories;

import com.tobeto.rentacar.entities.Price;
import com.tobeto.rentacar.services.dtos.price.responses.GetPriceResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PriceRepository extends JpaRepository<Price, Integer> {
    @Query("SELECT new com.tobeto.rentacar.services.dtos.price.responses.GetPriceResponse(p.id, p.dailyPrice, p.weeklyPrice, p.monthlyPrice) " +
            "FROM Price p ORDER BY p.dailyPrice ASC")
    List<GetPriceResponse> findPricesAsc();

    @Query("SELECT new com.tobeto.rentacar.services.dtos.price.responses.GetPriceResponse(p.id, p.dailyPrice, p.weeklyPrice, p.monthlyPrice) " +
            "FROM Price p ORDER BY p.dailyPrice DESC")
    List<GetPriceResponse> findPricesDesc();
}
