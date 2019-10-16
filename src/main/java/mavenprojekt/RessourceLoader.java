package mavenprojekt;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;

public class RessourceLoader {
    private RessourceController ressourceController;
    public RessourceLoader( RessourceController ressourceController) {
        this.ressourceController = ressourceController;
    }

    //Ladet Informationen aus den Txt Dateien und erstellt die vordefinierten Arraylisten
    public void datenLaden() {
        Charset zeichensatz = Charset.forName("ISO-8859-1");

        Path pfad1 =  Path.of("config","plattform.txt");
        try (BufferedReader reader = Files.newBufferedReader(pfad1, zeichensatz)) {
            ressourceController.newVordefiniertePlattformen();
            String zeile = reader.readLine();
            while (zeile != null) {
                String daten[] = zeile.split(";");

                Plattform plattform = new Plattform(daten[0], daten[1], Integer.parseInt(daten[2]), Integer.parseInt(daten[3]));
                ressourceController.addPlattform(plattform);
                zeile = reader.readLine();
            }
        } catch (NoSuchFileException e) {
            System.err.println("plattform.txt konnte nicht gefunden werden.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        Path pfad2 = Path.of("config","pakete.txt");
        try (BufferedReader reader = Files.newBufferedReader(pfad2, zeichensatz)) {
            ressourceController.newVordefiniertePakete();
            String zeile = reader.readLine();
            while (zeile != null) {
                String daten[] = zeile.split(";");

                Paket paket = new Paket(daten[0], daten[1], Integer.parseInt(daten[2]), Integer.parseInt(daten[3]));
                ressourceController.addPakete(paket);
                zeile = reader.readLine();
            }
        } catch (NoSuchFileException e) {
            System.err.println("pakete.txt konnte nicht gefunden werden.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
