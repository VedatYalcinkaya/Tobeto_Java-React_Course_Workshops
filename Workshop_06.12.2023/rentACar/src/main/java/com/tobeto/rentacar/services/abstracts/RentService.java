package com.tobeto.rentacar.services.abstracts;

import com.tobeto.rentacar.entities.Rent;
import com.tobeto.rentacar.services.dtos.rent.requests.AddRentRequest;
import com.tobeto.rentacar.services.dtos.rent.requests.DeleteRentRequest;
import com.tobeto.rentacar.services.dtos.rent.requests.UpdateRentRequest;
import com.tobeto.rentacar.services.dtos.rent.responses.GetAvailableCarsResponse;

import java.time.LocalDate;
import java.util.List;

public interface RentService {
    void add(AddRentRequest request);
    void update(UpdateRentRequest request);
    void delete(DeleteRentRequest request);

    List<GetAvailableCarsResponse> getAvailableCars(LocalDate currentDate);

    Rent getById(int id);
}
