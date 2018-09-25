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
                schlangeInfo();
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
                    printExpressions(1);
                }
            } else if (eingabe.equals("0")) {
                printExpressions(0);
                break;
            } else if (autoWaschAnlage.getFahrzeuge().size() > 0 && eingabe.equals("4")) {
                autoWaschAnlage.carWashed();
                printExpressionsOption(4);
                schlangeInfo();
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

    public String printExpressionsOption(int option) {

        if (option == 0) {
            return "Programm wurde beendet.";
        }
        if (option == 1) {
            return "Auto kommt in die Wäsche.";
        }
        if (option == 2) {
            return "Auto " + 1 + ": Kennzeichen " + autoWaschAnlage.getFahrzeuge().get(0).getKennzeichen() + ", Fahrzeugart: " + autoWaschAnlage.getFahrzeuge().get(0).getClass().getName().replace("carz.", "") + ", Wird gewaschen.";
        }

        if (option == 4) {
            return "Auto wurde gewaschen und verlässt die Autowaschanlage.";
        }
        return "";
    }

    public void printExpressions(int option) {
        String text = printExpressionsOption(option);

        System.out.println("........................................ ");
        System.out.println("........................................ ");
        System.out.println(text);
        System.out.println("........................................ ");
        System.out.println("........................................ ");

    }


    public void fahrzeugLeavesBeforeWash() {
        int oldSize = autoWaschAnlage.getFahrzeuge().size();
        schlangeInfo();
        System.out.println("Gebe die Nummer des Fahrzeuges ein, das die Schlange verlassen soll: ");

        int eingabeNummerDesFahrzeugs = scanner.nextInt();
        int umrechnungInIndex = eingabeNummerDesFahrzeugs - 1;
        autoWaschAnlage.carLeavesBeforeWash(umrechnungInIndex);

        int newSize = autoWaschAnlage.getFahrzeuge().size();
        if (oldSize > newSize) {
            System.out.println("Das Fahrzeug Nummer " + eingabeNummerDesFahrzeugs + " hat die Schlange verlassen.");
        }
        schlangeInfo();
    }

    public void schlangeInfo() {
        if (autoWaschAnlage.getFahrzeuge().size() < 1) {
            System.out.println("Es befinden sich keine Fahrzeuge in der Schlange.");
        } else {
            System.out.println(printExpressionsOption(2));
            for (int i = 1; i < autoWaschAnlage.getFahrzeuge().size(); i++) {
                int numberOfFahrzeug = i + 1;
                System.out.println("Auto " + numberOfFahrzeug + ": Kennzeichen " + autoWaschAnlage.getFahrzeuge().get(i).getKennzeichen() + ", Fahrzeugart: " + autoWaschAnlage.getFahrzeuge().get(i).getClass().getName().replace("carz.", ""));

            }
            System.out.println();

        }
    }
}
