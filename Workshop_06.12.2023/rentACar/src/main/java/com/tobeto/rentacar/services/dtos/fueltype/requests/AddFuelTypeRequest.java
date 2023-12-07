package com.tobeto.rentacar.services.dtos.fueltype.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AddFuelTypeRequest {
    @NotBlank(message = "FuelType boş bırakılamaz")
    @Size(max = 30, message = "30 karakterden uzun olamaz")
    private String name;
}
