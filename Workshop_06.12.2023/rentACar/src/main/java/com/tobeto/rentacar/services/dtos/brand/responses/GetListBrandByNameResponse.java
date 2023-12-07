package com.tobeto.rentacar.services.dtos.brand.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetListBrandByNameResponse {
    private int id;
    private String name;
}
