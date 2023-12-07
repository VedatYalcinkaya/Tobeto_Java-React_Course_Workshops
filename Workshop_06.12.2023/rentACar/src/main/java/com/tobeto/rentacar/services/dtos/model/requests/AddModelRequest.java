package com.tobeto.rentacar.services.dtos.model.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class AddModelRequest {
    @NotBlank(message = "Model adı boş bırakılmaz")
    private String name;

    @NotBlank(message = "BrandId adı boş bırakılmaz")
    private int brandId;
}
