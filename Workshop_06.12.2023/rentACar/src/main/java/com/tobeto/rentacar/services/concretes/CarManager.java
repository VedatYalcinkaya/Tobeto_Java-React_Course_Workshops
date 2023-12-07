package com.tobeto.rentacar.services.concretes;

import com.tobeto.rentacar.entities.*;
import com.tobeto.rentacar.repositories.*;
import com.tobeto.rentacar.services.abstracts.*;
import com.tobeto.rentacar.services.dtos.car.requests.AddCarRequest;
import com.tobeto.rentacar.services.dtos.car.requests.DeleteCarRequest;
import com.tobeto.rentacar.services.dtos.car.requests.UpdateCarRequest;
import com.tobeto.rentacar.services.dtos.car.responses.GetCarsBetweenDailyPriceResponse;
import com.tobeto.rentacar.services.dtos.car.responses.GetCarsByFuelTypeResponse;
import com.tobeto.rentacar.services.dtos.car.responses.GetListCarResponse;
import org.springframework.stereotype.Service;

import java.time.Year;
import java.util.List;

@Service
public class CarManager implements CarService {

    private final CarRepository carRepository;


    private final ModelService modelService;
    private final GearService gearService;
    private final FuelTypeService fuelTypeService;
    private final PriceService priceService;

    public CarManager(CarRepository carRepository, ModelService modelService, GearService gearService, FuelTypeService fuelTypeService, PriceService priceService) {
        this.carRepository = carRepository;
        this.modelService = modelService;
        this.gearService = gearService;
        this.fuelTypeService = fuelTypeService;
        this.priceService = priceService;
    }

    @Override
    public void add(AddCarRequest request) {
        int currentYear = Year.now().getValue();
        if (request.getModelYear() < currentYear - 15) {
            throw new RuntimeException("Araç model yaşı 15'den küçük olmalıdır.");
        }
        Car car = new Car();
        Model model = modelService.getById(request.getModelId());
        Gear gear = gearService.getById(request.getGearId());
        FuelType fuelType = fuelTypeService.getById(request.getFuelTypeId());
        Price price = priceService.getById(request.getPriceId());



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
        int currentYear = Year.now().getValue();
        if (request.getModelYear() < currentYear - 15) {
            throw new RuntimeException("Araç model yaşı 15'den küçük olmalıdır.");
        }
        Car carToUpdate = carRepository.findById(request.getId()).orElseThrow();
        Model model = modelService.getById(request.getModelId());
        Gear gear = gearService.getById(request.getGearId());
        FuelType fuelType = fuelTypeService.getById(request.getFuelTypeId());
        Price price = priceService.getById(request.getPriceId());

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
        return carRepository.findCarsByFuelType(fuelTypeName).stream().map((car) -> new GetCarsByFuelTypeResponse(car.getId(), car.getModelYear(), car.getEngineDisplacement(), car.getModel(),car.getGear(),car.getFuelType(),car.getPrice())).toList();
    }

    @Override
    public List<GetListCarResponse> getAll() {
        return carRepository.findAllBy().stream().map((car) -> new GetListCarResponse(car.getId(), car.getModelYear(), car.getEngineDisplacement(), car.getModel(),car.getGear(),car.getFuelType(),car.getPrice())).toList();
    }

    @Override
    public Car getById(int id) {
        return carRepository.findById(id).orElseThrow();
    }


}
