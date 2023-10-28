package org.vedatYlcnky;

import org.vedatYlcnky.business.CarManager;
import org.vedatYlcnky.dataAccess.BmwRepository;
import org.vedatYlcnky.dataAccess.CarRepository;
import org.vedatYlcnky.dataAccess.RenaultRepository;
import org.vedatYlcnky.entities.Car;

import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        CarManager carManager = new CarManager();
        List<Car> cars = carManager.getAll();


        carManager.add(8,"deneme",2023,1.6,"Benzin");
        carManager.add(9,"deneme",2023,1.6,"Benzin");
        carManager.add(10,"deneme",2023,1.6,"Benzin");

        for (int i = 0; i < cars.size(); i++){
            System.out.println(cars.get(i).getCarModel());
        }
    }
}