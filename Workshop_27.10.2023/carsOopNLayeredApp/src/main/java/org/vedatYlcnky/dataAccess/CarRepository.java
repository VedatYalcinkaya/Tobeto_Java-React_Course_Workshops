package org.vedatYlcnky.dataAccess;

import org.vedatYlcnky.entities.Car;

import java.util.List;

public interface ICarRepository {
    List<Car> getAll();
}
