package mavenprojekt;

import java.util.ArrayList;

public class RessourceController
{
    private ArrayList<Plattform> vordefiniertePlattformen = new ArrayList<>();
    private ArrayList<Paket> vordefiniertePakete = new ArrayList<>();

    private Plattform ausgewaehltePlattform;
    private ArrayList<Paket> ausgewaehltePakete = new ArrayList<>();

    //Sucht ein Element in den vordefinierten Listen
    public  <t> t sucheElement(String gesucht, String typ) {
        if (typ.toLowerCase().equals("plattform")) {
            for (Plattform plattform : vordefiniertePlattformen) {
                if (plattform.getName().equals(gesucht)) {
                    return (t) plattform;
                }
            }
        } else {
            for (Paket paket : vordefiniertePakete) {
                if (paket.getName().equals(gesucht)) {
                    return (t) paket;
                }
            }
        }
        return null;
    }

    //Gesamtkosten berechnen
    public int kostenrechner() {
        int gesamtpreis = 0;
        gesamtpreis += ausgewaehltePlattform.getKosten();

        for (Paket paket : ausgewaehltePakete) {
            gesamtpreis += paket.getKosten();
        }
        return gesamtpreis;
    }

    public void newVordefiniertePlattformen(){
        vordefiniertePlattformen = new ArrayList<>();
    }

    public void newVordefiniertePakete(){
        vordefiniertePakete = new ArrayList<>();
    }

    public void addPlattform(Plattform plattform){
        vordefiniertePlattformen.add(plattform);
    }

    public void addPakete(Paket paket){
        vordefiniertePakete.add(paket);
    }

    public ArrayList<Plattform> getVordefiniertePlattformen() {
        return vordefiniertePlattformen;
    }

    public ArrayList<Paket> getVordefiniertePakete() {
        return vordefiniertePakete;
    }

    public Plattform getAusgewaehltePlattform() {
        return ausgewaehltePlattform;
    }

    public ArrayList<Paket> getAusgewaehltePakete() {
        return ausgewaehltePakete;
    }

    public void setVordefiniertePlattformen(ArrayList<Plattform> vordefiniertePlattformen) {
        this.vordefiniertePlattformen = vordefiniertePlattformen;
    }

    public void setVordefiniertePakete(ArrayList<Paket> vordefiniertePakete) {
        this.vordefiniertePakete = vordefiniertePakete;
    }

    public void setAusgewaehltePlattform(Plattform ausgewaehltePlattform) {
        this.ausgewaehltePlattform = ausgewaehltePlattform;
    }

    public void setAusgewaehltePakete(ArrayList<Paket> ausgewaehltePakete) {
        this.ausgewaehltePakete = ausgewaehltePakete;
    }
}
