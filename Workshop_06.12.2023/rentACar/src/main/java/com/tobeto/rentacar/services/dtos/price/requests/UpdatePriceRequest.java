package com.tobeto.rentacar.services.dtos.price.requests;

import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class UpdatePriceRequest {
    private int id;
    @Min(value = 200, message = "Günlük ödeme 200den aşağı olamaz")
    private double dailyPrice;
    @Min(value = 600, message = "Haftalık ödeme 600den aşağı olamaz")
    private double weeklyPrice;
    @Min(value = 1800, message = "Aylık ödeme 1800den aşağı olamaz")
    private double monthlyPrice;
}
