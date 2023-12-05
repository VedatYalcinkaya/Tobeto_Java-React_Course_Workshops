package com.tobeto.rentacar.services.dtos.price.requests;

import lombok.Data;

@Data
public class UpdatePriceRequest {
    private int id;
    private double dailyPrice;
    private double weeklyPrice;
    private double monthlyPrice;
}
