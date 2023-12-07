package com.tobeto.rentacar.services.dtos.drivinglicense.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AddDrivingLicenseRequest {
    @NotBlank(message = "Ehliyet adı boş bırakılamaz")
    private String name;
}
