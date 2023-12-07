package com.tobeto.rentacar.services.dtos.gear.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UpdateGearRequest {
    private int id;

    @NotBlank(message = "vitesi tipi boş bırakılamaz")
    @Size(max = 30, message = "vites tipi 30 karakterden uzun olamaz")
    private String type;


    @Size(max = 30, message = "vites sayısı 30 karakterden uzun olamaz")
    private String gearCount;
}
