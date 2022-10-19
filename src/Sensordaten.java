import java.util.Scanner;

public class Sensordaten {

    // Methode zum Filtern der eingegebenen Messwerte
    static void filterMesswerte() {

        Scanner sc = new Scanner(System.in); // neues Scanner-Objekt

        System.out.println("Geben Sie Messwerte ein:");

        int einsCounter = 0; // Zähler für die Endbedingung 1,1,1
        int eingabeWert; // Variable zum Speichern der aktuellen Eingabe
        int nullCounter = 0; // Zähler für die eingegebenen Nullen

        // wird ausgeführt bis die Folge 1,1,1 eingegeben wird
        while (einsCounter < 3) {

            eingabeWert = sc.nextInt(); // Abfrage der Eingabe

            // Steuerung der Endbedingung bis Eingabe 1,1,1
            if (eingabeWert == 1) {
                einsCounter++; // erhöht den einsCounter um eins
            }
            else {
                einsCounter = 0; // einsCounter wird wieder auf 0 gesetzt, wenn Eingabe keine 1
            }

            // Filterung der eingegebenen Werte
            if (eingabeWert < 0) {
                nullCounter = 0; // setzt den nullCounter auf 0
                einsCounter = 0; // setzt den einsCounter auf 0
                eingabeWert *= -1; // berechnet den Betrag der eingegebenen Zahl
                System.out.println("Output: " + eingabeWert); // gibt den gefilterten Wert aus
            }

            // prüft, ob eine Null eingegeben wurde und filtert diese
            if (eingabeWert == 0 && nullCounter == 0) {
                System.out.println("Output: " + eingabeWert);
                nullCounter++; // erhöht den nullCounter um 1
            }
        }
    }

    public static void main(String[] args) {
        filterMesswerte(); // ruft Methode filterMesswerte auf
    }
}