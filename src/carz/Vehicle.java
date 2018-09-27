package carz;

public class Vehicle {
    protected String kennzeichen;
    protected int preis = 1;

    public Vehicle(String kennzeichen) {
        this.kennzeichen = kennzeichen;
    }

    public Vehicle() {
    }


    public String getKennzeichen() {
        return kennzeichen;
    }

    public int getPreis() {
        return preis;
    }


    public void setKennzeichen(String kennzeichen) {
        this.kennzeichen = kennzeichen;
    }

    public void setPreis(int preis) {
        this.preis = preis;
    }
}
