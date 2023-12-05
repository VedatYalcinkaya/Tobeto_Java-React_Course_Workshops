package com.tobeto.rentacar.services.abstracts;

import com.tobeto.rentacar.services.dtos.price.requests.AddPriceRequest;
import com.tobeto.rentacar.services.dtos.price.requests.DeletePriceRequest;
import com.tobeto.rentacar.services.dtos.price.requests.UpdatePriceRequest;
import com.tobeto.rentacar.services.dtos.price.responses.GetListPriceResponse;

import java.util.List;

public interface PriceService {
    void add(AddPriceRequest request);
    void update(UpdatePriceRequest request);
    void delete(DeletePriceRequest request);

    List<GetListPriceResponse> getAll();
}
