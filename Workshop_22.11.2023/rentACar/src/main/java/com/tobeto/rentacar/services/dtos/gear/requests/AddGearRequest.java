package com.tobeto.rentacar.services.dtos.gear.requests;

import lombok.Data;

@Data
public class AddGearRequest {
    private String type;
    private String gearCount;
}
