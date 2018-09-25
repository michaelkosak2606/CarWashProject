package helpers;

import carz.Fahrzeug;
import carz.Lkw;
import carz.Motorrad;
import carz.Pkw;

public class CarFactory {

    public static Fahrzeug createCar(String art, String kennzeichen) {
        if (art.equals("pkw")) {
            return new Pkw(kennzeichen);
        }
        if (art.equals("motorrad")) {
            return new Motorrad(kennzeichen);
        }
        if (art.equals("lkw")) {
            return new Lkw(kennzeichen);
        }

        throw new IllegalArgumentException();
    }
}
