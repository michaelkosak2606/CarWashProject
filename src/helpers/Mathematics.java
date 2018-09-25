package helpers;

public class Mathematics {

    public String randomNumberAsString() {
        int randomNUmber = (int) Math.floor(Math.random() * 10000);
        String string = Integer.toString(randomNUmber);

        if (string.length() == 1) {
            return "000" + string;
        }
        if (string.length() == 2) {
            return "00" + string;
        }
        if (string.equals("10000")) {
            return "9999";
        }
        return string;
    }

    public String twoRandomLetters() {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String kennzeichen = "";

        for (int i = 1; i <= 2; i++) {

            int randomNuber = (int) Math.floor(Math.random() * 27);
            if (randomNuber == 0) {
                randomNuber = 1;
            }
            if (randomNuber == 27) {
                randomNuber = 26;
            }
            String randomLetter = alphabet.substring(randomNuber - 1, randomNuber);
            kennzeichen = kennzeichen + randomLetter;
        }
        return kennzeichen;
    }
}
