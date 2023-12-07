package com.tobeto.rentacar.services.dtos.brand.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AddBrandRequest {
    @NotBlank
    private String name;
}
