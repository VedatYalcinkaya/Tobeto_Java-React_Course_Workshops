package com.tobeto.rentacar.services.dtos.rent.responses;

import com.tobeto.rentacar.services.dtos.car.responses.GetListCarResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAvailableCarsResponse {
    private GetListCarResponse car;
}
