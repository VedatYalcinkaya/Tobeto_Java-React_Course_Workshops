package com.tobeto.rentacar.services.dtos.car.requests;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UpdateCarRequest {
    private int id;

    @NotBlank(message = "modelId boş bırakılamaz")
    private int modelId;

    @NotBlank(message = "gearId boş bırakılamaz")
    private int gearId;

    @NotBlank(message = "fuelTypeId boş bırakılamaz")
    private int fuelTypeId;

    @Min(2000)
    private int modelYear;

    @Min(900)
    private int engineDisplacement;

    @NotBlank(message = "priceId boş bırakılamaz")
    private int priceId;
}
