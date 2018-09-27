package main;

import carz.Vehicle;
import helpers.*;

public class CarWash {

    private int guthaben;

    private static LimitedArrayList<Vehicle> vehicles = new LimitedArrayList<>();

    private Mathematics mathematics = new Mathematics();


    public LimitedArrayList<Vehicle> carWashed() {
        if (vehicles.size() > 0) {
            setGuthaben(getGuthaben() + vehicles.get(0).getPreis());
            vehicles.remove(0);
        }
        return vehicles;
    }

    public static int numberOfCarToLeaveWash(int carNumber) {
        if (carNumber == 0)
            throw new IllegalArgumentException();
        if (carNumber >= vehicles.size())
            throw new IllegalArgumentException();
        return carNumber;
    }

    public LimitedArrayList<Vehicle> carLeavesBeforeWash(int carNumberInSchlange) {

        try {
            numberOfCarToLeaveWash(carNumberInSchlange);
            vehicles.remove(carNumberInSchlange);
        } catch (IllegalArgumentException ex) {
            System.out.println("Dieses Fahrzeug kann die Schlange nicht vorzeitig verlassen.");
        }
        return vehicles;
    }

    public LimitedArrayList<Vehicle> newCarComesToWash(String description, String kennzeichen) {
        try {
            Vehicle neuesVehicle = CarFactory.createCar(description, kennzeichen);
            vehicles.add(neuesVehicle);
        } catch (IllegalArgumentException ex) {
            System.out.println("Dies ist keine Fahrzeugart.");
        }
        return vehicles;
    }

    public LimitedArrayList<Vehicle> newRandomCarComesToWash(String kennzeichen) {
        String kennzeichenZahlen = mathematics.randomNumberAsString();
        String kennzeichenBuchstaben = mathematics.twoRandomLetters();
        Vehicle newVehicle = new Vehicle(kennzeichenZahlen + " " + kennzeichenBuchstaben);
        vehicles.add(newVehicle);
        return vehicles;
    }




    public int getGuthaben() {
        return guthaben;
    }

    public void setGuthaben(int guthaben) {
        this.guthaben = guthaben;
    }


    public LimitedArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(LimitedArrayList<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
}
