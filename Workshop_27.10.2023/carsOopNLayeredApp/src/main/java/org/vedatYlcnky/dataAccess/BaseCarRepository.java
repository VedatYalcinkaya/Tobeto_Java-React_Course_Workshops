package org.vedatYlcnky.dataAccess;

import org.vedatYlcnky.entities.Car;

import java.util.List;

public abstract class BaseCarRepository implements CarRepository{
    @Override
    public abstract List<Car> getAll();
    List<Car> cars;
    Car car;

    @Override
    public void add(int id, String carModel, int carModelYear, double engineDisplacement, String fuelType) {
        car.setId(id);
        car.setCarModel(carModel);
        car.setCarModelYear(carModelYear);
        car.setEngineDisplacement(engineDisplacement);
        car.setFuelType(fuelType);
    }
}
