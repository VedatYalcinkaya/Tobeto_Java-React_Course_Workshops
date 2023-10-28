package org.vedatYlcnky.dataAccess;

import org.vedatYlcnky.entities.Car;

import java.util.ArrayList;
import java.util.List;

public class BmwRepository implements ICarRepository{

    List<Car> cars;

    public BmwRepository() {
        cars = new ArrayList<>();
        cars.add(new Car(1,"520i Edition M Sport",2023,1.6,"Benzin"));
        cars.add(new Car(2,"740d xDrive M Excellence",2023,3.0,"Dizel"));
        cars.add(new Car(3,"630i Gran Turismo M Sport",2023,2.0,"Benzin"));
        cars.add(new Car(4,"420i Gran Coupe M Sport",2023,1.6,"Benzin"));
        cars.add(new Car(5,"320i M Sport",2023,1.6,"Benzin"));
    }

    @Override
    public List<Car> getAll() {
        return cars;
    }
}
