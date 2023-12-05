package com.tobeto.rentacar.services.dtos.paymentmethod.requests;

import lombok.Data;

@Data
public class UpdatePaymentMethodRequest {
    private int id;
    private String name;
}
