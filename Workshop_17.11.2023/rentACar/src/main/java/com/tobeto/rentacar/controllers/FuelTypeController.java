package com.tobeto.rentacar.controllers;

import com.tobeto.rentacar.entities.FuelType;
import com.tobeto.rentacar.repositories.FuelTypeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/fuel-types")
public class FuelTypeController {
    private final FuelTypeRepository fuelTypeRepository;

    public FuelTypeController(FuelTypeRepository fuelTypeRepository) {
        this.fuelTypeRepository = fuelTypeRepository;
    }

    @GetMapping
    public List<FuelType> getAll(){
        return fuelTypeRepository.findAll();
    }

    @GetMapping("{id}")
    public FuelType getById(@PathVariable int id){
        return fuelTypeRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody FuelType fuelType){
        fuelTypeRepository.save(fuelType);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        FuelType fuelTypeToDelete = fuelTypeRepository.findById(id).orElseThrow();
        fuelTypeRepository.delete(fuelTypeToDelete);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody FuelType updatedFuelType){
        FuelType fuelTypeToUpdate = fuelTypeRepository.findById(id).orElseThrow();
        fuelTypeToUpdate.setName(updatedFuelType.getName());
        fuelTypeRepository.save(fuelTypeToUpdate);
    }




}
