package com.tobeto.rentacar.services.abstracts;

import com.tobeto.rentacar.entities.Customer;
import com.tobeto.rentacar.services.dtos.customer.requests.AddCustomerRequest;
import com.tobeto.rentacar.services.dtos.customer.requests.DeleteCustomerRequest;
import com.tobeto.rentacar.services.dtos.customer.requests.UpdateCustomerRequest;
import com.tobeto.rentacar.services.dtos.customer.responses.GetCustomerByPhone;
import com.tobeto.rentacar.services.dtos.customer.responses.GetCustomersByNameAndSurnameResponse;

import java.util.List;

public interface CustomerService {
    void add(AddCustomerRequest request);
    void update(UpdateCustomerRequest request);
    void delete(DeleteCustomerRequest request);

    List<GetCustomersByNameAndSurnameResponse> getCustomerByNameAndSurname(String name,String surname);

    List<GetCustomerByPhone> getCustomerByPhone(String phone);

    Customer getById(int id);

}
