package com.tobeto.rentacar.services.dtos.rent.requests;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;
@Data
public class AddRentRequest {
    @NotBlank(message = "CarId boş olamaz")
    private int carId;

    @NotBlank(message = "Kiralama başlangıç tarihi boş olamaz")
    private LocalDate rentStartDate;

    @NotBlank(message = "Kiralama bitiş tarihi boş olamaz")
    private LocalDate rentEndDate;

    @NotBlank(message = "CustomerId boş olamaz")
    private int customerId;

    @NotBlank(message = "PaymentId boş olamaz")
    @Min(value = 1, message = "Geçerli bir ödeme ID giriniz")
    private int paymentId;
}
