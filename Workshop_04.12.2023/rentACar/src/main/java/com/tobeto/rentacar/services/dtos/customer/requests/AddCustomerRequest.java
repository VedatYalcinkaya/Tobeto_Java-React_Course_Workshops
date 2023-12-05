package com.tobeto.rentacar.services.dtos.customer.requests;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AddCustomerRequest {
    private String name;
    private String surname;
    private LocalDate birthDate;
    private int drivingLicenseId;
    private String address;
    private String tcNo;
    private String passportNo;
    private String eMail;
    private String phone;
}
