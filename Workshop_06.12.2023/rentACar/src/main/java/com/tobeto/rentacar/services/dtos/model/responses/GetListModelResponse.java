package com.tobeto.rentacar.services.dtos.model.responses;

import com.tobeto.rentacar.entities.Brand;
import com.tobeto.rentacar.services.dtos.brand.responses.GetListBrandResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetListModelResponse {
    private int id;
    private String name;
    private GetListBrandResponse brand;
}
