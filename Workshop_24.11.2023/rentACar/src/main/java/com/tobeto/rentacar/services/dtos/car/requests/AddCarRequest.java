package com.tobeto.rentacar.services.dtos.car.requests;

import lombok.Data;

@Data
public class AddCarRequest {
private int modelId;
private int gearId;
private int fuelTypeId;
private int modelYear;
private int engineDisplacement;
private int priceId;
}
