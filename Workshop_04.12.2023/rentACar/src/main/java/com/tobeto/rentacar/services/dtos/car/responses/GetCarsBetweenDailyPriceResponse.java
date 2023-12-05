package com.tobeto.rentacar.services.dtos.car.responses;

import com.tobeto.rentacar.entities.Model;
import com.tobeto.rentacar.services.dtos.fueltype.responses.GetListFuelTypeResponse;
import com.tobeto.rentacar.services.dtos.gear.responses.GetListGearResponse;
import com.tobeto.rentacar.services.dtos.model.responses.GetListModelResponse;
import com.tobeto.rentacar.services.dtos.price.responses.GetListPriceResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCarsBetweenDailyPriceResponse {
    private int id;
    private int modelYear;
    private int engineDisplacement;
    private GetListModelResponse model;
    private GetListGearResponse gear;
    private GetListFuelTypeResponse fuelType;
    private GetListPriceResponse price;
}
