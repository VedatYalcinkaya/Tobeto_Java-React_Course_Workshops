package com.tobeto.rentacar.services.concretes;

import com.tobeto.rentacar.entities.Gear;
import com.tobeto.rentacar.repositories.GearRepository;
import com.tobeto.rentacar.services.abstracts.GearService;
import com.tobeto.rentacar.services.dtos.gear.requests.AddGearRequest;
import com.tobeto.rentacar.services.dtos.gear.requests.DeleteGearRequest;
import com.tobeto.rentacar.services.dtos.gear.requests.UpdateGearRequest;
import com.tobeto.rentacar.services.dtos.gear.responses.GetListGearResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GearManager implements GearService {

    private final GearRepository gearRepository;

    public GearManager(GearRepository gearRepository) {
        this.gearRepository = gearRepository;
    }


    @Override
    public void add(AddGearRequest request) {
        Gear gear = new Gear();
        gear.setType(request.getType());
        gear.setGearCount(request.getGearCount());
        gearRepository.save(gear);
    }

    @Override
    public void update(UpdateGearRequest request) {
        Gear gearToUpdate = gearRepository.findById(request.getId()).orElseThrow();
        gearToUpdate.setType(request.getType());
        gearToUpdate.setGearCount(request.getGearCount());

        gearRepository.save(gearToUpdate);
    }

    @Override
    public void delete(DeleteGearRequest request) {
        Gear gearToDelete = gearRepository.findById(request.getId()).orElseThrow();
        gearRepository.delete(gearToDelete);
    }

    @Override
    public List<GetListGearResponse> getAll() {
        return gearRepository.findAll().stream().map(((gear) -> new GetListGearResponse(gear.getId(), gear.getType(), gear.getGearCount()) )).toList();
    }
}
