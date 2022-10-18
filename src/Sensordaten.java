import java.util.Scanner;

public class Sensordaten {

    // Methode zum Filtern der eingegebenen Messwerte
    static void filterMesswerte() {

        Scanner sc = new Scanner(System.in); // neues Scanner-Objekt

        System.out.println("Geben Sie einen Messwert ein.");

        int einsCounter = 0; // Variable zum Checken der Endbedingung
        int eingabeWert = 0; // Variable zum Speichern der aktuellen Eingabe
        int letzteEingabe = 0; // Variable zum Speichern der letzten Eingabe
        int letztenZweiWerte = 0; // Variable zum Speichern der letzten zwei Werte

        int ausgabe = 0; // Variable zum Speichern der Ausgabe

        // wird ausgeführt bis die Folge 1,1,1 eingegeben wird
        while (einsCounter < 3) {
            letzteEingabe = eingabeWert; // speichert letzte Eingabe
            letztenZweiWerte = ausgabe % 10; // speichert letzten zwei Stellen der Ausgabe

            eingabeWert = sc.nextInt(); // Abfrage der Eingabe

            // Steuerung der Endbedingung bis Eingabe 1,1,1
            if (eingabeWert == 1) {
                einsCounter = einsCounter + 1; // erhöht den einsCounter um eins
            }
            else {
                einsCounter = 0; // einsCounter wird wieder auf 0 gesetzt, wenn Eingabe keine 1
            }

            // filtert die eingegebenen Werte und fügt diese zur Ausgabe hinzu
            if (eingabeWert < -9 || eingabeWert > 9) { // prüft ob Eingabe eine einstellige Zahl ist
                System.out.println("Bitte ganze einstellige Zahl zwischen -9 und 9 eingeben!");
            }
            else if (eingabeWert < 0) {
                eingabeWert = eingabeWert * -1; // berechnet den Betrag negativer Zahlen
                ausgabe = ausgabe * 10 + eingabeWert; // fügt den Eingabewert zur Ausgabe hinzu
                System.out.println("Output: " + ausgabe); // gibt die Ausgabe nach jeder Eingabe aus

            }
            else if (eingabeWert == 0 && (letzteEingabe != 0 && letztenZweiWerte != 0)) { // fasst aufeinander folgende Nullen zusammen
                ausgabe = ausgabe * 10 + eingabeWert; // fügt den Eingabewert zur Ausgabe hinzu
                System.out.println("Output: " + ausgabe); // gibt die Ausgabe nach jeder Eingabe aus
            }

        }

        // Ausgabe der gefilterten Werte nach Erfüllung der Endbedingung
        System.out.println("--------------------");
        System.out.println("Endbedingung erreicht. Die gefilterten Messwerte sind: ");
        System.out.println("Output: " + ausgabe);

    }


    public static void main(String[] args) {
        filterMesswerte(); // ruft Methode filterMesswerte auf
    }
}