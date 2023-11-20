package com.tobeto.rentacar.controllers;

import com.tobeto.rentacar.entities.Rent;
import com.tobeto.rentacar.repositories.RentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/rents")
public class RentController {
    private final RentRepository rentRepository;

    public RentController(RentRepository rentRepository) {
        this.rentRepository = rentRepository;
    }

    @GetMapping
    public List<Rent> getAll(){
        return rentRepository.findAll();
    }

    @GetMapping("{id}")
    public Rent getById(@PathVariable int id){
        return rentRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Rent rent){
        rentRepository.save(rent);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        Rent rentToDelete = rentRepository.findById(id).orElseThrow();
        rentRepository.delete(rentToDelete);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody Rent updatedRent){
        Rent rentToUpdate = rentRepository.findById(id).orElseThrow();
        rentToUpdate.setCar(updatedRent.getCar());
        rentToUpdate.setRentStartDate(updatedRent.getRentStartDate());
        rentToUpdate.setRentEndDate(updatedRent.getRentEndDate());
        rentToUpdate.setCustomer(updatedRent.getCustomer());
        rentToUpdate.setPayment(updatedRent.getPayment());
    }
}
