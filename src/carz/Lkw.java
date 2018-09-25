package carz;

public class Lkw extends Fahrzeug {
    final private int preis = 10;
    String kennzeichen;

    public Lkw(){}
    public Lkw(String kennzeichen){
        this.kennzeichen = kennzeichen;
    }

    @Override
    public int getPreis() {
        return preis;
    }

    @Override
    public String getKennzeichen() {
        return kennzeichen;
    }
}
