package org.vedatYlcnky.entities;

public class Car {
    private int id;
    private String carModel;                // Symbol
    private int carModelYear;               // 2013
    private double engineDisplacement;      // 1.2
    private String FuelType;                // Benzinli

    public Car(int id, String carModel, int carModelYear, double engineDisplacement, String fuelType) {
        this.id = id;
        this.carModel = carModel;
        this.carModelYear = carModelYear;
        this.engineDisplacement = engineDisplacement;
        FuelType = fuelType;
    }

    public Car() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public int getCarModelYear() {
        return carModelYear;
    }

    public void setCarModelYear(int carModelYear) {
        this.carModelYear = carModelYear;
    }

    public double getEngineDisplacement() {
        return engineDisplacement;
    }

    public void setEngineDisplacement(double engineDisplacement) {
        this.engineDisplacement = engineDisplacement;
    }

    public String getFuelType() {
        return FuelType;
    }

    public void setFuelType(String fuelType) {
        FuelType = fuelType;
    }
}
