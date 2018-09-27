package tests;

import carz.Vehicle;
import helpers.LimitedArrayList;
import carz.Motorrad;
import main.CarWash;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.HelperFunctionsForTestsOnly;

public class CarWashTest {

    private HelperFunctionsForTestsOnly helperFunctionsForTestsOnly = new HelperFunctionsForTestsOnly();
    private LimitedArrayList<Vehicle> testSchlange = helperFunctionsForTestsOnly.createLimitedArrayListWithCars(8);

    @Test
    public void createLimitedArrayWithCarsThrowsExceptionOnMoreThanTenCars() {
        //given
        //when
        //then

        Assertions.assertThrows(IllegalArgumentException.class, () -> helperFunctionsForTestsOnly.createLimitedArrayListWithCars(11));
        Assertions.assertEquals(helperFunctionsForTestsOnly.carWash.getVehicles().size(), 10);
    }

    @Test
    public void carWashedRemovesFirstCar() {
        //given
        //when
        Vehicle zweitesAutoInDerSchlange = testSchlange.get(1);
        LimitedArrayList<Vehicle> schlangeAfterVehicleWashed = helperFunctionsForTestsOnly.carWash.carWashed();
        Vehicle erstesAutoNachWaschen = schlangeAfterVehicleWashed.get(0);
        //then
        Assertions.assertEquals(zweitesAutoInDerSchlange, erstesAutoNachWaschen);
    }

    @Test
    public void carLeavesBeforeWashSchlangeLengthISCorrect() {
        //given
        //when
        Vehicle achtesAutoInderSchange = testSchlange.get(7);
        LimitedArrayList<Vehicle> schlangeAfterCarsLeft = helperFunctionsForTestsOnly.carWash.carLeavesBeforeWash(2);
        Vehicle siebtesAutoAfterVehicleLeft = schlangeAfterCarsLeft.get(6);
        //then
        Assertions.assertEquals(achtesAutoInderSchange, siebtesAutoAfterVehicleLeft);
    }

    @Test
    public void carInWashCantLeave() {
        //given
        Vehicle autoInDerWaesche = testSchlange.get(0);
        //when
        LimitedArrayList<Vehicle> testSchlangeAfterVehicleInWashTriedToLeave = helperFunctionsForTestsOnly.carWash.carLeavesBeforeWash(2);

        //then
        Assertions.assertEquals(testSchlangeAfterVehicleInWashTriedToLeave.get(0), autoInDerWaesche);

    }

    @Test
    public void newCarInWash() {
        //given
        Motorrad car = new Motorrad();
        int alteLaenge = testSchlange.size();
        //when
        //carWash.newCarComesToWash("HH 2453", "car");
        testSchlange.add(car);
        int neueLaenge = testSchlange.size();
        //then
        Assertions.assertEquals(alteLaenge, neueLaenge - 1);
        Assertions.assertEquals(testSchlange.get(testSchlange.size() - 1).getKennzeichen(), null);
    }

    @Test
    void newPkwComesToWash() {
        //given
        helperFunctionsForTestsOnly.carWash.newCarComesToWash("Pkw", "HH2345");
        //when
        int preisPkw = helperFunctionsForTestsOnly.carWash.getVehicles().get(8).getPreis();
        //then
        Assertions.assertEquals(5, preisPkw);
    }

    @Test
    void newPkwComesToWashSchlangeHasRightLength() {
        //given
        helperFunctionsForTestsOnly.carWash.newCarComesToWash("Pkw", "HH2345");
        //when
        //then
        Assertions.assertEquals(helperFunctionsForTestsOnly.carWash.getVehicles().size(), 9);

    }

    @Test
    void newLkwComesToWashDescriptionAndKennzeichenCorrect() {
        //given
        //when
        helperFunctionsForTestsOnly.carWash.newCarComesToWash("Lkw", "HH-2341");
        String clasNamePkw = helperFunctionsForTestsOnly.carWash.getVehicles().get(8).getClass().getName().replace("carz.", "");
        //then
        Assertions.assertEquals("HH-2341", helperFunctionsForTestsOnly.carWash.getVehicles().get(8).getKennzeichen());
        Assertions.assertEquals("Lkw", clasNamePkw);

    }

    @Test
    void newUnidentifiedCarComesToWashNotAddedToSchlange() {
        //then
        Assertions.assertEquals(8, helperFunctionsForTestsOnly.carWash.getVehicles().size());
        helperFunctionsForTestsOnly.carWash.newCarComesToWash("unidentifiedCar", "HH2345");
        Assertions.assertEquals(8, helperFunctionsForTestsOnly.carWash.getVehicles().size());
    }

    @Test
    void numberOfCarToLeaveWashThrowsExceptionIfIncorectNumber() {
        //given
        //Es befinden sich 8 Fahrzeuge in der Schlange, wobei nur 2-8 (1-7 Index) die Schlange verlassen dürfen.
        //when
        //then
        Assertions.assertThrows(IllegalArgumentException.class, () -> CarWash.numberOfCarToLeaveWash(0));
        Assertions.assertEquals(1, CarWash.numberOfCarToLeaveWash(1));
        Assertions.assertEquals(7, CarWash.numberOfCarToLeaveWash(7));
        Assertions.assertThrows(IllegalArgumentException.class, () -> CarWash.numberOfCarToLeaveWash(8));
    }
}
