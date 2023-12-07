package com.tobeto.rentacar.services.concretes;

import com.tobeto.rentacar.entities.Car;
import com.tobeto.rentacar.entities.Customer;
import com.tobeto.rentacar.entities.Payment;
import com.tobeto.rentacar.entities.Rent;
import com.tobeto.rentacar.repositories.RentRepository;
import com.tobeto.rentacar.services.abstracts.CarService;
import com.tobeto.rentacar.services.abstracts.CustomerService;
import com.tobeto.rentacar.services.abstracts.PaymentService;
import com.tobeto.rentacar.services.abstracts.RentService;
import com.tobeto.rentacar.services.dtos.rent.requests.AddRentRequest;
import com.tobeto.rentacar.services.dtos.rent.requests.DeleteRentRequest;
import com.tobeto.rentacar.services.dtos.rent.requests.UpdateRentRequest;
import com.tobeto.rentacar.services.dtos.rent.responses.GetAvailableCarsResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.List;

@Service
public class RentManager implements RentService {

    private final RentRepository rentRepository;
    private final CarService carService;
    private final CustomerService customerService;
    private final PaymentService paymentService;


    public RentManager(RentRepository rentRepository, CarService carService, CustomerService customerService, PaymentService paymentService) {
        this.rentRepository = rentRepository;
        this.carService = carService;
        this.customerService = customerService;
        this.paymentService = paymentService;
    }

    @Override
    public void add(@RequestBody AddRentRequest request) {
        if (request.getRentEndDate().isBefore(request.getRentStartDate())) {
            throw new RuntimeException("Kiralama bitiş tarihi, başlangıç tarihinden önce olamaz");
        }
        Rent rent = new Rent();
        Car car = carService.getById(request.getCarId());
        Customer customer = customerService.getById(request.getCustomerId());
        Payment payment = paymentService.getById(request.getPaymentId());

        rent.setCar(car);
        rent.setCustomer(customer);
        rent.setPayment(payment);
        rent.setRentStartDate(request.getRentStartDate());
        rent.setRentEndDate(request.getRentEndDate());
        rentRepository.save(rent);
    }

    @Override
    public void update(@RequestBody UpdateRentRequest request) {
        if (request.getRentEndDate().isBefore(request.getRentStartDate())) {
            throw new RuntimeException("Kiralama bitiş tarihi, başlangıç tarihinden önce olamaz");
        }
        Rent rentToUpdate = rentRepository.findById(request.getId()).orElseThrow();
        Car car = carService.getById(request.getCarId());
        Customer customer = customerService.getById(request.getCustomerId());
        Payment payment = paymentService.getById(request.getPaymentId());

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

    @Override
    public List<GetAvailableCarsResponse> getAvailableCars(LocalDate currentDate) {
        return rentRepository.findAvailableCars(currentDate).stream().map((rent) -> new GetAvailableCarsResponse(rent.getCar())).toList();
    }

    @Override
    public Rent getById(int id) {
        return rentRepository.findById(id).orElseThrow();
    }
}
