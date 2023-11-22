package com.tobeto.rentacar.services.concretes;

import com.tobeto.rentacar.entities.Customer;
import com.tobeto.rentacar.entities.DrivingLicense;
import com.tobeto.rentacar.repositories.CustomerRepository;
import com.tobeto.rentacar.repositories.DrivingLicenseRepository;
import com.tobeto.rentacar.services.abstracts.CustomerService;
import com.tobeto.rentacar.services.dtos.customer.requests.AddCustomerRequest;
import com.tobeto.rentacar.services.dtos.customer.requests.DeleteCustomerRequest;
import com.tobeto.rentacar.services.dtos.customer.requests.UpdateCustomerRequest;
import org.springframework.stereotype.Service;

@Service
public class CustomerManager implements CustomerService {
    private final CustomerRepository customerRepository;
    private final DrivingLicenseRepository drivingLicenseRepository;

    public CustomerManager(CustomerRepository customerRepository, DrivingLicenseRepository drivingLicenseRepository) {
        this.customerRepository = customerRepository;
        this.drivingLicenseRepository = drivingLicenseRepository;
    }

    @Override
    public void add(AddCustomerRequest request) {
        Customer customer = new Customer();
        DrivingLicense drivingLicense = drivingLicenseRepository.findById(request.getDrivingLicenseId()).orElseThrow();
        customer.setName(request.getName());
        customer.setSurname(request.getSurname());
        customer.setBirthDate(request.getBirthDate());
        customer.setDrivingLicense(drivingLicense);
        customer.setAddress(request.getAddress());
        customer.setTcNo(request.getTcNo());
        customer.setPassportNo(request.getPassportNo());
        customer.setEMail(request.getEMail());
        customer.setPhone(request.getPhone());
        customerRepository.save(customer);
    }

    @Override
    public void update(UpdateCustomerRequest request) {
        Customer customerToUpdate = customerRepository.findById(request.getId()).orElseThrow();
        DrivingLicense drivingLicense = drivingLicenseRepository.findById(request.getDrivingLicenseId()).orElseThrow();
        customerToUpdate.setName(request.getName());
        customerToUpdate.setSurname(request.getSurname());
        customerToUpdate.setBirthDate(request.getBirthDate());
        customerToUpdate.setDrivingLicense(drivingLicense);
        customerToUpdate.setAddress(request.getAddress());
        customerToUpdate.setTcNo(request.getTcNo());
        customerToUpdate.setPassportNo(request.getPassportNo());
        customerToUpdate.setEMail(request.getEMail());
        customerToUpdate.setPhone(request.getPhone());
        customerRepository.save(customerToUpdate);
    }

    @Override
    public void delete(DeleteCustomerRequest request) {
        Customer customerToDelete = customerRepository.findById(request.getId()).orElseThrow();
        customerRepository.delete(customerToDelete);
    }
}
