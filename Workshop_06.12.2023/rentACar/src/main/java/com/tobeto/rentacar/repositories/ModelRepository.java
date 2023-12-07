package com.tobeto.rentacar.repositories;

import com.tobeto.rentacar.entities.Model;
import com.tobeto.rentacar.services.dtos.model.responses.GetListModelNameByBrandResponse;
import com.tobeto.rentacar.services.dtos.model.responses.GetListModelResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ModelRepository extends JpaRepository<Model, Integer> {

    @Query("SELECT new com.tobeto.rentacar.services.dtos.model.responses.GetListModelResponse(m.id,m.name,new com.tobeto.rentacar.services.dtos.brand.responses.GetListBrandResponse(b.id, b.name)) " +
            "FROM Model m INNER JOIN m.brand b WHERE LOWER(m.name) LIKE LOWER(CONCAT(:name, '%'))")
    List<GetListModelResponse> findByNameStartingWithIgnoreCase(String name);

    @Query("SELECT new com.tobeto.rentacar.services.dtos.model.responses.GetListModelNameByBrandResponse(m.id,m.name) " +
            "FROM  Model m INNER JOIN m.brand b WHERE LOWER(b.name) = LOWER(:brandName)")
    List<GetListModelNameByBrandResponse> findByBrand(String brandName);

    boolean existsByName(String name);
}
