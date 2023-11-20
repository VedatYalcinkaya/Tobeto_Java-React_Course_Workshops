package com.tobeto.rentacar.repositories;

import com.tobeto.rentacar.entities.Gear;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GearRepository extends JpaRepository<Gear, Integer> {
}
