package tests;

import helpers.CarFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarFactoryTest {

    @Test
    void unidentifiedCarThrowsExceptionInCarFactory() {
        Assertions.
                assertThrows(IllegalArgumentException.class,
                        () -> CarFactory.createCar("unidentifierdCar", "HH2345"));
    }

}

