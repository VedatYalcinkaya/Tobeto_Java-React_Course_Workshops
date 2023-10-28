package org.vedatYlcnky.business;

import org.vedatYlcnky.dataAccess.BmwRepository;
import org.vedatYlcnky.dataAccess.CarRepository;
import org.vedatYlcnky.entities.Car;

import java.time.LocalDate;
import java.util.List;

public class CarManager {
    CarRepository carRepository = new BmwRepository();

    public List<Car> getAll(){
        return carRepository.getAll();
    }

    public void add(int id, String carModel, int carModelYear, double engineDisplacement, String fuelType) throws Exception {

        List<Car> cars = getAll();

        LocalDate currentDate = LocalDate.now();
        int currentYear = currentDate.getYear(); // İçinde bulunduğumuz yılı int cindinden almak için

        for (Car car:cars){
            if (car.getId() == id){
                throw new Exception("Aynı id ile araba kaydı yapamazsınız.");
            } /*else if (car.getCarModelYear() < currentYear-10) {
                throw new Exception("Araba 10 yaşından büyükse kaydı yapamazsınız.");
            } else if (car.getFuelType() != "Benzin" || car.getFuelType() != "Dizel" || car.getFuelType() != "Elektrik" || car.getFuelType() != "Hybrid") {
                throw new Exception("Yakıt tipi Benzin, Dizel, Hybrid veya Elektrik olmalıdır.");
            }*/
        }
        carRepository.add(id,carModel,carModelYear,engineDisplacement,fuelType);
    }
}
