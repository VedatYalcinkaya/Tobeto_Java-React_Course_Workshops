package com.tobeto.rentacar.controllers;

import com.tobeto.rentacar.entities.Model;
import com.tobeto.rentacar.repositories.ModelRepository;
import com.tobeto.rentacar.services.abstracts.ModelService;
import com.tobeto.rentacar.services.dtos.model.requests.AddModelRequest;
import com.tobeto.rentacar.services.dtos.model.requests.DeleteModelRequest;
import com.tobeto.rentacar.services.dtos.model.requests.UpdateModelRequest;
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
    public void add(@RequestBody AddModelRequest request){
        modelService.add(request);
    }

    @DeleteMapping
    public void delete(@RequestBody DeleteModelRequest request){
        modelService.delete(request);
    }

    @PutMapping
    public void update(@RequestBody UpdateModelRequest request){
        modelService.update(request);
    }
}
