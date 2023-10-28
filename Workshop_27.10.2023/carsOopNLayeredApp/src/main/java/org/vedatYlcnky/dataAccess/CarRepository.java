package org.vedatYlcnky.dataAccess;

import org.vedatYlcnky.entities.Car;

import java.util.List;

public interface CarRepository {
    List<Car> getAll();

    void add(int id, String carModel, int carModelYear, double engineDisplacement, String fuelType);

    void delete(int id);

    void update(int id,String carModel, int carModelYear, double engineDisplacement, String fuelType);
}
