package com.tobeto.rentacar.services.abstracts;

import com.tobeto.rentacar.services.dtos.gear.requests.AddGearRequest;
import com.tobeto.rentacar.services.dtos.gear.requests.DeleteGearRequest;
import com.tobeto.rentacar.services.dtos.gear.requests.UpdateGearRequest;
import com.tobeto.rentacar.services.dtos.model.requests.AddModelRequest;
import com.tobeto.rentacar.services.dtos.model.requests.DeleteModelRequest;
import com.tobeto.rentacar.services.dtos.model.requests.UpdateModelRequest;

public interface GearService {
    void add(AddGearRequest request);

    void update(UpdateGearRequest request);

    void delete(DeleteGearRequest request);
}
