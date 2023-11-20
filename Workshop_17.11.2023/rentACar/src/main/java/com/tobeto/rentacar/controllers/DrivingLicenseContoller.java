package com.tobeto.rentacar.controllers;

import com.tobeto.rentacar.entities.DrivingLicense;
import com.tobeto.rentacar.repositories.DrivingLicenseRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/driving-licenses")
public class DrivingLicenseContoller {

    private final DrivingLicenseRepository drivingLicenseRepository;

    public DrivingLicenseContoller(DrivingLicenseRepository drivingLicenseRepository) {
        this.drivingLicenseRepository = drivingLicenseRepository;
    }

    @GetMapping
    public List<DrivingLicense> getAll(){
        return drivingLicenseRepository.findAll();
    }

    @GetMapping("{id}")
    public DrivingLicense getById(@PathVariable int id){
        return drivingLicenseRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody DrivingLicense drivingLicense){
        drivingLicenseRepository.save(drivingLicense);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        DrivingLicense drivingLicenseToDelete = drivingLicenseRepository.findById(id).orElseThrow();
        drivingLicenseRepository.delete(drivingLicenseToDelete);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody DrivingLicense updatedDrivingLicense){
        DrivingLicense drivingLicenseToUpdate = drivingLicenseRepository.findById(id).orElseThrow();
        drivingLicenseToUpdate.setName(updatedDrivingLicense.getName());
        drivingLicenseRepository.save(drivingLicenseToUpdate);
    }
}
