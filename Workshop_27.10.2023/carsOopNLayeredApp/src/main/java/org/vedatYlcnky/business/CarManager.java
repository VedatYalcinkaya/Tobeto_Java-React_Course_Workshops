package org.vedatYlcnky.business;

import org.vedatYlcnky.core.logging.Logger;
import org.vedatYlcnky.dataAccess.CarRepository;
import org.vedatYlcnky.entities.Car;

import java.time.LocalDate;
import java.util.List;

public class CarManager {
    private CarRepository carRepository;
    private List<Logger> loggers;

    public CarManager(CarRepository carRepository,List<Logger> loggers) {
        this.carRepository = carRepository;
        this.loggers = loggers;
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

        for (Logger logger:loggers){
            logger.log(car.getId() + " id'li " + car.getCarModelYear() + " " + car.getCarModel() + " eklendi");
        }
    }

    public void update(Car car) throws Exception {      //tüm değerleri girilerek car objesi gönderilecek, gönderilen id'de obje varsa güncellenecek
        if (isIdExist(car)){
            throw new Exception("Güncellemek istediğiniz id'de bir kayıt bulunmamaktadır");
        }

        control(car);

        carRepository.update(car);

        for (Logger logger:loggers){
            logger.log(car.getId() + " id'li " + car.getCarModelYear() + " " + car.getCarModel() + " güncellendi.");
        }
    }

    public void delete(int id) throws Exception {
        if(isIdExist(id)){
            throw new Exception("Güncellemek istediğiniz id'de bir kayıt bulunmamaktadır");
        }

        carRepository.delete(id);

        for (Logger logger:loggers){
            logger.log(id + " id'li araç silindi");
        }
    }

    public void showTable() throws Exception {
        List<Car> cars = getAll();
        if(cars.size() > 0){
            carRepository.showTable();
        }else{
            throw new Exception("Gösterilecek veri bulunamadı");
        }
    }


}
