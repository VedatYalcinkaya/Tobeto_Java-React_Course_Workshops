package com.tobeto.rentacar.controllers;

import com.tobeto.rentacar.services.abstracts.CarService;
import com.tobeto.rentacar.services.dtos.car.requests.AddCarRequest;
import com.tobeto.rentacar.services.dtos.car.requests.DeleteCarRequest;
import com.tobeto.rentacar.services.dtos.car.requests.UpdateCarRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/cars")
public class CarController {

    private final CarService carService;


    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping
    public void add(@RequestBody AddCarRequest request){
        carService.add(request);
    }

    @PutMapping
    public void update(@RequestBody UpdateCarRequest request){
        carService.update(request);
    }

    @DeleteMapping
    public void delete(@RequestBody DeleteCarRequest request){
        carService.delete(request);
    }
}
