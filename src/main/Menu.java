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
                printExpressions(9);

            } else if (eingabe.equals("2")) {
                newVehicleSignsIn();
            } else if (eingabe.equals("0")) {
                printExpressions(0);
                break;
            } else if (carWash.getVehicles().size() > 0 && eingabe.equals("4")) {
                carWash.carWashed();
                expressionOptions(4);
                System.out.println(showListOfVehicles());
            } else if (carWash.getVehicles().size() > 1 && eingabe.equals("3")) {
                vehicleLeavesBeforeWash();
            } else {
                System.out.println(expressionOptions(8));
            }
        }
    }

    public void eingabeOptionen() {
        if (carWash.getVehicles().size() < 1) {
            System.out.println("0. Programm beenden 1. Liste der Fahrzeuge  2. Neues Fahrzeug anmelden.");
        } else if (carWash.getVehicles().size() == 1) {
            System.out.println("0. Programm beenden. 1. Liste der Fahrzeuge  2. Neues Fahrzeug anmelden.  4.Fahrzeug wurde gewaschen.");
        } else if (carWash.getVehicles().size() > 1) {
            System.out.println("0. Programm beenden. 1. Liste der Fahrzeuge  2. Neues Fahrzeug anmelden. 3.Fahrzeug verlässt vorzeitig die Schlange  4.Fahrzeug wurde gewaschen.");
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
            return "Auto " + 1 + ": Kennzeichen " + carWash.getVehicles().get(0).getKennzeichen() +
                    ", Fahrzeugart: " + carWash.getVehicles().get(0).getClass().getName().replace("carz.", "")
                    + ", Wird gewaschen. \n";
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
        if (option == 8) {
            return "Ungültige Eingabe.";
        }
        if (option == 9) {
            return showListOfVehicles();
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

    public void newVehicleSignsIn() {
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
    }

    public void vehicleLeavesBeforeWash() {
        int oldSize = carWash.getVehicles().size();
        System.out.println(showListOfVehicles());
        System.out.println(expressionOptions(5));

        int inputNumberOfVehicle;
        try {
            inputNumberOfVehicle = scanner.nextInt();
            int umrechnungInIndex = inputNumberOfVehicle - 1;
            carWash.carLeavesBeforeWash(umrechnungInIndex);
            int newSize = carWash.getVehicles().size();
            if (oldSize > newSize) {
                System.out.println("Das Fahrzeug Nummer " + inputNumberOfVehicle + " hat die Schlange verlassen.");
            }
        } catch (InputMismatchException ex) {
            System.out.println(expressionOptions(8));
            scanner.next();
        }
    }

    public String showListOfVehicles() {
        String listOfVehiclesFromByTwoOrMore = "";
        if (carWash.getVehicles().size() < 1) {
            return expressionOptions(3);
        } else if (carWash.getVehicles().size() == 1) {
            return expressionOptions(2);
        } else {
            for (int i = 1; i < carWash.getVehicles().size(); i++) {
                int numberOfFahrzeug = i + 1;
                String text = "Auto " + numberOfFahrzeug + ": Kennzeichen " +
                        carWash.getVehicles().get(i).getKennzeichen() + ", Fahrzeugart: " +
                        carWash.getVehicles().get(i).getClass().getName().replace("carz.", "") + "\n";
                listOfVehiclesFromByTwoOrMore = listOfVehiclesFromByTwoOrMore + text;
            }
                return expressionOptions(2) + listOfVehiclesFromByTwoOrMore;
        }
    }
}
