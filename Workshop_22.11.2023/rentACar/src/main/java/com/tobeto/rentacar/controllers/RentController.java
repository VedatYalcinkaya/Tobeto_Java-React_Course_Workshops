package com.tobeto.rentacar.controllers;

import com.tobeto.rentacar.services.abstracts.RentService;
import com.tobeto.rentacar.services.dtos.rent.requests.AddRentRequest;
import com.tobeto.rentacar.services.dtos.rent.requests.DeleteRentRequest;
import com.tobeto.rentacar.services.dtos.rent.requests.UpdateRentRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/rents")
public class RentController {
    private final RentService rentService;

    public RentController(RentService rentService) {
        this.rentService = rentService;
    }

    @PostMapping
    public void add(@RequestBody AddRentRequest request){
        rentService.add(request);
    }

    @PutMapping
    public void update(@RequestBody UpdateRentRequest request){
        rentService.update(request);
    }

    @DeleteMapping
    public void delete(@RequestBody DeleteRentRequest request){
        rentService.delete(request);
    }
}
