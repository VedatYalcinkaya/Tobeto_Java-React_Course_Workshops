package com.tobeto.rentacar.services.abstracts;

import com.tobeto.rentacar.services.dtos.customer.requests.AddCustomerRequest;
import com.tobeto.rentacar.services.dtos.customer.requests.DeleteCustomerRequest;
import com.tobeto.rentacar.services.dtos.customer.requests.UpdateCustomerRequest;

public interface CustomerService {
    void add(AddCustomerRequest request);
    void update(UpdateCustomerRequest request);
    void delete(DeleteCustomerRequest request);
}
