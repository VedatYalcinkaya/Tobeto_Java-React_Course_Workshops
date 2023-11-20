package com.tobeto.rentacar.controllers;

import com.tobeto.rentacar.entities.Model;
import com.tobeto.rentacar.repositories.ModelRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/models")
public class ModelController {
    private final ModelRepository modelRepository;

    public ModelController(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    @GetMapping
    public List<Model> getAll() {
        return modelRepository.findAll();
    }

    @GetMapping("{id}")
    public Model getById(@PathVariable int id){
        return modelRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Model model){
        modelRepository.save(model);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        Model modelToDelete = modelRepository.findById(id).orElseThrow();
        modelRepository.delete(modelToDelete);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody Model updatedModel){
        Model modelToUpdate = modelRepository.findById(id).orElseThrow();
        modelToUpdate.setName(updatedModel.getName());
        modelToUpdate.setBrand(updatedModel.getBrand());
        modelRepository.save(modelToUpdate);
    }



}
