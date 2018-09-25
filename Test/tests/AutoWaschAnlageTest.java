package tests;

import carz.Fahrzeug;
import helpers.LimitedArrayList;
import carz.Motorrad;
import main.AutoWaschAnlage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.HelperFunctionsForTestsOnly;

public class AutoWaschAnlageTest {

    private HelperFunctionsForTestsOnly helperFunctionsForTestsOnly = new HelperFunctionsForTestsOnly();
    private LimitedArrayList<Fahrzeug> testSchlange = helperFunctionsForTestsOnly.createLimitedArrayListWithCars(8);

    @Test
    public void createLimitedArrayWithCarsThrowsExceptionOnMoreThanTenCars() {
        //given
        //when
        //then

        Assertions.assertThrows(IllegalArgumentException.class, () -> helperFunctionsForTestsOnly.createLimitedArrayListWithCars(11));
        Assertions.assertEquals(helperFunctionsForTestsOnly.autoWaschAnlage.getFahrzeuge().size(), 10);
    }

    @Test
    public void carWashedRemovesFirstCar() {
        //given
        //when
        Fahrzeug zweitesAutoInDerSchlange = testSchlange.get(1);
        LimitedArrayList<Fahrzeug> schlangeAfterFahrzeugWashed = helperFunctionsForTestsOnly.autoWaschAnlage.carWashed();
        Fahrzeug erstesAutoNachWaschen = schlangeAfterFahrzeugWashed.get(0);
        //then
        Assertions.assertEquals(zweitesAutoInDerSchlange, erstesAutoNachWaschen);
    }

    @Test
    public void carLeavesBeforeWashSchlangeLengthISCorrect() {
        //given
        //when
        Fahrzeug achtesAutoInderSchange = testSchlange.get(7);
        LimitedArrayList<Fahrzeug> schlangeAfterCarsLeft = helperFunctionsForTestsOnly.autoWaschAnlage.carLeavesBeforeWash(2);
        Fahrzeug siebtesAutoAfterFahrzeugLeft = schlangeAfterCarsLeft.get(6);
        //then
        Assertions.assertEquals(achtesAutoInderSchange, siebtesAutoAfterFahrzeugLeft);
    }

    @Test
    public void carInWashCantLeave() {
        //given
        Fahrzeug autoInDerWaesche = testSchlange.get(0);
        //when
        LimitedArrayList<Fahrzeug> testSchlangeAfterFahrzeugInWashTriedToLeave = helperFunctionsForTestsOnly.autoWaschAnlage.carLeavesBeforeWash(2);

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
        helperFunctionsForTestsOnly.autoWaschAnlage.newCarComesToWash("Pkw", "HH2345");
        //when
        int preisPkw = helperFunctionsForTestsOnly.autoWaschAnlage.getFahrzeuge().get(8).getPreis();
        //then
        Assertions.assertEquals(5, preisPkw);
    }

    @Test
    void newPkwComesToWashSchlangeHasRightLength() {
        //given
        helperFunctionsForTestsOnly.autoWaschAnlage.newCarComesToWash("Pkw", "HH2345");
        //when
        //then
        Assertions.assertEquals(helperFunctionsForTestsOnly.autoWaschAnlage.getFahrzeuge().size(), 9);

    }

    @Test
    void newLkwComesToWashDescriptionAndKennzeichenCorrect() {
        //given
        //when
        helperFunctionsForTestsOnly.autoWaschAnlage.newCarComesToWash("Lkw", "HH-2341");
        String clasNamePkw = helperFunctionsForTestsOnly.autoWaschAnlage.getFahrzeuge().get(8).getClass().getName().replace("carz.", "");
        //then
        Assertions.assertEquals("HH-2341", helperFunctionsForTestsOnly.autoWaschAnlage.getFahrzeuge().get(8).getKennzeichen());
        Assertions.assertEquals("Lkw", clasNamePkw);

    }

    @Test
    void newUnidentifiedCarComesToWashNotAddedToSchlange() {
        //then
        Assertions.assertEquals(8, helperFunctionsForTestsOnly.autoWaschAnlage.getFahrzeuge().size());
        helperFunctionsForTestsOnly.autoWaschAnlage.newCarComesToWash("unidentifiedCar", "HH2345");
        Assertions.assertEquals(8, helperFunctionsForTestsOnly.autoWaschAnlage.getFahrzeuge().size());
    }

    @Test
    void numberOfCarToLeaveWashThrowsExceptionIfIncorectNumber() {
        //given
        //Es befinden sich 8 Fahrzeuge in der Schlange, wobei nur 2-8 (1-7 Index) die Schlange verlassen dürfen.
        //when
        //then
        Assertions.assertThrows(IllegalArgumentException.class, () -> AutoWaschAnlage.numberOfCarToLeaveWash(0));
        Assertions.assertEquals(1, AutoWaschAnlage.numberOfCarToLeaveWash(1));
        Assertions.assertEquals(7, AutoWaschAnlage.numberOfCarToLeaveWash(7));
        Assertions.assertThrows(IllegalArgumentException.class, () -> AutoWaschAnlage.numberOfCarToLeaveWash(8));
    }
}
