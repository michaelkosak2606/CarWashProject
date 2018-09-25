package main;

import java.util.Scanner;

public class Menu {

    AutoWaschAnlage autoWaschAnlage = new AutoWaschAnlage();
    boolean status = true;

    Scanner scanner = new Scanner(System.in);

    public void startMenuAnzeigen() {

        while (status) {
            System.out.println("Eingabe: ");
            eingabeOptionen();
            String eingabe = scanner.next();

            if (eingabe.equals("1")) {
                System.out.println("........................................ ");
                System.out.println("........................................ ");
                autoWaschAnlage.schlangeInfo();
                System.out.println("........................................ ");
                System.out.println("........................................ ");

            } else if (eingabe.equals("2")) {
                int oldSize = autoWaschAnlage.getFahrzeuge().size();
                System.out.println("Geben sie das Kennzeichen des neuen Autos ein:");
                String kennzeichen = scanner.next();
                System.out.println("Geben sie Art des Fahrzeugs ein: Lkw, Pkw oder Motorrad.");
                String description = scanner.next();
                autoWaschAnlage.newCarComesToWash(description, kennzeichen);
                int newSize = autoWaschAnlage.getFahrzeuge().size();
                if (oldSize < newSize) {
                    System.out.println("........................................ ");
                    System.out.println("........................................ ");
                    System.out.println("Auto kommt in die Wäsche.");
                    System.out.println("........................................ ");
                    System.out.println("........................................ ");
                }
            } else if (eingabe.equals("0")) {
                System.out.println("........................................ ");
                System.out.println("........................................ ");
                System.out.println("Programm wurde beendet.");
                System.out.println("........................................ ");
                System.out.println("........................................ ");
                break;
            } else if (autoWaschAnlage.getFahrzeuge().size() > 0 && eingabe.equals("4")) {
                autoWaschAnlage.carWashed();
                System.out.println("Auto wurde gewaschen und verlässt die Autowaschanlage.");
                autoWaschAnlage.schlangeInfo();
            } else if (autoWaschAnlage.getFahrzeuge().size() > 1 && eingabe.equals("3")) {
                fahrzeugLeavesBeforeWash();
            } else {
                System.out.println("Ungültige Eingabe.");
            }
        }
    }

    public void eingabeOptionen() {
        if (autoWaschAnlage.getFahrzeuge().size() < 1) {
            System.out.println("0. Programm beenden 1. Liste der Fahrzeuge  2. Neues Fahrzeug anmelden.");
        } else if (autoWaschAnlage.getFahrzeuge().size() == 1) {
            System.out.println("0. Programm beenden. 1. Liste der Fahrzeuge  2. Neues Fahrzeug anmelden.  4.Fahrzeug wurde gewaschen.");
        } else if (autoWaschAnlage.getFahrzeuge().size() > 1) {
            System.out.println("0. Programm beenden. 1. Liste der Fahrzeuge  2. Neues Fahrzeug anmelden. 3.Fahrzeug verlässt vorzeitig die Schlange  4.Fahrzeug wurde gewaschen.");
        }
    }

    public void printExpressions() {

    }

    public void fahrzeugLeavesBeforeWash() {
        int oldSize = autoWaschAnlage.getFahrzeuge().size();

        autoWaschAnlage.schlangeInfo();
        System.out.println("Gebe die Nummer des Fahrzeuges ein, das die Schlange verlassen soll: ");
        int eingabeNummerDesFahrzeugs = scanner.nextInt();
        int umrechnungInIndex = eingabeNummerDesFahrzeugs - 1;

        autoWaschAnlage.carLeavesBeforeWash(umrechnungInIndex);
        int newSize = autoWaschAnlage.getFahrzeuge().size();

        if (oldSize > newSize) {
            System.out.println("Das Fahrzeug Nummer " + eingabeNummerDesFahrzeugs + " hat die Schlange verlassen.");
        }
            autoWaschAnlage.schlangeInfo();
    }

}
