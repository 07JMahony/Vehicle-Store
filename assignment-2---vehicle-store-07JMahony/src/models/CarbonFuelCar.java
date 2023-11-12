package models;

import utils.Utilities;

import java.util.Objects;

public class CarbonFuelCar extends Car {

    private float fuelConsumption=5;
    private float carbonEmission=1;
    private boolean automatic=false;
    private String fuelType="petrol";
    private int engineSize=800;

    public CarbonFuelCar(String regNumber, String model, float cost, Manufacturer manufacturer, int year, float fuelConsumption, float carbonEmission, boolean automatic, String fuelType, int engineSize){
        super(regNumber, model, cost, manufacturer, year);

        this.fuelConsumption=fuelConsumption;
        this.carbonEmission=carbonEmission;
        this.automatic=automatic;
        this.fuelType=fuelType;
        this.engineSize=engineSize;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CarbonFuelCar)) return false;
        if (!super.equals(o)) return false;
        CarbonFuelCar that = (CarbonFuelCar) o;
        return Float.compare(that.fuelConsumption, fuelConsumption) == 0 && Float.compare(that.carbonEmission, carbonEmission) == 0 && automatic == that.automatic && engineSize == that.engineSize && Objects.equals(fuelType, that.fuelType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), fuelConsumption, carbonEmission, automatic, fuelType, engineSize);
    }

    @Override
    public String toString() {
        return "CarbonFuelCar{" +
                "fuelConsumption=" + fuelConsumption +
                ", carbonEmission=" + carbonEmission +
                ", automatic=" + automatic +
                ", fuelType='" + fuelType + '\'' +
                ", engineSize=" + engineSize +
                '}';
    }

    public float getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(float fuelConsumption) {
        if(Utilities.validRange(fuelConsumption,5,20,100)){
            this.fuelConsumption=fuelConsumption;
        }
    }

    public float getCarbonEmission() {
        return carbonEmission;
    }

    public void setCarbonEmission(float carbonEmission) {
        if(carbonEmission>0){
            this.carbonEmission=carbonEmission;
        }
    }

    public boolean isAutomatic() {
        return automatic;
    }

    public void setAutomatic(boolean automatic) {
        this.automatic = automatic;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        if((fuelType=="diesel") ||(fuelType=="petrol")){
            this.fuelType = fuelType;
        }
    }

    public int getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(int engineSize) {
        if(Utilities.validRange(engineSize,800,2500)){
            this.engineSize=engineSize;
        }
    }

    @Override
    public double getCarbonFootprint(){
        return (engineSize*fuelConsumption*carbonEmission*getAge()) / 2000;
    }
}
