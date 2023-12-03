package com.tobeto.rentacar.services.abstracts;

import com.tobeto.rentacar.entities.Brand;
import com.tobeto.rentacar.services.dtos.model.requests.AddModelRequest;
import com.tobeto.rentacar.services.dtos.model.requests.DeleteModelRequest;
import com.tobeto.rentacar.services.dtos.model.requests.UpdateModelRequest;
import com.tobeto.rentacar.services.dtos.model.responses.GetListModelNameByBrandResponse;
import com.tobeto.rentacar.services.dtos.model.responses.GetListModelResponse;

import java.util.List;

public interface ModelService {
    void add(AddModelRequest request);

    void update(UpdateModelRequest request);

    void delete(DeleteModelRequest request);

    List<GetListModelResponse> getByNameDto(String name);

    List<GetListModelNameByBrandResponse> getByBrandDto(String brandName);
}
