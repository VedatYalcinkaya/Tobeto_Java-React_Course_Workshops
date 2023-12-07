package com.tobeto.rentacar.services.dtos.rent.requests;

import lombok.Data;

import java.time.LocalDate;
@Data
public class UpdateRentRequest {
    private int id;
    private int carId;
    private LocalDate rentStartDate;
    private LocalDate rentEndDate;
    private int customerId;
    private  int paymentId;
}
