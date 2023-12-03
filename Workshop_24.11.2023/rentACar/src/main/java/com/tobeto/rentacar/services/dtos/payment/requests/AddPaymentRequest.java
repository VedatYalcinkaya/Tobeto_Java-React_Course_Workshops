package com.tobeto.rentacar.services.dtos.payment.requests;

import lombok.Data;

@Data
public class AddPaymentRequest {
    private double amount;
    private int paymentMethodId;
}
