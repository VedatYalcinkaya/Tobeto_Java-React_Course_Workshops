package com.tobeto.rentacar.services.dtos.payment.requests;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UpdatePaymentRequest {
    private int id;
    @Min(value = 300, message = "ödeme 300'den az olmamalı")
    private double amount;
    @NotBlank(message = "paymentMethodId boş bırakılamaz")
    private int paymentMethodId;
}
