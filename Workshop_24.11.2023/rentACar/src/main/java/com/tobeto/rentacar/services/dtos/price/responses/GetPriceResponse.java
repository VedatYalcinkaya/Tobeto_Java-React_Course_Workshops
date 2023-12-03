package com.tobeto.rentacar.services.dtos.price.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetPriceResponse {
    private int priceId;
    private double dailyPrice;
    private double weeklyPrice;
    private double monthlyPrice;
}
