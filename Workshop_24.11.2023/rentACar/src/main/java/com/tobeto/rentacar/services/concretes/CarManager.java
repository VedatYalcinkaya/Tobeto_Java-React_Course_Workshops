package com.tobeto.rentacar.services.concretes;

import com.tobeto.rentacar.entities.*;
import com.tobeto.rentacar.repositories.*;
import com.tobeto.rentacar.services.abstracts.CarService;
import com.tobeto.rentacar.services.dtos.car.requests.AddCarRequest;
import com.tobeto.rentacar.services.dtos.car.requests.DeleteCarRequest;
import com.tobeto.rentacar.services.dtos.car.requests.UpdateCarRequest;
import com.tobeto.rentacar.services.dtos.car.responses.GetCarsBetweenDailyPriceResponse;
import com.tobeto.rentacar.services.dtos.car.responses.GetCarsByFuelTypeResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarManager implements CarService {

    private final CarRepository carRepository;
    private final ModelRepository modelRepository;
    private final GearRepository gearRepository;
    private final FuelTypeRepository fuelTypeRepository;
    private final PriceRepository priceRepository;

    public CarManager(CarRepository carRepository, ModelRepository modelRepository, GearRepository gearRepository, FuelTypeRepository fuelTypeRepository, PriceRepository priceRepository) {
        this.carRepository = carRepository;
        this.modelRepository = modelRepository;
        this.gearRepository = gearRepository;
        this.fuelTypeRepository = fuelTypeRepository;
        this.priceRepository = priceRepository;
    }

    @Override
    public void add(AddCarRequest request) {
        Car car = new Car();
        Model model = modelRepository.findById(request.getModelId()).orElseThrow();
        Gear gear = gearRepository.findById(request.getGearId()).orElseThrow();
        FuelType fuelType = fuelTypeRepository.findById(request.getFuelTypeId()).orElseThrow();
        Price price = priceRepository.findById(request.getPriceId()).orElseThrow();

        car.setModel(model);
        car.setGear(gear);
        car.setPrice(price);
        car.setFuelType(fuelType);
        car.setModelYear(request.getModelYear());
        car.setEngineDisplacement(request.getEngineDisplacement());

        carRepository.save(car);
    }

    @Override
    public void update(UpdateCarRequest request) {
        Car carToUpdate = carRepository.findById(request.getId()).orElseThrow();
        Model model = modelRepository.findById(request.getModelId()).orElseThrow();
        Gear gear = gearRepository.findById(request.getGearId()).orElseThrow();
        FuelType fuelType = fuelTypeRepository.findById(request.getFuelTypeId()).orElseThrow();
        Price price = priceRepository.findById(request.getPriceId()).orElseThrow();

        carToUpdate.setModel(model);
        carToUpdate.setGear(gear);
        carToUpdate.setPrice(price);
        carToUpdate.setFuelType(fuelType);
        carToUpdate.setModelYear(request.getModelYear());
        carToUpdate.setEngineDisplacement(request.getEngineDisplacement());

        carRepository.save(carToUpdate);
    }

    @Override
    public void delete(DeleteCarRequest request) {
        Car carToDelete = carRepository.findById(request.getId()).orElseThrow();
        carRepository.delete(carToDelete);
    }

    @Override
    public List<GetCarsBetweenDailyPriceResponse> getCarsBetweenDailyPrices(double minDailyPrice, double maxDailyPrice) {
        return carRepository.findCarsInDailyPriceRange(minDailyPrice, maxDailyPrice);
    }

    @Override
    public List<GetCarsByFuelTypeResponse> getCarsByFuelType(String fuelTypeName) {
        return carRepository.findCarsByFuelType(fuelTypeName);
    }
}
