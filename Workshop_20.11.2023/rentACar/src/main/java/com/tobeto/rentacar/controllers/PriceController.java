package com.tobeto.rentacar.controllers;

import com.tobeto.rentacar.entities.Price;
import com.tobeto.rentacar.repositories.PriceRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/prices")
public class PriceController {
    private final PriceRepository priceRepository;

    public PriceController(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @GetMapping
    public List<Price> getAll(){
        return priceRepository.findAll();
    }

    @GetMapping("{id}")
    public Price getById(@PathVariable int id){
        return priceRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Price price){
        priceRepository.save(price);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        Price priceToDelete = priceRepository.findById(id).orElseThrow();
        priceRepository.delete(priceToDelete);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id,@RequestBody Price updatedPrice){
        Price priceToUpdate = priceRepository.findById(id).orElseThrow();
        priceToUpdate.setDailyPrice(updatedPrice.getDailyPrice());
        priceToUpdate.setMonthlyPrice(updatedPrice.getMonthlyPrice());
        priceToUpdate.setWeeklyPrice(updatedPrice.getWeeklyPrice());
        priceRepository.save(priceToUpdate);
    }


}
