package com.tobeto.rentacar.services.abstracts;

import com.tobeto.rentacar.services.dtos.fueltype.requests.AddFuelTypeRequest;
import com.tobeto.rentacar.services.dtos.fueltype.requests.DeleteFuelTypeRequest;
import com.tobeto.rentacar.services.dtos.fueltype.requests.UpdateFuelTypeRequest;
import com.tobeto.rentacar.services.dtos.fueltype.responses.GetListFuelTypeResponse;

import java.util.List;

public interface FuelTypeService {
    void add(AddFuelTypeRequest request);

    void delete(DeleteFuelTypeRequest request);

    void update(UpdateFuelTypeRequest request);

    List<GetListFuelTypeResponse> getAll();
}
