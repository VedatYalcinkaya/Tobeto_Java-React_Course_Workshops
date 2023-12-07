package com.tobeto.rentacar.services.concretes;

import com.tobeto.rentacar.entities.Brand;
import com.tobeto.rentacar.entities.Model;
import com.tobeto.rentacar.repositories.BrandRepository;
import com.tobeto.rentacar.repositories.ModelRepository;
import com.tobeto.rentacar.services.abstracts.BrandService;
import com.tobeto.rentacar.services.abstracts.ModelService;
import com.tobeto.rentacar.services.dtos.model.requests.AddModelRequest;
import com.tobeto.rentacar.services.dtos.model.requests.DeleteModelRequest;
import com.tobeto.rentacar.services.dtos.model.requests.UpdateModelRequest;
import com.tobeto.rentacar.services.dtos.model.responses.GetListModelNameByBrandResponse;
import com.tobeto.rentacar.services.dtos.model.responses.GetListModelResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelManager implements ModelService{

    private final ModelRepository modelRepository;
    private final BrandService brandService;

    public ModelManager(ModelRepository modelRepository, BrandService brandService) {
        this.modelRepository = modelRepository;
        this.brandService = brandService;
    }

    @Override
    public void add(AddModelRequest request) {
        if(modelRepository.existsByName(request.getName()))
            throw new RuntimeException("Bu model zaten mevcut");

        Model model = new Model();
        Brand brand = brandService.getById(request.getBrandId());
        model.setName(request.getName());
        model.setBrand(brand);

        modelRepository.save(model);
    }

    @Override
    public void update(UpdateModelRequest request) {
        Model modelToUpdate = modelRepository.findById(request.getId()).orElseThrow();
        Brand brand = brandService.getById(request.getBrandId());
        modelToUpdate.setName(request.getName());
        modelToUpdate.setBrand(brand);

        modelRepository.save(modelToUpdate);
    }

    @Override
    public void delete(DeleteModelRequest request) {
        Model modelToDelete = modelRepository.findById(request.getId()).orElseThrow();
        modelRepository.delete(modelToDelete);
    }

    @Override
    public List<GetListModelResponse> getByNameDto(String name) {
        return modelRepository.findByNameStartingWithIgnoreCase(name).stream().map((model) -> new GetListModelResponse(model.getId(), model.getName(), model.getBrand())).toList();
    }

    @Override
    public List<GetListModelNameByBrandResponse> getByBrandDto(String brandName) {
        return modelRepository.findByBrand(brandName).stream().map((model) -> new GetListModelNameByBrandResponse(model.getId(), model.getName())).toList();
    }

    @Override
    public Model getById(int id) {
        return modelRepository.findById(id).orElseThrow();
    }
}
