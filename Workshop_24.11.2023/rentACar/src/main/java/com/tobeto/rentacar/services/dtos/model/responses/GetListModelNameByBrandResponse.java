package com.tobeto.rentacar.services.dtos.model.responses;

import com.tobeto.rentacar.entities.Brand;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetListModelNameByBrandResponse {
    private int id;
    private String name;
}
