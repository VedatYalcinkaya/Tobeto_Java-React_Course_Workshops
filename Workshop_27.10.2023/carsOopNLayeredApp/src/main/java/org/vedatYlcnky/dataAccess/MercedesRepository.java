package org.vedatYlcnky.dataAccess;

import org.vedatYlcnky.entities.Car;

import java.util.ArrayList;
import java.util.List;

public class MercedesRepository implements ICarRepository{

    List<Car> cars;

    public MercedesRepository() {
        cars = new ArrayList<>();
        cars.add(new Car(1,"Maybach S 680",2023,6.0,"Benzin"));
        cars.add(new Car(2,"EQS 450 4Matic",2023,1.3,"Elektrik"));
        cars.add(new Car(3,"E 200d AMG",2023,1.6,"Dizel"));
        cars.add(new Car(4,"A 200 AMG+",2023,1.3,"Benzin"));
        cars.add(new Car(5,"SL 43 AMG",2023,1.9,"Hybrid"));
    }

    @Override
    public List<Car> getAll() {
        return cars;
    }
}
