package com.tobeto.rentacar.services.abstracts;

import com.tobeto.rentacar.services.dtos.brand.requests.AddBrandRequest;
import com.tobeto.rentacar.services.dtos.brand.requests.DeleteBrandRequest;
import com.tobeto.rentacar.services.dtos.brand.requests.UpdateBrandRequest;
import com.tobeto.rentacar.services.dtos.fueltype.requests.AddFuelTypeRequest;
import com.tobeto.rentacar.services.dtos.fueltype.requests.DeleteFuelTypeRequest;
import com.tobeto.rentacar.services.dtos.fueltype.requests.UpdateFuelTypeRequest;

public interface FuelTypeService {
    void add(AddFuelTypeRequest request);

    void delete(DeleteFuelTypeRequest request);

    void update(UpdateFuelTypeRequest request);
}
