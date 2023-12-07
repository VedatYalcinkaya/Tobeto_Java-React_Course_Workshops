package com.tobeto.rentacar.services.concretes;

import com.tobeto.rentacar.entities.PaymentMethod;
import com.tobeto.rentacar.repositories.PaymentMethodRepository;
import com.tobeto.rentacar.services.abstracts.PaymentMethodService;
import com.tobeto.rentacar.services.dtos.paymentmethod.requests.AddPaymentMethodRequest;
import com.tobeto.rentacar.services.dtos.paymentmethod.requests.DeletePaymentMethodRequest;
import com.tobeto.rentacar.services.dtos.paymentmethod.requests.UpdatePaymentMethodRequest;
import org.springframework.stereotype.Service;

@Service
public class PaymentMethodManager implements PaymentMethodService {
    private  final PaymentMethodRepository paymentMethodRepository;

    public PaymentMethodManager(PaymentMethodRepository paymentMethodRepository) {
        this.paymentMethodRepository = paymentMethodRepository;
    }


    @Override
    public void add(AddPaymentMethodRequest request) {
        PaymentMethod paymentMethod = new PaymentMethod();
        paymentMethod.setName(request.getName());
        paymentMethodRepository.save(paymentMethod);
    }

    @Override
    public void update(UpdatePaymentMethodRequest request) {
        if (paymentMethodRepository.existsByName(request.getName())){
            throw new RuntimeException("Bu method zaten kayıtlı");
        }
        PaymentMethod paymentMethodToUpdate = paymentMethodRepository.findById(request.getId()).orElseThrow();
        paymentMethodToUpdate.setName(request.getName());
        paymentMethodRepository.save(paymentMethodToUpdate);

    }

    @Override
    public void delete(DeletePaymentMethodRequest request) {
        PaymentMethod paymentMethodToDelete = paymentMethodRepository.findById(request.getId()).orElseThrow();
        paymentMethodRepository.delete(paymentMethodToDelete);
    }

    @Override
    public PaymentMethod getById(int id) {
        return paymentMethodRepository.findById(id).orElseThrow();
    }


}
