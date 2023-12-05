package com.tobeto.rentacar.repositories;

import com.tobeto.rentacar.entities.Car;
import com.tobeto.rentacar.services.dtos.car.responses.GetCarsBetweenDailyPriceResponse;
import com.tobeto.rentacar.services.dtos.car.responses.GetCarsByFuelTypeResponse;
import com.tobeto.rentacar.services.dtos.car.responses.GetListCarResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Integer> {
    @Query("SELECT new com.tobeto.rentacar.services.dtos.car.responses.GetCarsBetweenDailyPriceResponse(c.id, c.modelYear, c.engineDisplacement, " +
            "new com.tobeto.rentacar.services.dtos.model.responses.GetListModelResponse(m.id, m.name, new com.tobeto.rentacar.services.dtos.brand.responses.GetListBrandResponse(b.id, b.name))," +
            "new com.tobeto.rentacar.services.dtos.gear.responses.GetListGearResponse(g.id,g.type,g.gearCount)," +
            "new com.tobeto.rentacar.services.dtos.fueltype.responses.GetListFuelTypeResponse(f.id,f.name)," +
            "new com.tobeto.rentacar.services.dtos.price.responses.GetListPriceResponse(p.id,p.dailyPrice,p.weeklyPrice,p.monthlyPrice)) " +
            "FROM Car c  INNER JOIN c.model m INNER JOIN c.gear g INNER JOIN c.fuelType f INNER JOIN c.price p INNER JOIN m.brand b " +
            "WHERE p.dailyPrice BETWEEN :minDailyPrice AND :maxDailyPrice")
    List<GetCarsBetweenDailyPriceResponse> findCarsInDailyPriceRange(double minDailyPrice,double maxDailyPrice);
    @Query("SELECT new com.tobeto.rentacar.services.dtos.car.responses.GetCarsByFuelTypeResponse(c.id, c.modelYear, c.engineDisplacement, " +
            "new com.tobeto.rentacar.services.dtos.model.responses.GetListModelResponse(m.id, m.name, new com.tobeto.rentacar.services.dtos.brand.responses.GetListBrandResponse(b.id, b.name))," +
            "new com.tobeto.rentacar.services.dtos.gear.responses.GetListGearResponse(g.id,g.type,g.gearCount)," +
            "new com.tobeto.rentacar.services.dtos.fueltype.responses.GetListFuelTypeResponse(f.id,f.name)," +
            "new com.tobeto.rentacar.services.dtos.price.responses.GetListPriceResponse(p.id,p.dailyPrice,p.weeklyPrice,p.monthlyPrice)) " +
            "FROM Car c  INNER JOIN c.model m INNER JOIN c.gear g INNER JOIN c.fuelType f INNER JOIN c.price p INNER JOIN m.brand b " +
            "WHERE LOWER(c.fuelType.name) = LOWER(:fuelTypeName) ")
    List<GetCarsByFuelTypeResponse> findCarsByFuelType(String fuelTypeName);

    @Query("SELECT new com.tobeto.rentacar.services.dtos.car.responses.GetListCarResponse(c.id, c.modelYear, c.engineDisplacement, " +
            "new com.tobeto.rentacar.services.dtos.model.responses.GetListModelResponse(m.id, m.name, new com.tobeto.rentacar.services.dtos.brand.responses.GetListBrandResponse(b.id, b.name))," +
            "new com.tobeto.rentacar.services.dtos.gear.responses.GetListGearResponse(g.id,g.type,g.gearCount)," +
            "new com.tobeto.rentacar.services.dtos.fueltype.responses.GetListFuelTypeResponse(f.id,f.name)," +
            "new com.tobeto.rentacar.services.dtos.price.responses.GetListPriceResponse(p.id,p.dailyPrice,p.weeklyPrice,p.monthlyPrice)) " +
            "FROM Car c INNER JOIN c.model m INNER JOIN c.gear g INNER JOIN c.fuelType f INNER JOIN c.price p INNER JOIN m.brand b")
    List<GetListCarResponse> findAllBy();
}
