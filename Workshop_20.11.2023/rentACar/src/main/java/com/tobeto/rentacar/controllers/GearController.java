package com.tobeto.rentacar.controllers;

import com.tobeto.rentacar.entities.Gear;
import com.tobeto.rentacar.repositories.GearRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/gears")
public class GearController {
    private final GearRepository gearRepository;

    public GearController(GearRepository gearRepository) {
        this.gearRepository = gearRepository;
    }

    @GetMapping
    public List<Gear> getAll(){
        return gearRepository.findAll();
    }

    @GetMapping("{id}")
    public Gear getById(@PathVariable int id){
        return gearRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Gear gear){
        gearRepository.save(gear);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        Gear gearToDelete = gearRepository.findById(id).orElseThrow();
        gearRepository.delete(gearToDelete);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody Gear updatedGear){
        Gear gearToUpdate = gearRepository.findById(id).orElseThrow();
        gearToUpdate.setGearCount(updatedGear.getGearCount());
        gearToUpdate.setType(gearToUpdate.getType());
        gearRepository.save(gearToUpdate);
    }
}
