package com.tobeto.rentacar.services.dtos.paymentmethod.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UpdatePaymentMethodRequest {
    private int id;
    @NotBlank(message = "Ödeme Yöntemi bor bırakılamaz")
    private String name;
}
