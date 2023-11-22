package com.tobeto.rentacar.services.abstracts;

import com.tobeto.rentacar.services.dtos.car.requests.AddCarRequest;
import com.tobeto.rentacar.services.dtos.car.requests.DeleteCarRequest;
import com.tobeto.rentacar.services.dtos.car.requests.UpdateCarRequest;

public interface CarService {
    void add(AddCarRequest request);
    void update(UpdateCarRequest request);
    void delete(DeleteCarRequest request);
}
