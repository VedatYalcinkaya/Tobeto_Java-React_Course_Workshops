package com.tobeto.rentacar.services.abstracts;

import com.tobeto.rentacar.entities.Brand;
import com.tobeto.rentacar.services.dtos.brand.requests.AddBrandRequest;
import com.tobeto.rentacar.services.dtos.brand.requests.DeleteBrandRequest;
import com.tobeto.rentacar.services.dtos.brand.requests.UpdateBrandRequest;
import com.tobeto.rentacar.services.dtos.brand.responses.GetListBrandResponse;

import java.util.List;

public interface BrandService {
    void add(AddBrandRequest request);

    void update(UpdateBrandRequest request);

    void delete(DeleteBrandRequest request);

    List<Brand> getByName(String name);

    List<GetListBrandResponse> getByNameDto(String name);
}
