package com.tobeto.rentacar.services.abstracts;

import com.tobeto.rentacar.entities.Car;
import com.tobeto.rentacar.services.dtos.car.requests.AddCarRequest;
import com.tobeto.rentacar.services.dtos.car.requests.DeleteCarRequest;
import com.tobeto.rentacar.services.dtos.car.requests.UpdateCarRequest;
import com.tobeto.rentacar.services.dtos.car.responses.GetCarsBetweenDailyPriceResponse;
import com.tobeto.rentacar.services.dtos.car.responses.GetCarsByFuelTypeResponse;
import com.tobeto.rentacar.services.dtos.car.responses.GetListCarResponse;

import java.util.List;

public interface CarService {
    void add(AddCarRequest request);
    void update(UpdateCarRequest request);
    void delete(DeleteCarRequest request);

    List<GetCarsBetweenDailyPriceResponse> getCarsBetweenDailyPrices(double minDailyPrice, double maxDailyPrice);

    List<GetCarsByFuelTypeResponse> getCarsByFuelType(String fuelTypeName);

    List<GetListCarResponse> getAll();

    Car getById(int id);


}
