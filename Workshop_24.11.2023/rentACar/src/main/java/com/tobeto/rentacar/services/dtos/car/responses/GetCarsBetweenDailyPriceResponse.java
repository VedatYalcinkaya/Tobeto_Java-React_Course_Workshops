package com.tobeto.rentacar.services.dtos.car.responses;

import com.tobeto.rentacar.entities.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCarsBetweenDailyPriceResponse {
    private int id;
    private Model model;
    private int modelYear;
    private int engineDisplacement;
    private double dailyPrice;
}
