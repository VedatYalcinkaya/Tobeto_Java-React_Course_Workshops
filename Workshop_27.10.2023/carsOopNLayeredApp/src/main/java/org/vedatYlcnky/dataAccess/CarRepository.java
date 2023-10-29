package org.vedatYlcnky.dataAccess;

import org.vedatYlcnky.entities.Car;

import java.util.List;

public interface CarRepository {
    List<Car> getAll();

    void add(Car car);

    void delete(int id);

    void update(Car car);

    void showTable();
}
