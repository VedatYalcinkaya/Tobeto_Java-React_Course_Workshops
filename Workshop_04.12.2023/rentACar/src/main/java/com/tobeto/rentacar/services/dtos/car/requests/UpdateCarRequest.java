package com.tobeto.rentacar.services.dtos.car.requests;

import lombok.Data;

@Data
public class UpdateCarRequest {
    private int id;
    private int modelId;
    private int gearId;
    private int fuelTypeId;
    private int modelYear;
    private int engineDisplacement;
    private int priceId;
}
