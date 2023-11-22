package com.tobeto.rentacar.services.abstracts;

import com.tobeto.rentacar.services.dtos.price.requests.AddPriceRequest;
import com.tobeto.rentacar.services.dtos.price.requests.DeletePriceRequest;
import com.tobeto.rentacar.services.dtos.price.requests.UpdatePriceRequest;

public interface PriceService {
    void add(AddPriceRequest request);
    void update(UpdatePriceRequest request);
    void delete(DeletePriceRequest request);
}
