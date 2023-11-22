package com.tobeto.rentacar.services.abstracts;

import com.tobeto.rentacar.services.dtos.payment.requests.AddPaymentRequest;
import com.tobeto.rentacar.services.dtos.payment.requests.DeletePaymentRequest;
import com.tobeto.rentacar.services.dtos.payment.requests.UpdatePaymentRequest;

public interface PaymentService {
    void add (AddPaymentRequest request);
    void update(UpdatePaymentRequest request);
    void delete (DeletePaymentRequest request);
}
