package main;

import carz.Fahrzeug;
import helpers.*;

public class AutoWaschAnlage {

    private int guthaben;

    private LimitedArrayList<Fahrzeug> fahrzeuge = new LimitedArrayList<>();

    private Mathematics mathematics = new Mathematics();


    public LimitedArrayList<Fahrzeug> carWashed() {
        if (fahrzeuge.size() > 0) {
            setGuthaben(getGuthaben() + fahrzeuge.get(0).getPreis());
            fahrzeuge.remove(0);
        }
        return fahrzeuge;
    }

    public LimitedArrayList<Fahrzeug> carLeavesBeforeWash(int carNumberInSchlange) {

        if (carNumberInSchlange == 0)
            throw new IllegalArgumentException("Das Fahrzeug in der Wäsche darf die Schlange nicht mehr verlassen.");
        if (carNumberInSchlange < fahrzeuge.size()) {
            fahrzeuge.remove(carNumberInSchlange);
        }
        return fahrzeuge;
    }

    public LimitedArrayList<Fahrzeug> newCarComesToWash(String description, String kennzeichen) {
        try {
            Fahrzeug neuesFahrzeug = CarFactory.createCar(description, kennzeichen);
            fahrzeuge.add(neuesFahrzeug);
        } catch (IllegalArgumentException ex) {
            System.out.println("Dies ist keine Fahrzeugart.");
        }
        return fahrzeuge;
    }

    public LimitedArrayList<Fahrzeug> newRandomCarComesToWash(String kennzeichen) {
        String kennzeichenZahlen = mathematics.randomNumberAsString();
        String kennzeichenBuchstaben = mathematics.twoRandomLetters();
        Fahrzeug newFahrzeug = new Fahrzeug(kennzeichenZahlen + " " + kennzeichenBuchstaben);
        fahrzeuge.add(newFahrzeug);
        return fahrzeuge;
    }

    public void schlangeInfo() {
        if (fahrzeuge.size() < 1) {
            System.out.println("Es befinden sich keine Autos in der Schlange.");
        } else if (fahrzeuge.size() == 1) {
            System.out.println("Es ist 1 Autos in der Schlange:");
            System.out.println("Auto " + 1 + ": Kennzeichen " + fahrzeuge.get(0).getKennzeichen() + ", Fahrzeugart: " + fahrzeuge.get(0).getClass().getName().replace("carz.", "") + ", Wird gewaschen.");
        } else {
            System.out.println("Es sind " + fahrzeuge.size() + " Autos in der Schlange:");
            System.out.println("Auto " + 1 + ": Kennzeichen " + fahrzeuge.get(0).getKennzeichen() + ", Fahrzeugart: " + fahrzeuge.get(0).getClass().getName().replace("carz.", "") + ", Wird gewaschen.");

            for (int i = 1; i < fahrzeuge.size(); i++) {
                int a = i + 1;
                System.out.println("Auto " + a + ": Kennzeichen " + fahrzeuge.get(i).getKennzeichen() + ", Fahrzeugart: " + fahrzeuge.get(i).getClass().getName().replace("carz.", ""));

            }
            System.out.println();

        }
    }


    public int getGuthaben() {
        return guthaben;
    }

    public void setGuthaben(int guthaben) {
        this.guthaben = guthaben;
    }


    public LimitedArrayList<Fahrzeug> getFahrzeuge() {
        return fahrzeuge;
    }

    public void setFahrzeuge(LimitedArrayList<Fahrzeug> fahrzeuge) {
        this.fahrzeuge = fahrzeuge;
    }
}
