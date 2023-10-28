package org.vedatYlcnky.dataAccess;

import org.vedatYlcnky.entities.Car;

import java.util.ArrayList;
import java.util.List;

public class BmwRepository implements CarRepository {

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

    @Override
    public void add(int id, String carModel, int carModelYear, double engineDisplacement, String fuelType ) {
        Car car = new Car();
        car.setId(id);
        car.setCarModel(carModel);
        car.setCarModelYear(carModelYear);
        car.setEngineDisplacement(engineDisplacement);
        car.setFuelType(fuelType);
        cars.add(car);
        System.out.println("BMW koleksiyonuna " + carModelYear + " " + carModel + " modeli eklendi");
    }

    public void delete(int id){
        Car carToRemove;
        for (Car car:cars){
            if (car.getId() == id){
                cars.remove(cars.indexOf(car));
                break;
            }
        }


    }

    public void update(int id, String carModel, int carModelYear, double engineDisplacement, String fuelType){
        delete(id);
        Car car = new Car();
        car.setId(id);
        car.setCarModel(carModel);
        car.setCarModelYear(carModelYear);
        car.setEngineDisplacement(engineDisplacement);
        car.setFuelType(fuelType);
        cars.add(car);
    }
}
