package com.tobeto.rentacar.repositories;

import com.tobeto.rentacar.entities.Brand;
import com.tobeto.rentacar.entities.Car;
import com.tobeto.rentacar.services.dtos.brand.responses.GetListBrandByNameResponse;
import com.tobeto.rentacar.services.dtos.brand.responses.GetListBrandResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// Generic
// Generic Typeler referance type olarak belirtilmelidir.
public interface BrandRepository extends JpaRepository<Brand, Integer> {

    // SELECT * FROM Brands WHERE name = name

    // Derived Query Methods => Fonksiyon isimlendirmesi kuralları

    List<Brand> findByNameStartingWithIgnoreCase(String name);

    // Derived Query Methodlar sadece veritabanı entity türüyle çalışır.

    // ********
    // Tablo ismi değil, entity ismi kullanılacak
    // Entity'e her zaman alias verilecek "Brand b"
    // Dinamik alanlarda fonksiyon parametresi okumak için :parametreAdi kalıbı kullanılacak.
    // JPQL içerisinde obje newlenebilir.
    // NEWlenen objeler tam yoluyla belirtilmelidir.
    // ********

    @Query("SELECT new com.tobeto.rentacar.services.dtos.brand.responses.GetListBrandByNameResponse(b.id,b.name) " +
            "FROM Brand b WHERE LOWER(b.name) LIKE LOWER(CONCAT(:name, '%'))") // SQL değil JPQL
    List<GetListBrandByNameResponse> findByNameStartingWith(String name);

    boolean existsBrandByName(String name);
}
