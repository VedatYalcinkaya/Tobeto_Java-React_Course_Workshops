package com.tobeto.rentacar.services.dtos.model.requests;

import lombok.Data;

@Data
public class AddModelRequest {
    private String name;
    private int brandId;
}
