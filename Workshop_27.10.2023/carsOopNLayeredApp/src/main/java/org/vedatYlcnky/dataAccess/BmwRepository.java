package org.vedatYlcnky.dataAccess;

import org.vedatYlcnky.entities.Car;

import java.util.ArrayList;
import java.util.List;

public class BmwRepository implements CarRepository {

    List<Car> cars;

    public BmwRepository() {            // Veri üzerinde işlem yapabilmek için constructor yardmıyla veri tabanı simüle ettim.
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
    public void add(Car car) {
        cars.add(car);
    }

    public void delete(int id){
        for (Car car:cars){
            if (car.getId() == id){
                cars.remove(car);
                break;
            }
        }
    }

    public void update(Car car){
        delete(car.getId());
        cars.add(car);
    }

    public void showTable(){
        System.out.println("\n*************** Bmw **************** \n");

        for (Car car:cars){
            System.out.println("Index: "+ car.getId()+ "\tModel: " + car.getCarModel() + "\t\tYıl: " + car.getCarModelYear() +
                    "\tMotor Hacmi: " + car.getEngineDisplacement() + "\tYakıt Tipi: " + car.getFuelType());
        }
        System.out.println("\n");
    }
}
