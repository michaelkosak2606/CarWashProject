package carz;

public class Fahrzeug {
    protected String kennzeichen;
    protected int preis = 1;

    public Fahrzeug(String kennzeichen) {
        this.kennzeichen = kennzeichen;
    }

    public Fahrzeug() {
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
