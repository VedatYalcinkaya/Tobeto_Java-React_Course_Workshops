package com.tobeto.rentacar.services.concretes;

import com.tobeto.rentacar.entities.Car;
import com.tobeto.rentacar.entities.Customer;
import com.tobeto.rentacar.entities.Payment;
import com.tobeto.rentacar.entities.Rent;
import com.tobeto.rentacar.repositories.CarRepository;
import com.tobeto.rentacar.repositories.CustomerRepository;
import com.tobeto.rentacar.repositories.PaymentRepository;
import com.tobeto.rentacar.repositories.RentRepository;
import com.tobeto.rentacar.services.abstracts.CustomerService;
import com.tobeto.rentacar.services.abstracts.RentService;
import com.tobeto.rentacar.services.dtos.rent.requests.AddRentRequest;
import com.tobeto.rentacar.services.dtos.rent.requests.DeleteRentRequest;
import com.tobeto.rentacar.services.dtos.rent.requests.UpdateRentRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class RentManager implements RentService {

    private final RentRepository rentRepository;
    private final CarRepository carRepository;
    private final CustomerRepository customerRepository;
    private final PaymentRepository paymentRepository;

    public RentManager(RentRepository rentRepository, CarRepository carRepository, CustomerRepository customerRepository, PaymentRepository paymentRepository) {
        this.rentRepository = rentRepository;
        this.carRepository = carRepository;
        this.customerRepository = customerRepository;
        this.paymentRepository = paymentRepository;
    }

    @Override
    public void add(@RequestBody AddRentRequest request) {
        Rent rent = new Rent();
        Car car = carRepository.findById(request.getCarId()).orElseThrow();
        Customer customer = customerRepository.findById(request.getCustomerId()).orElseThrow();
        Payment payment = paymentRepository.findById(request.getPaymentId()).orElseThrow();

        rent.setCar(car);
        rent.setCustomer(customer);
        rent.setPayment(payment);
        rent.setRentStartDate(request.getRentStartDate());
        rent.setRentEndDate(request.getRentEndDate());
        rentRepository.save(rent);
    }

    @Override
    public void update(@RequestBody UpdateRentRequest request) {
        Rent rentToUpdate = rentRepository.findById(request.getId()).orElseThrow();
        Car car = carRepository.findById(request.getCarId()).orElseThrow();
        Customer customer = customerRepository.findById(request.getCustomerId()).orElseThrow();
        Payment payment = paymentRepository.findById(request.getPaymentId()).orElseThrow();

        rentToUpdate.setCar(car);
        rentToUpdate.setCustomer(customer);
        rentToUpdate.setPayment(payment);
        rentToUpdate.setRentStartDate(request.getRentStartDate());
        rentToUpdate.setRentEndDate(request.getRentEndDate());
        rentRepository.save(rentToUpdate);

    }

    @Override
    public void delete(@RequestBody DeleteRentRequest request) {
        Rent rentToDelete = rentRepository.findById(request.getId()).orElseThrow();
        rentRepository.delete(rentToDelete);
    }
}
