package org.vedatYlcnky.dataAccess;

import org.vedatYlcnky.entities.Car;

import java.util.ArrayList;
import java.util.List;

public class RenaultRepository implements CarRepository {

    List<Car> cars;

    public RenaultRepository(){
        cars = new ArrayList<>();
        cars.add(new Car(1,"Taliant 1.0 TCe Joy",2023,1.0,"Benzin"));
        cars.add(new Car(2,"Clio 1.0 TCe Techno Esprit Alpine",2023,1.0,"Benzin"));
        cars.add(new Car(3,"Clio 1.0 TCe Touch",2023,1.0,"Benzin"));
        cars.add(new Car(4,"Megane 1.3 TCe Icon",2023,1.3,"Benzin"));
        cars.add(new Car(5,"Megane 1.5 Blue DCI Icon",2023,1.5,"Dizel"));
    }
    @Override
    public List<Car> getAll() {
        return cars;
    }


    @Override
    public void add(Car car) {
        cars.add(car);
        System.out.println("Index: " + car.getId() + ", Renault koleksiyonuna " + car.getCarModelYear() + " "
                + car.getCarModel() + " modeli eklendi..." );
    }

    @Override
    public void delete(int id) {
        for (Car car:cars){
            if (car.getId() == id){
                System.out.println("Index: " + car.getId() + ", " + car.getCarModelYear()+ " " + car.getCarModel() + " silindi.");
                cars.remove(car);
                break;
            }
        }
    }

    @Override
    public void update(Car car) {
        delete(car.getId());
        cars.add(car);
        System.out.println("Index: " + car.getId() + ", " + car.getCarModelYear()+ " " + car.getCarModel() + " şeklinde güncellendi");
    }

    @Override
    public void showTable(){
        System.out.println("\n*************** Renault **************** \n");

        for (Car car:cars){
            System.out.println("Index: "+ car.getId()+ "\tModel: " + car.getCarModel() + "\t\tYıl: " + car.getCarModelYear() +
                    "\tMotor Hacmi: " + car.getEngineDisplacement() + "\tYakıt Tipi: " + car.getFuelType());
        }
        System.out.println("\n");
    }

}
