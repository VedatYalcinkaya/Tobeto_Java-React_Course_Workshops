package com.tobeto.rentacar.controllers;

import com.tobeto.rentacar.services.abstracts.CarService;
import com.tobeto.rentacar.services.dtos.car.requests.AddCarRequest;
import com.tobeto.rentacar.services.dtos.car.requests.DeleteCarRequest;
import com.tobeto.rentacar.services.dtos.car.requests.UpdateCarRequest;
import com.tobeto.rentacar.services.dtos.car.responses.GetCarsBetweenDailyPriceResponse;
import com.tobeto.rentacar.services.dtos.car.responses.GetCarsByFuelTypeResponse;
import com.tobeto.rentacar.services.dtos.car.responses.GetListCarResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cars")
public class CarController {

    private final CarService carService;


    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping
    public void add(@RequestBody @Valid AddCarRequest request){
        carService.add(request);
    }

    @PutMapping
    public void update(@RequestBody @Valid UpdateCarRequest request){
        carService.update(request);
    }

    @DeleteMapping
    public void delete(@RequestBody DeleteCarRequest request){
        carService.delete(request);
    }

    @GetMapping("/by-daily-price-range")
    public List<GetCarsBetweenDailyPriceResponse> getCarsInDailyPriceRange(@RequestParam double minDailyPrice, @RequestParam double maxDailyPrice) {
        return carService.getCarsBetweenDailyPrices(minDailyPrice, maxDailyPrice);
    }

    @GetMapping("/by-fuel-type")
    public List<GetCarsByFuelTypeResponse> getCarsByFuelType(@RequestParam String fuelTypeName) {
        return carService.getCarsByFuelType(fuelTypeName);
    }

    @GetMapping("getAll")
    public List<GetListCarResponse> getAll(){
        return carService.getAll();
    }
}
