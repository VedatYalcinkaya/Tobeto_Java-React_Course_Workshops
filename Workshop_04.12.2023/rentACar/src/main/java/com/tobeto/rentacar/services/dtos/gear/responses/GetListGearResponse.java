package com.tobeto.rentacar.services.dtos.gear.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetListGearResponse {
    private int id;
    private String type;
    private String gearCount;
}
