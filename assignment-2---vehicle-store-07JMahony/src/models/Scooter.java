package models;

import utils.Utilities;

import java.util.Objects;

public class Scooter extends Vehicle {

    private int power=250;
    private float weight=5;
    private int topRiderWeight=100;


    public Scooter(String regNumber, String model, float cost, Manufacturer manufacturer, int year, int power, float weight, int topRiderWeight) {
        super(regNumber, model, cost, manufacturer, year);

        this.power=power;
        this.weight=weight;
        this.topRiderWeight=topRiderWeight;
    }

    @Override
    public String toString() {
        return "Scooter{" +
                "power=" + power +
                ", weight=" + weight +
                ", topRiderWeight=" + topRiderWeight +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Scooter)) return false;
        if (!super.equals(o)) return false;
        Scooter scooter = (Scooter) o;
        return getPower() == scooter.getPower() && Float.compare(scooter.getWeight(), getWeight()) == 0 && getTopRiderWeight() == scooter.getTopRiderWeight();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getPower(), getWeight(), getTopRiderWeight());
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        if(Utilities.validRange(power, 250, 1000)){
            this.power = power;
        }
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        if(Utilities.validRange(weight, 5, 100, 100)){
            this.weight = weight;
        }
    }

    public int getTopRiderWeight() {
        return topRiderWeight;
    }

    public void setTopRiderWeight(int topRiderWeight) {
        if(Utilities.validRange(topRiderWeight, 100, 120)){
            this.topRiderWeight = topRiderWeight;
        }
    }

    @Override
    public double getCarbonFootprint() {

        return  (power*weight*getAge()) / 15000;
    }
}
