package com.tobeto.rentacar.services.dtos.rent.requests;

import lombok.Data;

import java.time.LocalDate;
@Data
public class AddRentRequest {
    private int carId;
    private LocalDate rentStartDate;
    private LocalDate rentEndDate;
    private int customerId;
    private  int paymentId;

}
