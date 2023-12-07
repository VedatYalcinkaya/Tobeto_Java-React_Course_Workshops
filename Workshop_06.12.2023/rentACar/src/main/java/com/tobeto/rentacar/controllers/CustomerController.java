package com.tobeto.rentacar.controllers;

import com.tobeto.rentacar.services.abstracts.CustomerService;
import com.tobeto.rentacar.services.dtos.customer.requests.AddCustomerRequest;
import com.tobeto.rentacar.services.dtos.customer.requests.DeleteCustomerRequest;
import com.tobeto.rentacar.services.dtos.customer.requests.UpdateCustomerRequest;
import com.tobeto.rentacar.services.dtos.customer.responses.GetCustomerByPhone;
import com.tobeto.rentacar.services.dtos.customer.responses.GetCustomersByNameAndSurnameResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/customers")
public class CustomerController {
    private final CustomerService customerService;


    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public void add(@RequestBody @Valid AddCustomerRequest request){
        customerService.add(request);
    }

    @PutMapping
    public void update(@RequestBody @Valid UpdateCustomerRequest request){
        customerService.update(request);
    }

    @DeleteMapping
    public void delete(@RequestBody DeleteCustomerRequest request){
        customerService.delete(request);
    }

    @GetMapping("get-customer-by-name-and-surname")
    public List<GetCustomersByNameAndSurnameResponse> getCustomersByNameAndSurname(@RequestParam String name,@RequestParam String surname){
        return customerService.getCustomerByNameAndSurname(name, surname);
    }

    @GetMapping("get-customer-by-phone")
    public List<GetCustomerByPhone> getCustomerByPhone(@RequestParam String phone){
        return customerService.getCustomerByPhone(phone);
    }
}
