package controllers;

import models.*;
import utils.FuelTypeUtility;
import utils.Serializer;
import utils.Utilities;

import java.io.*;
import java.util.*;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;


public class VehicleAPI { // todo implements Serializer {   (when load and saved written, include the 'implements Serializer here)

 // more private fields here (file)
    private File file;
    private List<Vehicle> vehicles;

    //TODO refer to the spec and add in the required methods here (make note of which methods are given to you first!)




    // checks if regNumber is a new reg number i.e. it does not already exist in the collection
   public boolean isValidNewRegNumber(String regNumber){
       for(Vehicle vehicle: vehicles)     //todo - declare and instantiate vehicles
           if (vehicle.getRegNumber().equals(regNumber))
                return false;
        return true;
   }

    public boolean addVehicle(Vehicle vehicle){
       return vehicles.add(vehicle);
    }

    public Vehicle deleteVehicleByIndex(int index) {
        if (Utilities.isValidIndex(vehicles, index)) {
            return vehicles.remove(index);
        }
        return null;
    }

    public Vehicle getVehicleByIndex(int index) {
        if (Utilities.isValidIndex(vehicles,index)) {
            return vehicles.get(index);
        }
        return null;
    }

    public String listAllVehicles(){
        if (vehicles.isEmpty()) {
            return "No Vehicles";
        } else {
            String listOfVehicles = "";
            for (int i = 0; i < vehicles.size(); i++) {
                listOfVehicles += i + ": " + vehicles.get(i) + "\n";
            }
            return listOfVehicles;

        }
    }

    public String listAllScooters() {
        String list = "";
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Scooter) {
                list += vehicles.indexOf(vehicle) + ": " + vehicle + "\n";
            }
            if (vehicle instanceof Scooter) {
                return list;
            }
        }
        return "No Scooters";
    }

    public String listAllElectricCars() {
        String list = "";
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof ElectricCar) {
                list += vehicles.indexOf(vehicle) + ": " + vehicle + "\n";
            }
            if (vehicle instanceof ElectricCar) {
                return list;
            }
        }
        return "No Electric Cars";
    }

    public String listAllCarbonFuelCars() {
        String list = "";
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof CarbonFuelCar) {
                list += vehicles.indexOf(vehicle) + ": " + vehicle + "\n";
            }
            if (vehicle instanceof CarbonFuelCar) {
                return list;
            }
        }
        return "No Carbon Fuel Cars";
    }

    public int numberOfVehicles() {
        return vehicles.size();
    }

    public int numberOfScooters() {
        int number = 0;
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Scooter) {
                number++;
            }
        }
        return number;
    }

    public int numberOfElectricCars() {
        int number = 0;
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof ElectricCar) {
                number++;
            }
        }
        return number;
    }

    public int numberOfCarbonFuelCars() {
        int number = 0;
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof CarbonFuelCar) {
                number++;
            }
        }
        return number;
    }





        //---------------------
    // Persistence methods
    //---------------------
    /**
     * The load method uses the XStream component to read all the objects from the xml
     * file stored on the hard disk.  The read objects are loaded into the associated ArrayList
     *
     * @throws Exception An exception is thrown if an error occurred during the load e.g. a missing file.
     */
    @SuppressWarnings("unchecked")
    public void load() throws Exception {
        //list of classes that you wish to include in the serialisation, separated by a comma
        Class<?>[] classes = new Class[]{Vehicle.class, Car.class, CarbonFuelCar.class,
                                            ElectricCar.class, Scooter.class, Manufacturer.class};

        //setting up the xstream object with default security and the above classes
        XStream xstream = new XStream(new DomDriver());
        XStream.setupDefaultSecurity(xstream);
        xstream.allowTypes(classes);

        //doing the actual serialisation to an XML file
        ObjectInputStream in = xstream.createObjectInputStream(new FileReader(file));
        vehicles = (List<Vehicle>) in.readObject();
        in.close();
    }

    /**
     * The save method uses the XStream component to write all the objects in the ArrayList
     * to the xml file stored on the hard disk.
     *
     * @throws Exception An exception is thrown if an error occurred during the save e.g. drive is full.
     */
    public void save() throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter(file));
        out.writeObject(vehicles);
        out.close();
    }

    public String fileName(){
        return this.file.toString();
    }




}
