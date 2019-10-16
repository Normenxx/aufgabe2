package mavenprojekt;

import mavenprojekt.RessourceController;

import java.util.Scanner;

/**
*/

public class Autokonfigurator {
    public static void main(String[] args) {
      Autokonfigurator autokonfigurator = new Autokonfigurator();
      autokonfigurator.menu();
    }

    private  void menu(){
        Scanner scanner = new Scanner(System.in);
        RessourceController ressourceController = new RessourceController();
        Anzeigenverwalter anzeigenverwalter = new Anzeigenverwalter(ressourceController);
        RessourceLoader ressourceLoader = new RessourceLoader(ressourceController);
        ressourceLoader.datenLaden();
        String eingabe = "";


        if (!(ressourceController.getVordefiniertePlattformen().size() == 0 || ressourceController.getVordefiniertePakete().size() == 0)) {

            /*
        0 Plattform wählen
        1 Paket wählen
        2 Ergebnis anzeigen
         */
            int status = 0;
            boolean fertig = false;
            while (!fertig) {
                switch (status) {
                    case 0:
                        anzeigenverwalter.status();
                        anzeigenverwalter.plattformen();

                        System.out.println("Geben Sie den Namen der Plattform ein oder schreiben Sie 'weiter':");
                        eingabe = scanner.nextLine();
                        Plattform gesuchtePlattform = ressourceController.sucheElement(eingabe, "plattform");
                        if (gesuchtePlattform != null) {
                            ressourceController.setAusgewaehltePlattform(gesuchtePlattform);
                        } else if (eingabe.equals("weiter")) {
                            status = 1;
                        } else {
                            System.out.println("Name wurde falsch eingegeben!");
                        }
                        break;
                    case 1:
                        anzeigenverwalter.status();
                        anzeigenverwalter.pakete();

                        System.out.println("Geben Sie den Namen des Pakets ein oder schreiben Sie 'weiter' oder schreiben Sie 'zurueck':");
                        eingabe = scanner.nextLine();
                        Paket gesuchtePakete = ressourceController.sucheElement(eingabe, "pakete");
                        if (gesuchtePakete != null && ressourceController.getAusgewaehltePakete().contains(gesuchtePakete)) {
                            ressourceController.getAusgewaehltePakete().remove(gesuchtePakete);
                        } else if (gesuchtePakete != null) {
                            ressourceController.getAusgewaehltePakete().add(gesuchtePakete);
                        } else if (eingabe.equals("weiter")) {
                            status = 2;
                        } else if (eingabe.equals("zurueck")) {
                            status = 0;
                        } else {
                            System.out.println("Name wurde falsch eingegeben!");
                        }
                        break;
                    case 2:
                        if (ressourceController.getAusgewaehltePlattform() == null || ressourceController.getAusgewaehltePakete().size() <= 0) {
                            System.out.println("Auswahl ungültig");
                            status = 1;
                        } else {
                            anzeigenverwalter.bestellung();
                            System.out.println("Schreiben Sie 'fertig' um die Bestellung zu bestätigen oder schreiben Sie 'zurueck':");
                            eingabe = scanner.nextLine();

                            if (eingabe.equals("fertig")) {
                                status = 3;
                            } else if (eingabe.equals("zurueck")) {
                                status = 1;
                            }
                        }
                        break;
                    case 3:
                        System.out.println("Bestellung wurde versendet.");
                        fertig = true;
                        break;
                }
            }
        }
    }
}
