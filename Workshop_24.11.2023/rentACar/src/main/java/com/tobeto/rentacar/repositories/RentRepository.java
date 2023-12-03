package com.tobeto.rentacar.repositories;

import com.tobeto.rentacar.entities.Rent;
import com.tobeto.rentacar.services.dtos.rent.responses.GetAvailableCarsResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface RentRepository extends JpaRepository<Rent, Integer> {

    @Query("SELECT NEW com.tobeto.rentacar.services.dtos.rent.responses.GetAvailableCarsResponse(r.car.id, r.car.model.brand.name,r.car.model.name) " +
            "FROM Rent r WHERE :currentDate NOT BETWEEN r.rentStartDate AND r.rentEndDate AND r.rentEndDate IS NOT NULL")
    List<GetAvailableCarsResponse> findAvailableCars(LocalDate currentDate);
}
