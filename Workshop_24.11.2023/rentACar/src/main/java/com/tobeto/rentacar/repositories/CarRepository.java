package com.tobeto.rentacar.repositories;

import com.tobeto.rentacar.entities.Car;
import com.tobeto.rentacar.entities.FuelType;
import com.tobeto.rentacar.services.dtos.car.responses.GetCarsBetweenDailyPriceResponse;
import com.tobeto.rentacar.services.dtos.car.responses.GetCarsByFuelTypeResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Integer> {
    @Query("SELECT new com.tobeto.rentacar.services.dtos.car.responses.GetCarsBetweenDailyPriceResponse(c.id, c.model, c.modelYear, c.engineDisplacement, c.price.dailyPrice) " +
            "FROM Car c WHERE c.price.dailyPrice BETWEEN :minDailyPrice AND :maxDailyPrice")
    List<GetCarsBetweenDailyPriceResponse> findCarsInDailyPriceRange(double minDailyPrice,double maxDailyPrice);
    @Query("SELECT new com.tobeto.rentacar.services.dtos.car.responses.GetCarsByFuelTypeResponse(c.id,c.model.brand.name,c.model.name, c.fuelType.name, c.modelYear, c.engineDisplacement, c.price) " +
            "FROM Car c WHERE LOWER(c.fuelType.name) = LOWER(:fuelTypeName) ")
    List<GetCarsByFuelTypeResponse> findCarsByFuelType(String fuelTypeName);
}
