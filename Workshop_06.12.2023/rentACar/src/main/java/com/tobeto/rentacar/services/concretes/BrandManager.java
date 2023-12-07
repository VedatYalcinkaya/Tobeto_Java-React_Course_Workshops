package com.tobeto.rentacar.services.concretes;

import com.tobeto.rentacar.entities.Brand;
import com.tobeto.rentacar.repositories.BrandRepository;
import com.tobeto.rentacar.services.abstracts.BrandService;
import com.tobeto.rentacar.services.dtos.brand.requests.AddBrandRequest;
import com.tobeto.rentacar.services.dtos.brand.requests.DeleteBrandRequest;
import com.tobeto.rentacar.services.dtos.brand.requests.UpdateBrandRequest;
import com.tobeto.rentacar.services.dtos.brand.responses.GetListBrandByNameResponse;
import com.tobeto.rentacar.services.dtos.brand.responses.GetListBrandResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandManager implements BrandService {
    private final BrandRepository brandRepository;

    public BrandManager(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public void add(AddBrandRequest request) {
        if (brandRepository.existsBrandByName(request.getName())){
            throw new RuntimeException("Aynı isimde marka zaten var");
        }
        if (Character.isDigit(request.getName().charAt(0))){
            throw new RuntimeException(("Marka adı rakam ile başlayamaz.")); // Aslında validation sayılır ama aklıma şuan busines rule gelmedi.
        }

        Brand brand = new Brand();
        brand.setName(request.getName());
        brandRepository.save(brand);
    }

    @Override
    public void update(UpdateBrandRequest request) {
        if (brandRepository.existsBrandByName(request.getName())){
            throw new RuntimeException("Aynı isimde marka zaten var");
        }
        if (Character.isDigit(request.getName().charAt(0))){
            throw new RuntimeException(("Marka adı rakam ile başlayamaz.")); // Aslında validation sayılır ama aklıma şuan busines rule gelmedi.
        }

        Brand brandToUpdate = brandRepository.findById(request.getId()).orElseThrow();
        brandToUpdate.setName(request.getName());
        brandRepository.save(brandToUpdate);
    }

    @Override
    public void delete(DeleteBrandRequest request) {
        Brand brandToDelete = brandRepository.findById(request.getId()).orElseThrow();
        brandRepository.delete(brandToDelete);
    }

    @Override
    public List<Brand> getByName(String name) {
        return brandRepository.findByNameStartingWithIgnoreCase(name);
    }

    @Override
    public List<GetListBrandByNameResponse> getByNameDto(String name) {

        // TODO: Yaklaşım 1: Repositoryden List<Brand>'i alıp Service katmanında Mapleyerek DTO türüne çevirmek

//        List<Brand> brands = brandRepository.findByNameStartingWithIgnoreCase(name);
//        List<GetListBrandResponse> dtos = new ArrayList<>();
//
//        for (Brand brand : brands) {
//            dtos.add(new GetListBrandResponse(brand.getName()));
//        return dtos:
//        }
        return brandRepository.findByNameStartingWith(name).stream().map((brand) -> new GetListBrandByNameResponse(brand.getId(), brand.getName())).toList();

        // TODO: Yaklaşım 2: Repositoryden List<GetListBrandResponse> dönebilen yeni bir method oluşturmak.
        // return brandRepository.findByNameStartingWith(name);
    }

    @Override
    public List<GetListBrandResponse> getAll() {
        return brandRepository.findAll().stream().map(brand -> new GetListBrandResponse(brand.getId(), brand.getName())).toList();
    }

    @Override
    public Brand getById(int id) {
        return brandRepository.findById(id).orElseThrow();
    }


}
// Lambda Expression & Stream APİ