package org.vedatYlcnky.dataAccess;

import org.vedatYlcnky.entities.Car;

import java.util.ArrayList;
import java.util.List;

public class RenaultRepository implements CarRepository {

    List<Car> cars;

    public RenaultRepository(){
        cars = new ArrayList<>();
        cars.add(new Car(1,"Taliant 1.0 TCe Joy",2023,1.0,"Benzin"));
        cars.add(new Car(2,"Clio 1.0 TCe Techno Esprit Alpine  ",2023,1.0,"Benzin"));
        cars.add(new Car(3,"Clio 1.0 TCe Touch",2023,1.0,"Benzin"));
        cars.add(new Car(4,"Megane 1.3 TCe Icon",2023,1.3,"Benzin"));
        cars.add(new Car(5,"Megane 1.5 Blue DCI Icon",2023,1.5,"Dizel"));
    }
    @Override
    public List<Car> getAll() {
        return cars;
    }

    @Override
    public void add(int id, String carModel, int carModelYear, double engineDisplacement, String fuelType) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(int id, String carModel, int carModelYear, double engineDisplacement, String fuelType) {

    }
}
