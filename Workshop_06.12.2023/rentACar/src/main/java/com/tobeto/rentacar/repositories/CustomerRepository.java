package com.tobeto.rentacar.repositories;

import com.tobeto.rentacar.entities.Customer;
import com.tobeto.rentacar.services.dtos.customer.responses.GetCustomerByPhone;
import com.tobeto.rentacar.services.dtos.customer.responses.GetCustomersByNameAndSurnameResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    @Query("SELECT new com.tobeto.rentacar.services.dtos.customer.responses.GetCustomersByNameAndSurnameResponse(c.id, c.name, c.surname, c.phone) " +
            "FROM Customer c WHERE LOWER(c.name) = LOWER(:name) AND LOWER(c.surname) = LOWER(:surname)")
    List<GetCustomersByNameAndSurnameResponse> findCustomersByNameAndSurname(String name, String surname);

    @Query("SELECT new com.tobeto.rentacar.services.dtos.customer.responses.GetCustomerByPhone(c.id, c.name, c.surname, c.phone) " +
            "FROM Customer c WHERE c.phone = :phone")
    List<GetCustomerByPhone> findCustomerByPhone(String phone);

    boolean existsByTcNo(String tcNo);

    boolean existsByPassportNo(String passportNo);
}
