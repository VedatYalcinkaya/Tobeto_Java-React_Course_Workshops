package com.tobeto.rentacar.controllers;

import com.tobeto.rentacar.services.abstracts.PaymentMethodService;
import com.tobeto.rentacar.services.dtos.paymentmethod.requests.AddPaymentMethodRequest;
import com.tobeto.rentacar.services.dtos.paymentmethod.requests.DeletePaymentMethodRequest;
import com.tobeto.rentacar.services.dtos.paymentmethod.requests.UpdatePaymentMethodRequest;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/payment-methods")
public class PaymentMethodContoller {
    private final PaymentMethodService paymentMethodService;


    public PaymentMethodContoller(PaymentMethodService paymentMethodService) {
        this.paymentMethodService = paymentMethodService;
    }

    @PostMapping
    public void add(@RequestBody @Valid AddPaymentMethodRequest request){
        paymentMethodService.add(request);
    }

    @PutMapping
    public void update(@RequestBody @Valid UpdatePaymentMethodRequest request){
        paymentMethodService.update(request);
    }

    @DeleteMapping
    public void delete(@RequestBody DeletePaymentMethodRequest request){
        paymentMethodService.delete(request);
    }
}
