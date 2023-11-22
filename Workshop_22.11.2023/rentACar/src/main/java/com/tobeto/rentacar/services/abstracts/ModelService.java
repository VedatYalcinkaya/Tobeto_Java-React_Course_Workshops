package com.tobeto.rentacar.services.abstracts;

import com.tobeto.rentacar.services.dtos.model.requests.AddModelRequest;
import com.tobeto.rentacar.services.dtos.model.requests.DeleteModelRequest;
import com.tobeto.rentacar.services.dtos.model.requests.UpdateModelRequest;

public interface ModelService {
    void add(AddModelRequest request);

    void update(UpdateModelRequest request);

    void delete(DeleteModelRequest request);
}
