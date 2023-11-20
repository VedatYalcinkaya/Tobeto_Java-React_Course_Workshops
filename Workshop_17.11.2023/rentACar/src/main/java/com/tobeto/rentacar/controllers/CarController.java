package com.tobeto.rentacar.controllers;

import com.tobeto.rentacar.entities.Car;
import com.tobeto.rentacar.repositories.CarRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cars")
public class CarController {

    final public CarRepository carRepository;

    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @GetMapping
    public List<Car> getAll(){
        return carRepository.findAll();
    }

    @GetMapping("{id}")
    public Car getById(@PathVariable int id){
        return carRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Car car){
      carRepository.save(car);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        Car carToDelete = carRepository.findById(id).orElseThrow();
        carRepository.delete(carToDelete);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id,@RequestBody Car updatedCar){
        Car carToUpdate = carRepository.findById(id).orElseThrow();
        carToUpdate.setModel(updatedCar.getModel());
        carToUpdate.setGear(updatedCar.getGear());
        carToUpdate.setFuelType(updatedCar.getFuelType());
        carToUpdate.setModelYear(updatedCar.getModelYear());
        carToUpdate.setEngineDisplacement(updatedCar.getEngineDisplacement());
        carToUpdate.setPrice(updatedCar.getPrice());

        carRepository.save(carToUpdate);
    }

}
