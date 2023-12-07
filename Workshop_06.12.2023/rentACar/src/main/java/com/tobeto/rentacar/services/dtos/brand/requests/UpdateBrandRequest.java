package com.tobeto.rentacar.services.dtos.brand.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UpdateBrandRequest {
    @NotBlank
    private int id;

    @NotBlank
    private String name;
}
