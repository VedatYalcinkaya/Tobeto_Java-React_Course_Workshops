package org.vedatYlcnky;

import org.vedatYlcnky.dataAccess.ICarRepository;
import org.vedatYlcnky.dataAccess.MercedesRepository;
import org.vedatYlcnky.entities.Car;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ICarRepository carRepository = new MercedesRepository();
        List<Car> cars = carRepository.getAll();
        for (int i = 0; i < cars.size(); i++){
            System.out.println(cars.get(i).getCarModel());

        }
    }
}