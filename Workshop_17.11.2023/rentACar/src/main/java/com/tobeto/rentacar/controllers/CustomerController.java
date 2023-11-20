package com.tobeto.rentacar.controllers;

import com.tobeto.rentacar.entities.Customer;
import com.tobeto.rentacar.repositories.CustomerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/customers")
public class CustomerController {
    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping
    public List<Customer> getAll(){
        return customerRepository.findAll();
    }

    @GetMapping("{id}")
    public Customer GetById(@PathVariable int id){
        return customerRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Customer customer){
        customerRepository.save(customer);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        Customer customerToDelete = customerRepository.findById(id).orElseThrow();
        customerRepository.delete(customerToDelete);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody Customer updatedCustomer) {
        Customer customerToUpdate = customerRepository.findById(id).orElseThrow();
        customerToUpdate.setName(updatedCustomer.getName());
        customerToUpdate.setSurname(updatedCustomer.getSurname());
        customerToUpdate.setBirthDate(updatedCustomer.getBirthDate());
        customerToUpdate.setDrivingLicense(updatedCustomer.getDrivingLicense());
        customerToUpdate.setAddress(updatedCustomer.getAddress());
        customerToUpdate.setTcNo(updatedCustomer.getTcNo());
        customerToUpdate.setPassportNo(updatedCustomer.getPassportNo());
        customerToUpdate.setEMail(updatedCustomer.getEMail());
        customerToUpdate.setPhone(updatedCustomer.getPhone());

        customerRepository.save(customerToUpdate);
    }


}
