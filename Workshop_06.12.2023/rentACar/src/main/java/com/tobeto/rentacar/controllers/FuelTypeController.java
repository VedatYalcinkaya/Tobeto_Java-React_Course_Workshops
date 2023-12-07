package com.tobeto.rentacar.controllers;

import com.tobeto.rentacar.services.abstracts.FuelTypeService;
import com.tobeto.rentacar.services.dtos.fueltype.requests.AddFuelTypeRequest;
import com.tobeto.rentacar.services.dtos.fueltype.requests.DeleteFuelTypeRequest;
import com.tobeto.rentacar.services.dtos.fueltype.requests.UpdateFuelTypeRequest;
import com.tobeto.rentacar.services.dtos.fueltype.responses.GetListFuelTypeResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/fuel-types")
public class FuelTypeController {
    private final FuelTypeService fuelTypeService;


    public FuelTypeController(FuelTypeService fuelTypeService) {
        this.fuelTypeService = fuelTypeService;
    }

    @PostMapping
    public void add(@RequestBody @Valid AddFuelTypeRequest request){
        fuelTypeService.add(request);
    }

    @PutMapping
    public void update(@RequestBody @Valid UpdateFuelTypeRequest request){
        fuelTypeService.update(request);
    }

    @DeleteMapping
    public void delete(@RequestBody DeleteFuelTypeRequest request){
        fuelTypeService.delete(request);
    }

    @GetMapping("getAll")
    public List<GetListFuelTypeResponse> getAll(){
        return fuelTypeService.getAll();
    }
}
