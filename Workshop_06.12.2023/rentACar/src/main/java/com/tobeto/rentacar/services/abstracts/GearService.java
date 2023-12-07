package com.tobeto.rentacar.services.abstracts;

import com.tobeto.rentacar.entities.Gear;
import com.tobeto.rentacar.services.dtos.gear.requests.AddGearRequest;
import com.tobeto.rentacar.services.dtos.gear.requests.DeleteGearRequest;
import com.tobeto.rentacar.services.dtos.gear.requests.UpdateGearRequest;
import com.tobeto.rentacar.services.dtos.gear.responses.GetListGearResponse;

import java.util.List;

public interface GearService {
    void add(AddGearRequest request);

    void update(UpdateGearRequest request);

    void delete(DeleteGearRequest request);

    List<GetListGearResponse> getAll();

    Gear getById(int id);
}
