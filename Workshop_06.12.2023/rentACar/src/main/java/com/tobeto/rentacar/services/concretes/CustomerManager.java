package com.tobeto.rentacar.services.concretes;

import com.tobeto.rentacar.entities.Customer;
import com.tobeto.rentacar.entities.DrivingLicense;
import com.tobeto.rentacar.repositories.CustomerRepository;
import com.tobeto.rentacar.services.abstracts.CustomerService;
import com.tobeto.rentacar.services.abstracts.DrivingLicenseService;
import com.tobeto.rentacar.services.dtos.customer.requests.AddCustomerRequest;
import com.tobeto.rentacar.services.dtos.customer.requests.DeleteCustomerRequest;
import com.tobeto.rentacar.services.dtos.customer.requests.UpdateCustomerRequest;
import com.tobeto.rentacar.services.dtos.customer.responses.GetCustomerByPhone;
import com.tobeto.rentacar.services.dtos.customer.responses.GetCustomersByNameAndSurnameResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerManager implements CustomerService {
    private final CustomerRepository customerRepository;
    private final DrivingLicenseService drivingLicenseService;

    public CustomerManager(CustomerRepository customerRepository, DrivingLicenseService drivingLicenseService) {
        this.customerRepository = customerRepository;
        this.drivingLicenseService = drivingLicenseService;
    }


    @Override
    public void add(AddCustomerRequest request) {
        if (customerRepository.existsByTcNo(request.getTcNo())){
            throw new RuntimeException("Aynı Tc ile birden fazla kullanıcı eklenemez!");
        }

        if (customerRepository.existsByPassportNo(request.getPassportNo())){
            throw new RuntimeException("Aynı pasaport numarası ile birden fazla kullanıcı eklememez.");
        }

        Customer customer = new Customer();
        DrivingLicense drivingLicense = drivingLicenseService.getById(request.getDrivingLicenseId());
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
        DrivingLicense drivingLicense = drivingLicenseService.getById(request.getDrivingLicenseId());
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

    @Override
    public List<GetCustomersByNameAndSurnameResponse> getCustomerByNameAndSurname(String name, String surname) {
        return customerRepository.findCustomersByNameAndSurname(name,surname).stream().map((customer) -> new GetCustomersByNameAndSurnameResponse(customer.getId(), customer.getName(), customer.getSurname(), customer.getPhone())).toList();
    }

    @Override
    public List<GetCustomerByPhone> getCustomerByPhone(String phone) {
        return customerRepository.findCustomerByPhone(phone).stream().map((customer) -> new GetCustomerByPhone(customer.getId(), customer.getName(), customer.getSurname(), customer.getPhone())).toList();
    }

    @Override
    public Customer getById(int id) {
        return customerRepository.findById(id).orElseThrow();
    }
}
