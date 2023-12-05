package com.tobeto.rentacar.services.concretes;

import com.tobeto.rentacar.entities.DrivingLicense;
import com.tobeto.rentacar.repositories.DrivingLicenseRepository;
import com.tobeto.rentacar.services.abstracts.DrivingLicenseService;
import com.tobeto.rentacar.services.dtos.drivinglicense.requests.AddDrivingLicenseRequest;
import com.tobeto.rentacar.services.dtos.drivinglicense.requests.DeleteDrivingLicenseRequest;
import com.tobeto.rentacar.services.dtos.drivinglicense.requests.UpdateDrivingLicenseRequest;
import org.springframework.stereotype.Service;

@Service
public class DrivingLicenseManager implements DrivingLicenseService {
    private final DrivingLicenseRepository drivingLicenseRepository;

    public DrivingLicenseManager(DrivingLicenseRepository drivingLicenseRepository) {
        this.drivingLicenseRepository = drivingLicenseRepository;
    }

    @Override
    public void add(AddDrivingLicenseRequest request) {
        DrivingLicense drivingLicense = new DrivingLicense();
        drivingLicense.setName(request.getName());
        drivingLicenseRepository.save(drivingLicense);
    }

    @Override
    public void update(UpdateDrivingLicenseRequest request) {
        DrivingLicense drivingLicenseToUpdate = drivingLicenseRepository.findById(request.getId()).orElseThrow();
        drivingLicenseToUpdate.setName(request.getName());
        drivingLicenseRepository.save(drivingLicenseToUpdate);
    }

    @Override
    public void delete(DeleteDrivingLicenseRequest request) {
        DrivingLicense drivingLicenseToDelete = drivingLicenseRepository.findById(request.getId()).orElseThrow();
        drivingLicenseRepository.delete(drivingLicenseToDelete);
    }
}
