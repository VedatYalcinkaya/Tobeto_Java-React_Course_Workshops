package com.tobeto.rentacar.services.dtos.car.responses;

import com.tobeto.rentacar.entities.FuelType;
import com.tobeto.rentacar.entities.Model;
import com.tobeto.rentacar.entities.Price;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCarsByFuelTypeResponse {
    private int id;
    private String brandName;
    private String modelName;
    private String fuelTypeName;
    private int modelYear;
    private int engineDisplacement;
    private Price price;
}
