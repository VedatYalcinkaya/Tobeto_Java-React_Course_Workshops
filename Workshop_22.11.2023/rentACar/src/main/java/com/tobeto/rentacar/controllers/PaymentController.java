package com.tobeto.rentacar.controllers;

import com.tobeto.rentacar.services.abstracts.PaymentService;
import com.tobeto.rentacar.services.dtos.payment.requests.AddPaymentRequest;
import com.tobeto.rentacar.services.dtos.payment.requests.DeletePaymentRequest;
import com.tobeto.rentacar.services.dtos.payment.requests.UpdatePaymentRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/payments")
public class PaymentController {
    private final PaymentService paymentService;


    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    public void add(@RequestBody AddPaymentRequest request){
        paymentService.add(request);
    }

    @PutMapping
    public void update(@RequestBody UpdatePaymentRequest request){
        paymentService.update(request);
    }

    @DeleteMapping
    public void delete(@RequestBody DeletePaymentRequest request){
        paymentService.delete(request);
    }
}
