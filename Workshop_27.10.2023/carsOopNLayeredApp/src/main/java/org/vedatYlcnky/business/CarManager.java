package org.vedatYlcnky.business;

import org.vedatYlcnky.dataAccess.BmwRepository;
import org.vedatYlcnky.dataAccess.CarRepository;
import org.vedatYlcnky.dataAccess.MercedesRepository;
import org.vedatYlcnky.dataAccess.RenaultRepository;
import org.vedatYlcnky.entities.Car;

import java.time.LocalDate;
import java.util.List;

public class CarManager {
    CarRepository carRepository;

    public CarManager(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getAll(){
        return carRepository.getAll();
    }
    public void control(Car car) throws Exception {     // add ile update kısmında kod tekrar yapmamak için yazılmış metod

        LocalDate currentDate = LocalDate.now();
        int currentYear = currentDate.getYear();    // İçinde bulunulan yılı int değeri olarak alır, throw exception için kullanılacak

        if (car.getCarModelYear() < currentYear-10){
            throw new Exception("Araba 10 yaşından küçük olmalı.");
        } else if (!car.getFuelType().equals("Benzin") && !car.getFuelType().equals("Dizel") &&
                !car.getFuelType().equals("Elektrik") && !car.getFuelType().equals("Hybrid")) {
            throw new Exception("Yakıt tipi Benzin, Dizel, Hybrid veya Elektrik olmalıdır");
        }
    }

    boolean isIdExist(Car car){                     // update ve delete kısmında benzer amaçla kullanılan bool metotu için polymorphism örneği
        List<Car> cars = getAll();
        for (int i = 0; i < cars.size(); i++){
            if(cars.get(i).getId() == car.getId()){
                return false;
            }
        }
        return true;
    }
    boolean isIdExist(int id){
        List<Car> cars = getAll();
        for (int i = 0; i < cars.size(); i++){
            if(cars.get(i).getId() == id){
                return false;
            }
        }
        return true;
    }

    public void add(Car car) throws Exception {         //id değeri girilmeden car objesi gönderilecek

        List<Car> cars = getAll();

        car.setId(cars.get(cars.size()-1).getId()+1);   // Listedeki son car objesinin id değerinin bir fazlasını, yeni car objesinin id'si yapar

        control(car);

        carRepository.add(car);
    }

    public void update(Car car) throws Exception {      //tüm değerleri girilerek car objesi gönderilecek, gönderilen id'de obje varsa güncellenecek
        if (isIdExist(car)){
            throw new Exception("Güncellemek istediğiniz id'de bir kayıt bulunmamaktadır");
        }

        control(car);

        carRepository.update(car);
    }

    public void delete(int id) throws Exception {
        if(isIdExist(id)){
            throw new Exception("Güncellemek istediğiniz id'de bir kayıt bulunmamaktadır");
        }

        carRepository.delete(id);
    }

    public void showTable(){
        List<Car> cars = getAll();
        if(cars.size() > 0){
            carRepository.showTable();
        }
    }


}
