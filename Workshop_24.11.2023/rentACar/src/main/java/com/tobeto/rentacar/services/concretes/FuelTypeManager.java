package com.tobeto.rentacar.services.concretes;

import com.tobeto.rentacar.entities.FuelType;
import com.tobeto.rentacar.repositories.FuelTypeRepository;
import com.tobeto.rentacar.services.abstracts.FuelTypeService;
import com.tobeto.rentacar.services.dtos.fueltype.requests.AddFuelTypeRequest;
import com.tobeto.rentacar.services.dtos.fueltype.requests.DeleteFuelTypeRequest;
import com.tobeto.rentacar.services.dtos.fueltype.requests.UpdateFuelTypeRequest;
import org.springframework.stereotype.Service;

@Service
public class FuelTypeManager implements FuelTypeService {

    private final FuelTypeRepository fuelTypeRepository;

    public FuelTypeManager(FuelTypeRepository fuelTypeRepository) {
        this.fuelTypeRepository = fuelTypeRepository;
    }

    @Override
    public void add(AddFuelTypeRequest request) {
        FuelType fuelType = new FuelType();
        fuelType.setName(request.getName());
        fuelTypeRepository.save(fuelType);
    }

    @Override
    public void delete(DeleteFuelTypeRequest request) {
        FuelType fuelTypeToDelete = fuelTypeRepository.findById(request.getId()).orElseThrow();
        fuelTypeRepository.delete(fuelTypeToDelete);
    }

    @Override
    public void update(UpdateFuelTypeRequest request) {
        FuelType fuelTypeToUpdate = fuelTypeRepository.findById(request.getId()).orElseThrow();
        fuelTypeToUpdate.setName(request.getName());
        fuelTypeRepository.save(fuelTypeToUpdate);

    }
}
