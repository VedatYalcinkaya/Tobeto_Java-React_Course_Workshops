package org.vedatYlcnky;

import org.vedatYlcnky.business.CarManager;
import org.vedatYlcnky.dataAccess.BmwRepository;
import org.vedatYlcnky.dataAccess.CarRepository;
import org.vedatYlcnky.dataAccess.MercedesRepository;
import org.vedatYlcnky.dataAccess.RenaultRepository;
import org.vedatYlcnky.entities.Car;

import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        CarManager carManager = new CarManager(new BmwRepository()); //

        carManager.showTable();

        carManager.add(new Car("218i M Sport",2015,1.5,"Benzin"));
        carManager.update(new Car(5,"840i xDrive M Sport",2019,3.0,"Benzin"));
        carManager.delete(1);

        carManager.showTable();



    }
}