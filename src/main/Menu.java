package main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    CarWash carWash = new CarWash();
    boolean status = true;

    Scanner scanner = new Scanner(System.in);

    public void startMenu() {

        while (status) {
            System.out.println("Eingabe: ");
            eingabeOptionen();
            String eingabe = scanner.next();

            if (eingabe.equals("1")) {
                System.out.println("........................................ ");
                System.out.println("........................................ ");
                showListVehicle();
                System.out.println("........................................ ");
                System.out.println("........................................ ");

            } else if (eingabe.equals("2")) {
                int oldSize = carWash.getVehicles().size();
                System.out.println(expressionOptions(6));
                String kennzeichen = scanner.next();
                System.out.println(expressionOptions(7));
                String description = scanner.next();
                carWash.newCarComesToWash(description, kennzeichen);
                int newSize = carWash.getVehicles().size();
                if (oldSize < newSize) {
                    printExpressions(1);
                }
            } else if (eingabe.equals("0")) {
                printExpressions(0);
                break;
            } else if (carWash.getVehicles().size() > 0 && eingabe.equals("4")) {
                carWash.carWashed();
                expressionOptions(4);
                showListVehicle();
            } else if (carWash.getVehicles().size() > 1 && eingabe.equals("3")) {
                vehicleLeavesBeforeWash();
            } else {
                System.out.println(expressionOptions(8));
            }
        }
    }

    public void eingabeOptionen() {
        if (carWash.getVehicles().size() < 1) {
            System.out.println("0. Programm beenden 1. Liste der Fahrzeuge  2. Neues Vehicle anmelden.");
        } else if (carWash.getVehicles().size() == 1) {
            System.out.println("0. Programm beenden. 1. Liste der Fahrzeuge  2. Neues Vehicle anmelden.  4.Vehicle wurde gewaschen.");
        } else if (carWash.getVehicles().size() > 1) {
            System.out.println("0. Programm beenden. 1. Liste der Fahrzeuge  2. Neues Vehicle anmelden. 3.Vehicle verlässt vorzeitig die Schlange  4.Vehicle wurde gewaschen.");
        }
    }

    public String expressionOptions(int option) {

        if (option == 0) {
            return "Programm wurde beendet.";
        }
        if (option == 1) {
            return "Auto kommt in die Wäsche.";
        }
        if (option == 2) {
            return "Auto " + 1 + ": Kennzeichen " + carWash.getVehicles().get(0).getKennzeichen() + ", Fahrzeugart: " + carWash.getVehicles().get(0).getClass().getName().replace("carz.", "") + ", Wird gewaschen.";
        }

        if (option == 3) {
            return "Es befinden sich keine Fahrzeuge in der Schlange.";
        }
        if (option == 4) {
            return "Auto wurde gewaschen und verlässt die Autowaschanlage.";
        }
        if (option == 5) {
            return "Gebe die Nummer des Fahrzeuges ein, das die Schlange verlassen soll: ";
        }
        if (option == 6) {
            return "Geben sie das Kennzeichen des neuen Autos ein:";
        }
        if (option == 7) {
            return "Geben sie Art des Fahrzeugs ein: Lkw, Pkw oder Motorrad.";
        }
        if(option == 8){
            return "Ungültige Eingabe.";
        }
        return "";
    }

    public void printExpressions(int option) {
        String text = expressionOptions(option);

        System.out.println("........................................ ");
        System.out.println("........................................ ");
        System.out.println(text);
        System.out.println("........................................ ");
        System.out.println("........................................ ");

    }


    public void vehicleLeavesBeforeWash() {
        int oldSize = carWash.getVehicles().size();
        showListVehicle();
        System.out.println(expressionOptions(5));

        int eingabeNummerDesFahrzeugs;
        try {
            eingabeNummerDesFahrzeugs = scanner.nextInt();
            int umrechnungInIndex = eingabeNummerDesFahrzeugs - 1;
            carWash.carLeavesBeforeWash(umrechnungInIndex);
            int newSize = carWash.getVehicles().size();
            if (oldSize > newSize) {
                System.out.println("Das Vehicle Nummer " + eingabeNummerDesFahrzeugs + " hat die Schlange verlassen.");
            }
        } catch (InputMismatchException ex) {
               System.out.println(expressionOptions(8));
               scanner.next();
        }
    }

    public void showListVehicle() {
        if (carWash.getVehicles().size() < 1) {
            System.out.println(expressionOptions(3));
        } else {
            System.out.println(expressionOptions(2));
            for (int i = 1; i < carWash.getVehicles().size(); i++) {
                int numberOfFahrzeug = i + 1;
                System.out.println("Auto " + numberOfFahrzeug + ": Kennzeichen " +
                        carWash.getVehicles().get(i).getKennzeichen() + ", Fahrzeugart: " +
                        carWash.getVehicles().get(i).getClass().getName().replace("carz.", ""));
            }
        }
    }
}
