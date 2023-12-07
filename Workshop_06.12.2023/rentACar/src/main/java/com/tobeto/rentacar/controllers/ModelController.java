package com.tobeto.rentacar.controllers;


import com.tobeto.rentacar.services.abstracts.ModelService;
import com.tobeto.rentacar.services.dtos.model.requests.AddModelRequest;
import com.tobeto.rentacar.services.dtos.model.requests.DeleteModelRequest;
import com.tobeto.rentacar.services.dtos.model.requests.UpdateModelRequest;
import com.tobeto.rentacar.services.dtos.model.responses.GetListModelNameByBrandResponse;
import com.tobeto.rentacar.services.dtos.model.responses.GetListModelResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/models")
public class ModelController {

    private final ModelService modelService;

    public ModelController(ModelService modelService) {
        this.modelService = modelService;
    }

    @PostMapping
    public void add(@RequestBody @Valid AddModelRequest request){
        modelService.add(request);
    }

    @DeleteMapping
    public void delete(@RequestBody DeleteModelRequest request){
        modelService.delete(request);
    }

    @PutMapping
    public void update(@RequestBody @Valid UpdateModelRequest request){
        modelService.update(request);
    }

    @GetMapping
    public List<GetListModelResponse> getByNameDto(@RequestParam String name) {
        return modelService.getByNameDto(name);
    }

    @GetMapping("byBrand")
    public List<GetListModelNameByBrandResponse> getByBrand(@RequestParam String brandName) {
        return modelService.getByBrandDto(brandName);
    }
}
