package mavenprojekt;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Anzeigenverwalter {
    RessourceController ressourceController;

    public Anzeigenverwalter(RessourceController ressourceController) {
        this.ressourceController = ressourceController;
    }

    //Zeigt alle Ausgewählten Pakete oder Plattformen an
    public void status() {
        System.out.println("----------------------------------------------");
        System.out.println("Ausgewaehlte Plattform:");
        if (ressourceController.getAusgewaehltePlattform() == null) {
            System.out.println("-");
        } else {
            System.out.println(ressourceController.getAusgewaehltePlattform().toString());
        }
        System.out.println("Ausgewaehlte Pakete:");
        if (ressourceController.getAusgewaehltePakete().size() == 0) {
            System.out.println("-");
        } else {
            for (Paket paket : ressourceController.getAusgewaehltePakete()) {
                System.out.println(paket.toString());
            }
        }
        System.out.println("----------------------------------------------");
    }

    //Zeigt die Bestellung an
    public void bestellung() {
        System.out.println("\n\nBestellung");
        System.out.println("Kosten (in Euro): " + ressourceController.kostenrechner());
        System.out.println("Lieferzeit (in Monate): " + ressourceController.getAusgewaehltePlattform().getLieferzeit());

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, ressourceController.getAusgewaehltePlattform().getLieferzeit());
        Date date = cal.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        System.out.println("Lieferdatum: " + dateFormat.format(date));

        System.out.println("Plattform:");
        System.out.println(ressourceController.getAusgewaehltePlattform().toString());

        System.out.println("Pakete:");
        for (Paket paket : ressourceController.getAusgewaehltePakete()) {
            System.out.println(paket.toString());
        }

    }

    //Zeige alle Pakete an
    public void pakete() {
        System.out.println("----------------------------------------------");
        System.out.println("Moegliche Pakete:");
        for (Paket paket : ressourceController.getVordefiniertePakete()) {
            System.out.println(paket.toString());
        }
        System.out.println("----------------------------------------------");
    }

    //Zeige alle Plattform  an
    public void plattformen() {
        System.out.println("----------------------------------------------");
        System.out.println("Moegliche Plattformen:");
        for (Plattform plattform : ressourceController.getVordefiniertePlattformen()) {
            System.out.println(plattform.toString());
        }
        System.out.println("----------------------------------------------");
    }
}
