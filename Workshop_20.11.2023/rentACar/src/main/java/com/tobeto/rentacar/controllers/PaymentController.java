package com.tobeto.rentacar.controllers;

import com.tobeto.rentacar.entities.Payment;
import com.tobeto.rentacar.repositories.PaymentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/payments")
public class PaymentController {

    private final PaymentRepository paymentRepository;

    public PaymentController(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @GetMapping
    public List<Payment> getAll(){
        return paymentRepository.findAll();
    }

    @GetMapping("{id}")
    public Payment payment(@PathVariable int id){
        return paymentRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Payment payment){
        paymentRepository.save(payment);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        Payment paymentToDelete = paymentRepository.findById(id).orElseThrow();
        paymentRepository.delete(paymentToDelete);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody Payment updatedPaymet){
        Payment paymentToUpdate = paymentRepository.findById(id).orElseThrow();
        paymentToUpdate.setAmount(updatedPaymet.getAmount());
        paymentToUpdate.setPaymentMethod(updatedPaymet.getPaymentMethod());
        paymentRepository.save(paymentToUpdate);
    }


}
