package com.tobeto.rentacar.controllers;

import com.tobeto.rentacar.services.abstracts.RentService;
import com.tobeto.rentacar.services.dtos.rent.requests.AddRentRequest;
import com.tobeto.rentacar.services.dtos.rent.requests.DeleteRentRequest;
import com.tobeto.rentacar.services.dtos.rent.requests.UpdateRentRequest;
import com.tobeto.rentacar.services.dtos.rent.responses.GetAvailableCarsResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/rents")
public class RentController {
    private final RentService rentService;

    public RentController(RentService rentService) {
        this.rentService = rentService;
    }

    @PostMapping
    public void add(@RequestBody @Valid AddRentRequest request){
        rentService.add(request);
    }

    @PutMapping
    public void update(@RequestBody @Valid UpdateRentRequest request){
        rentService.update(request);
    }

    @DeleteMapping
    public void delete(@RequestBody DeleteRentRequest request){
        rentService.delete(request);
    }

    @GetMapping("/available")
    public List<GetAvailableCarsResponse> getAvailableCars(){
        LocalDate currentDate = LocalDate.now();
        return rentService.getAvailableCars(currentDate);
    }

}
