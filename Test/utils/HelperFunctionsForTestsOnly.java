package utils;
import carz.*;
import helpers.*;
import main.CarWash;


public class HelperFunctionsForTestsOnly {
    private LimitedArrayList<Vehicle> vehicles = new LimitedArrayList<>();
    private Mathematics mathematics = new Mathematics();
    public CarWash carWash =new CarWash();


    public LimitedArrayList<Vehicle> createLimitedArrayListWithCars(int amountCars) {
        for (int i = 0; i < amountCars; i++) {
            String kennzeichenBuchstaben = mathematics.twoRandomLetters();
            String kennzeichenZahlen = mathematics.randomNumberAsString();
            Vehicle vehicle = new Vehicle(kennzeichenBuchstaben + "-" + kennzeichenZahlen);
            vehicles.add(vehicle);
        }
        carWash.setVehicles(vehicles);
        return carWash.getVehicles();
    }}
