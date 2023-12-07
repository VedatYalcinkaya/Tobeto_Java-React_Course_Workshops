package com.tobeto.rentacar.services.dtos.customer.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;
@Data
public class UpdateCustomerRequest {
    private int id;

    @NotBlank(message = "Ad boş bırakılamaz")
    @Size(max = 30, message = "Ad 30 karakterden uzun olamaz")
    private String name;

    @NotBlank(message = "Soyad boş bırakılamaz")
    @Size(max = 30, message = "Soyad 30 karakterden uzun olamaz")
    private String surname;

    @NotBlank(message = "Soyad boş bırakılamaz")
    @Past(message = "Doğum tarihi günümüzden önce olmalı")
    private LocalDate birthDate;

    @NotBlank(message = "Ehliyet boş bırakılamaz")
    private int drivingLicenseId;

    @NotBlank(message = "Adress boş bırakılamaz")
    @Size(max = 100, message = "Adres 100 karakterden uzun olamaz")
    private String address;

    @Size(min = 11,max = 11,message = "Tc 11 haneli olmalıdır")
    private String tcNo;

    private String passportNo;

    @Email(message = "Bu bir email adresi değil")
    private String eMail;

    @NotBlank(message = "Telefon boş bıralılamaz")
    private String phone;

}
