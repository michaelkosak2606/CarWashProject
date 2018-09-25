package utils;
import carz.*;
import helpers.*;
import main.AutoWaschAnlage;


public class HelperFunctions {
    private LimitedArrayList<Fahrzeug> fahrzeugs = new LimitedArrayList<>();
    private Mathematics mathematics = new Mathematics();
    public AutoWaschAnlage autoWaschAnlage =new AutoWaschAnlage();


    public LimitedArrayList<Fahrzeug> createLimitedArrayListWithCars(int amountCars) {
        for (int i = 0; i < amountCars; i++) {
            String kennzeichenBuchstaben = mathematics.twoRandomLetters();
            String kennzeichenZahlen = mathematics.randomNumberAsString();
            Fahrzeug fahrzeug = new Fahrzeug(kennzeichenBuchstaben + "-" + kennzeichenZahlen);
            fahrzeugs.add(fahrzeug);
        }
        autoWaschAnlage.setFahrzeuge(fahrzeugs);
        return autoWaschAnlage.getFahrzeuge();
    }}
