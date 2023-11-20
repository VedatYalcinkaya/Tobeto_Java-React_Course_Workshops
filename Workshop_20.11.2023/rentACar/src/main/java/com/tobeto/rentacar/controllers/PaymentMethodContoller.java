package com.tobeto.rentacar.controllers;

import com.tobeto.rentacar.entities.PaymentMethod;
import com.tobeto.rentacar.repositories.PaymentMethodRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/payment-methods")
public class PaymentMethodContoller {

    private final PaymentMethodRepository paymentMethodRepository;

    public PaymentMethodContoller(PaymentMethodRepository paymentMethodRepository) {
        this.paymentMethodRepository = paymentMethodRepository;
    }

    @GetMapping
    public List<PaymentMethod> getAll(){
        return paymentMethodRepository.findAll();
    }

    @GetMapping("{id}")
    public PaymentMethod getById(@PathVariable int id){
        return paymentMethodRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody PaymentMethod paymentMethod){
        paymentMethodRepository.save(paymentMethod);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        PaymentMethod paymentMethodToDelete = paymentMethodRepository.findById(id).orElseThrow();
        paymentMethodRepository.delete(paymentMethodToDelete);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody PaymentMethod updatedPaymentMethod){
        PaymentMethod paymentMethodToUpdate = paymentMethodRepository.findById(id).orElseThrow();
        paymentMethodToUpdate.setName(updatedPaymentMethod.getName());
        paymentMethodRepository.save(paymentMethodToUpdate);
    }

}
