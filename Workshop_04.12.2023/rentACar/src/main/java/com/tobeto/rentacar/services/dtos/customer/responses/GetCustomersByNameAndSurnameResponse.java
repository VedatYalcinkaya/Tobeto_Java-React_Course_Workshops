package com.tobeto.rentacar.services.dtos.customer.responses;

import com.tobeto.rentacar.entities.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCustomersByNameAndSurnameResponse {
    private int id;
    private String name;
    private String surname;
    private String phone;
}
