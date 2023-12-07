package com.tobeto.rentacar.services.dtos.customer.requests;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AddCustomerRequest {
    @NotNull(message = "Ad boş bırakılamaz")
    @Size(max = 30, message = "Ad 30 karakterden uzun olamaz")
    private String name;

    @NotNull(message = "Soyad boş bırakılamaz")
    @Size(max = 30, message = "Soyad 30 karakterden uzun olamaz")
    private String surname;

    @Past(message = "Doğum tarihi günümüzden önce olmalı")
    private LocalDate birthDate;

    @NotNull(message = "Ehliyet boş bırakılamaz")
    private int drivingLicenseId;

    @NotNull(message = "Adress boş bırakılamaz")
    @Size(max = 100, message = "Adres 100 karakterden uzun olamaz")
    private String address;

    @Size(min = 11,max = 11,message = "Tc 11 haneli olmalıdır")
    private String tcNo;

    private String passportNo;

    @Email(message = "Bu bir email adresi değil")
    private String eMail;

    @NotNull(message = "Telefon boş bıralılamaz")
    private String phone;
}
