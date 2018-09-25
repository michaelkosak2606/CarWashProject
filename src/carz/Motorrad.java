package carz;

public class Motorrad extends Fahrzeug {
    final private int preis = 2;
    private String kennzeichen;


    public Motorrad(){}

    public Motorrad(String kennzeichen){
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
