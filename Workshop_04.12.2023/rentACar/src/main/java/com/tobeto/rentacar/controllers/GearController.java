package com.tobeto.rentacar.controllers;

import com.tobeto.rentacar.services.abstracts.GearService;
import com.tobeto.rentacar.services.dtos.gear.requests.AddGearRequest;
import com.tobeto.rentacar.services.dtos.gear.requests.DeleteGearRequest;
import com.tobeto.rentacar.services.dtos.gear.requests.UpdateGearRequest;
import com.tobeto.rentacar.services.dtos.gear.responses.GetListGearResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/gears")
public class GearController {
    private final GearService gearService;

    public GearController(GearService gearService) {
        this.gearService = gearService;
    }


    @PostMapping
    public void add(@RequestBody AddGearRequest request){
        gearService.add(request);
    }

    @DeleteMapping
    public void delete(@RequestBody DeleteGearRequest request){
        gearService.delete(request);
    }

    @PutMapping
    public void update(@RequestBody UpdateGearRequest request){
        gearService.update(request);
    }

    @GetMapping("getGears")
    public List<GetListGearResponse>  getAll() {
        return gearService.getAll();
    }
}
