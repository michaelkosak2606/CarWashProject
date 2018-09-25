package tests;

import helpers.Mathematics;
import org.junit.jupiter.api.Test;
import sun.jvm.hotspot.utilities.Assert;

public class MathematicsTest {
    Mathematics mathematics = new Mathematics();

    @Test
    void randomNumberTest() {
        int randomNUmber = (int) Math.floor(Math.random() * 10000);
        Assert.that(randomNUmber <= 10000 && randomNUmber >= 0, "");
    }

    @Test
    void randomTwoLettersTest() {
        //given
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        //when
        String twoRandomLetters = mathematics.twoRandomLetters();
        String a = twoRandomLetters.substring(0, 1);
        String b = twoRandomLetters.substring(1, 2);
        //then
        Assert.that(alphabet.contains(a) && alphabet.contains(b), "");
    }
}
