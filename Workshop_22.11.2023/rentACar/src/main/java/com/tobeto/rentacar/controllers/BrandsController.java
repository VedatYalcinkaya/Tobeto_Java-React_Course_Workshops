package com.tobeto.rentacar.controllers;

import com.tobeto.rentacar.services.abstracts.BrandService;
import com.tobeto.rentacar.services.dtos.brand.requests.AddBrandRequest;
import com.tobeto.rentacar.services.dtos.brand.requests.DeleteBrandRequest;
import com.tobeto.rentacar.services.dtos.brand.requests.UpdateBrandRequest;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/brands")
public class BrandsController {
    // Bağımlılıklar daima soyut nesneler üzerinden

    private final BrandService brandService;

    public BrandsController(BrandService brandService) {
        this.brandService = brandService;
    }

    @PostMapping
    public void add(@RequestBody AddBrandRequest request){
        brandService.add(request);
    }

    @DeleteMapping
    public void delete(@RequestBody DeleteBrandRequest request){
        brandService.delete(request);
    }

    @PutMapping
    public void update(@RequestBody UpdateBrandRequest request){
        brandService.update(request);
    }
}

// http://localhost:8080/api/brands GET
