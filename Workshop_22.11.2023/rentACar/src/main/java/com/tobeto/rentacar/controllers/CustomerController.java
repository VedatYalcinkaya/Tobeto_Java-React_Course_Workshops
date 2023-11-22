package com.tobeto.rentacar.controllers;

import com.tobeto.rentacar.services.abstracts.CustomerService;
import com.tobeto.rentacar.services.dtos.customer.requests.AddCustomerRequest;
import com.tobeto.rentacar.services.dtos.customer.requests.DeleteCustomerRequest;
import com.tobeto.rentacar.services.dtos.customer.requests.UpdateCustomerRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/customers")
public class CustomerController {
    private final CustomerService customerService;


    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public void add(@RequestBody AddCustomerRequest request){
        customerService.add(request);
    }

    @PutMapping
    public void update(@RequestBody UpdateCustomerRequest request){
        customerService.update(request);
    }

    @DeleteMapping
    public void delete(@RequestBody DeleteCustomerRequest request){
        customerService.delete(request);
    }
}
