package com.tobeto.rentacar.repositories;

import com.tobeto.rentacar.entities.DrivingLicense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DrivingLicenseRepository extends JpaRepository<DrivingLicense, Integer> {

}
