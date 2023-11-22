package com.tobeto.rentacar.controllers;

import com.tobeto.rentacar.services.abstracts.DrivingLicenseService;
import com.tobeto.rentacar.services.dtos.drivinglicense.requests.AddDrivingLicenseRequest;
import com.tobeto.rentacar.services.dtos.drivinglicense.requests.DeleteDrivingLicenseRequest;
import com.tobeto.rentacar.services.dtos.drivinglicense.requests.UpdateDrivingLicenseRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/driving-licenses")
public class DrivingLicenseContoller {

    private final DrivingLicenseService drivingLicenseService;

    public DrivingLicenseContoller(DrivingLicenseService drivingLicenseService) {
        this.drivingLicenseService = drivingLicenseService;
    }

    @PostMapping
    public void add(@RequestBody AddDrivingLicenseRequest request){
        drivingLicenseService.add(request);
    }

    @PutMapping
    public void update(@RequestBody UpdateDrivingLicenseRequest request){
        drivingLicenseService.update(request);
    }

    @DeleteMapping
    public void delete(@RequestBody DeleteDrivingLicenseRequest request){
        drivingLicenseService.delete(request);
    }
}
