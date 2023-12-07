package com.tobeto.rentacar.repositories;

import com.tobeto.rentacar.entities.Rent;
import com.tobeto.rentacar.services.dtos.rent.responses.GetAvailableCarsResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface RentRepository extends JpaRepository<Rent, Integer> {

    @Query("SELECT NEW com.tobeto.rentacar.services.dtos.rent.responses.GetAvailableCarsResponse(new com.tobeto.rentacar.services.dtos.car.responses.GetListCarResponse(c.id, c.modelYear, c.engineDisplacement, " +
            "new com.tobeto.rentacar.services.dtos.model.responses.GetListModelResponse(m.id, m.name, new com.tobeto.rentacar.services.dtos.brand.responses.GetListBrandResponse(b.id, b.name)), " +
            "new com.tobeto.rentacar.services.dtos.gear.responses.GetListGearResponse(g.id,g.type,g.gearCount)," +
            "new com.tobeto.rentacar.services.dtos.fueltype.responses.GetListFuelTypeResponse(f.id,f.name)," +
            "new com.tobeto.rentacar.services.dtos.price.responses.GetListPriceResponse(p.id,p.dailyPrice,p.weeklyPrice,p.monthlyPrice)) ) " +
            "FROM Rent r INNER JOIN r.car c INNER JOIN c.model m INNER JOIN c.gear g INNER JOIN c.fuelType f INNER JOIN c.price p INNER JOIN m.brand b " +
            "WHERE :currentDate NOT BETWEEN r.rentStartDate AND r.rentEndDate AND r.rentEndDate IS NOT NULL")
    List<GetAvailableCarsResponse> findAvailableCars(LocalDate currentDate);
}
