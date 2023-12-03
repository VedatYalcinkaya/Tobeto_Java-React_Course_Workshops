package com.tobeto.rentacar.services.dtos.gear.requests;

import lombok.Data;

@Data
public class UpdateGearRequest {
    private int id;
    private String type;
    private String gearCount;
}
