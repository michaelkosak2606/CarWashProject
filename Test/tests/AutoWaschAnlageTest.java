package tests;

import carz.Fahrzeug;
import helpers.CarFactory;
import helpers.LimitedArrayList;
import carz.Motorrad;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.HelperFunctions;

public class AutoWaschAnlageTest {

    private HelperFunctions helperFunctions = new HelperFunctions();
    private LimitedArrayList<Fahrzeug> testSchlange = helperFunctions.createLimitedArrayListWithCars(8);

    @Test
    public void createLimitedArrayWithCarsThrowsExceptionOnMoreThanTenCars() {
        //given
        //when
        //then

        Assertions.assertThrows(IllegalArgumentException.class, () -> helperFunctions.createLimitedArrayListWithCars(11));
        Assertions.assertEquals(helperFunctions.autoWaschAnlage.getFahrzeuge().size(), 10);
    }

    @Test
    public void carWashedRemovesFirstCar() {
        //given
        //when
        Fahrzeug zweitesAutoInDerSchlange = testSchlange.get(1);
        LimitedArrayList<Fahrzeug> schlangeAfterFahrzeugWashed = helperFunctions.autoWaschAnlage.carWashed();
        Fahrzeug erstesAutoNachWaschen = schlangeAfterFahrzeugWashed.get(0);
        //then
        Assertions.assertEquals(zweitesAutoInDerSchlange, erstesAutoNachWaschen);
    }

    @Test
    public void carLeavesBeforeWash() {
        //given

        //when
        Fahrzeug achtesAutoInderSchange = testSchlange.get(7);
        LimitedArrayList<Fahrzeug> schlangeAfterCarsLeft = helperFunctions.autoWaschAnlage.carLeavesBeforeWash(2);
        Fahrzeug siebtesAutoAfterFahrzeugLeft = schlangeAfterCarsLeft.get(6);
        //then
        Assertions.assertEquals(achtesAutoInderSchange, siebtesAutoAfterFahrzeugLeft);
    }

    @Test
    public void carInWashCantLeave() {
        //given
        Fahrzeug autoInDerWaesche = testSchlange.get(0);
        //when
        LimitedArrayList<Fahrzeug> testSchlangeAfterFahrzeugInWashTriedToLeave = helperFunctions.autoWaschAnlage.carLeavesBeforeWash(2);

        //then
        Assertions.assertEquals(testSchlangeAfterFahrzeugInWashTriedToLeave.get(0), autoInDerWaesche);

    }

    @Test
    public void newCarInWash() {
        //given
        Motorrad car = new Motorrad();
        int alteLaenge = testSchlange.size();
        //when
        //autoWaschAnlage.newCarComesToWash("HH 2453", "car");
        testSchlange.add(car);
        int neueLaenge = testSchlange.size();
        //then
        Assertions.assertEquals(alteLaenge, neueLaenge - 1);
        Assertions.assertEquals(testSchlange.get(testSchlange.size() - 1).getKennzeichen(), null);
    }

    @Test
    void newPkwComesToWash() {
        //given
        //when
        helperFunctions.autoWaschAnlage.newCarComesToWash("pkw", "HH2345");
        String clasNamePkw = helperFunctions.autoWaschAnlage.getFahrzeuge().get(8).getClass().getName().replace("carz.", "");
        int preisPkw = helperFunctions.autoWaschAnlage.getFahrzeuge().get(8).getPreis();
        //then
        Assertions.assertEquals(helperFunctions.autoWaschAnlage.getFahrzeuge().size(), 9);
        Assertions.assertEquals("HH2345", helperFunctions.autoWaschAnlage.getFahrzeuge().get(8).getKennzeichen());
        Assertions.assertEquals("Pkw", clasNamePkw);
        Assertions.assertEquals(5, preisPkw);
    }


    @Test
    void newUnidentifiedCarComesToWashNotAddedToSchlange() {
        Assertions.assertEquals(8, helperFunctions.autoWaschAnlage.getFahrzeuge().size());
        helperFunctions.autoWaschAnlage.newCarComesToWash("unidentifierdCar", "HH2345");
        Assertions.assertEquals(8, helperFunctions.autoWaschAnlage.getFahrzeuge().size());
    }

    @Test
    void unidentifiedCarThrowsExceptionInCarFactory() {
        Assertions.
                assertThrows(IllegalArgumentException.class,
                        () -> CarFactory.createCar("unidentifierdCar", "HH2345"));

    }
    /*@Test
    void schlangeInfoTest() {
        Assertions.assertEquals(autoWaschAnlage.schlangeInfo(), "Es sind 8 Autos in der Schlange.");

        //when
        for (int i = 1; i <= 8; i++) {
            autoWaschAnlage.carWashed();
        }
        //then
        Assertions.assertEquals(autoWaschAnlage.schlangeInfo(), "Es befinden sich keine Autos in der Schlange.");

    }*/
}
