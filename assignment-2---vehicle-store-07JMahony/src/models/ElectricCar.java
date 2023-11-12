package models;

import utils.Utilities;

import java.util.Objects;

public class ElectricCar extends Car {

    private int range=100;
    private float engineKWatts=40;


    public ElectricCar(String regNumber, String model, float cost, Manufacturer manufacturer, int year, int range, float engineKWatts ){
        super(regNumber, model, cost, manufacturer, year);
    }

    @Override
    public String toString() {
        return "ElectricCar{" +
                "range=" + range +
                ", engineKWatts=" + engineKWatts +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ElectricCar)) return false;
        if (!super.equals(o)) return false;
        ElectricCar that = (ElectricCar) o;
        return range == that.range && Float.compare(that.engineKWatts, engineKWatts) == 0;
    }



    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), range, engineKWatts);
    }


    public int getRange() {
        return range;
    }



    public void setRange(int range) {
        if(Utilities.validRange(range,100,500)){
            this.range=range;
        }
    }



    public float getEngineKWatts() {
        return engineKWatts;
    }



    public void setEngineKWatts(float engineKWatts) {
        if(Utilities.validRange(engineKWatts,40,60,100)){
            this.engineKWatts=engineKWatts;
        }
    }



    @Override
    public double getCarbonFootprint() {
        return (engineKWatts*getAge()) / 20000;
    }
}

