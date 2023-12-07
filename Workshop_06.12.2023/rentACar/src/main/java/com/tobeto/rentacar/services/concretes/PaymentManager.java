package com.tobeto.rentacar.services.concretes;

import com.tobeto.rentacar.entities.Payment;
import com.tobeto.rentacar.entities.PaymentMethod;
import com.tobeto.rentacar.repositories.PaymentMethodRepository;
import com.tobeto.rentacar.repositories.PaymentRepository;
import com.tobeto.rentacar.services.abstracts.PaymentMethodService;
import com.tobeto.rentacar.services.abstracts.PaymentService;
import com.tobeto.rentacar.services.dtos.payment.requests.AddPaymentRequest;
import com.tobeto.rentacar.services.dtos.payment.requests.DeletePaymentRequest;
import com.tobeto.rentacar.services.dtos.payment.requests.UpdatePaymentRequest;
import org.springframework.stereotype.Service;

@Service
public class PaymentManager implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final PaymentMethodService paymentMethodService;

    public PaymentManager(PaymentRepository paymentRepository, PaymentMethodService paymentMethodService) {
        this.paymentRepository = paymentRepository;
        this.paymentMethodService = paymentMethodService;
    }

    @Override
    public void add(AddPaymentRequest request) {
        //Validation ile halledimeyecek bir busines rule bulamadım.
        Payment payment = new Payment();
        PaymentMethod paymentMethod = paymentMethodService.getById(request.getPaymentMethodId());
        payment.setPaymentMethod(paymentMethod);
        payment.setAmount(request.getAmount());
        paymentRepository.save(payment);
    }

    @Override
    public void update(UpdatePaymentRequest request) {
        Payment paymentToUpdate = paymentRepository.findById(request.getId()).orElseThrow();
        PaymentMethod paymentMethod = paymentMethodService.getById(request.getPaymentMethodId());
        paymentToUpdate.setPaymentMethod(paymentMethod);
        paymentToUpdate.setAmount(request.getAmount());
        paymentRepository.save(paymentToUpdate);

    }

    @Override
    public void delete(DeletePaymentRequest request) {
        Payment paymentToDelete = paymentRepository.findById(request.getId()).orElseThrow();
        paymentRepository.delete(paymentToDelete);
    }

    @Override
    public Payment getById(int id) {
        return paymentRepository.findById(id).orElseThrow();
    }
}