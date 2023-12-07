package com.tobeto.rentacar.services.abstracts;

import com.tobeto.rentacar.entities.PaymentMethod;
import com.tobeto.rentacar.services.dtos.paymentmethod.requests.AddPaymentMethodRequest;
import com.tobeto.rentacar.services.dtos.paymentmethod.requests.DeletePaymentMethodRequest;
import com.tobeto.rentacar.services.dtos.paymentmethod.requests.UpdatePaymentMethodRequest;

public interface PaymentMethodService {
    void add(AddPaymentMethodRequest request);
    void update(UpdatePaymentMethodRequest request);
    void delete(DeletePaymentMethodRequest request);

    PaymentMethod getById(int id);
}
