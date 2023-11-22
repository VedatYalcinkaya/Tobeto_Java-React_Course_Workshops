package com.tobeto.rentacar.services.abstracts;

import com.tobeto.rentacar.services.dtos.drivinglicense.requests.AddDrivingLicenseRequest;
import com.tobeto.rentacar.services.dtos.drivinglicense.requests.DeleteDrivingLicenseRequest;
import com.tobeto.rentacar.services.dtos.drivinglicense.requests.UpdateDrivingLicenseRequest;

public interface DrivingLicenseService {
    void add(AddDrivingLicenseRequest request);
    void update(UpdateDrivingLicenseRequest request);
    void delete(DeleteDrivingLicenseRequest request);
}
