package com.tobeto.rentacar.services.dtos.fueltype.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetListFuelTypeResponse {
    private int id;
    private String name;
}
