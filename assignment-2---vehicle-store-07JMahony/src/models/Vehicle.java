package models;

import utils.Utilities;

import java.util.Objects;


public abstract class Vehicle {

    private String model = "No model";
    private String regNumber = "No reg";
    private int year = 2000;
    private float cost = 1000;
    private Manufacturer manufacturer;

    public Vehicle(String regNumber, String  model, float cost, Manufacturer manufacturer, int  year){
        this.model=model;
        this.regNumber=regNumber;
        this.year=year;
        this.cost=cost;
        this.manufacturer=manufacturer;

    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "model='" + model + '\'' +
                ", regNumber='" + regNumber + '\'' +
                ", year=" + year +
                ", cost=" + cost +
                ", manufacturer=" + manufacturer +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicle)) return false;
        Vehicle vehicle = (Vehicle) o;
        return getYear() == vehicle.getYear() && Float.compare(vehicle.getCost(), getCost()) == 0 && Objects.equals(getModel(), vehicle.getModel()) && Objects.equals(getRegNumber(), vehicle.getRegNumber()) && Objects.equals(getManufacturer(), vehicle.getManufacturer());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getModel(), getRegNumber(), getYear(), getCost(), getManufacturer());
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        if(Utilities.validStringlength(model, 15)){
            this.model = model;
        }
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        if (Utilities.validStringlength(regNumber, 8)) {
            this.regNumber = regNumber;
        }
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if(Utilities.validRange(year, 2000, 2023)){
            this.year = year;
        }
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        if(year>=1000){
            this.cost = cost;
        }
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public abstract double getCarbonFootprint();

    public int getAge(){
        int currentYear=2023;
        int vehicleYear=year;

        return currentYear - vehicleYear;
    }
}
