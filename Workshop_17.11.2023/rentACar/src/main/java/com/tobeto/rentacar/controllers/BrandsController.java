package com.tobeto.rentacar.controllers;

import com.tobeto.rentacar.entities.Brand;
import com.tobeto.rentacar.repositories.BrandRepository;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/brands")
public class BrandsController {
    // final => sadece ctor'da ilgili değerin ataması yapılması yapılabilceğini söyler.
    private final BrandRepository brandRepository;
    public BrandsController(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }
    // Dependency Injection

    // Spring IoC => DI Container

    @GetMapping
    public List<Brand> getAll() {
        // findAll => hazır bir JPA repository fonk.
        List<Brand> brands = brandRepository.findAll();
        return brandRepository.findAll();
    }

    @GetMapping("{id}")
    public Brand getById(@PathVariable int id){
        //Optional => Opsiyonel olarak Brand
        return brandRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Brand brand){
        brandRepository.save(brand);
    }

    @DeleteMapping("{id}")
    public void delete (@PathVariable int id){
        Brand brandToDelete = brandRepository.findById(id).orElseThrow();
        // exception fırlaması
        //bu satıra geldiyse, bu id ile bir veri vardır
        brandRepository.delete(brandToDelete);
    }
}

// http://localhost:8080/api/brands GET
