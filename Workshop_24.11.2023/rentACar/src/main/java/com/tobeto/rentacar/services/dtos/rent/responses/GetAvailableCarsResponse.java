package com.tobeto.rentacar.services.dtos.rent.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAvailableCarsResponse {
    private int carId;
    private String brandName;
    private String modelName;
}
