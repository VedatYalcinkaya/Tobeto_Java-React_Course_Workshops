package com.tobeto.rentacar.services.abstracts;

import com.tobeto.rentacar.services.dtos.rent.requests.AddRentRequest;
import com.tobeto.rentacar.services.dtos.rent.requests.DeleteRentRequest;
import com.tobeto.rentacar.services.dtos.rent.requests.UpdateRentRequest;

public interface RentService {
    void add(AddRentRequest request);
    void update(UpdateRentRequest request);
    void delete(DeleteRentRequest request);
}
