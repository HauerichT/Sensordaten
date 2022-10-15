/*
 * Berechnet den Wochentag aus einem angegebenen Datum (Tag, Monat, Jahr) mit einer entsprechenden Formel.
 * Die Monate Januar und Februar werden separat betrachtet und angepasst, sodass die Formel weiterhin greift.
 * Die Formel gibt den Index des Wochentages zurück, welcher dem zugehörigen String des Wochentages zugeordnet
 * und ausgegeben wird.
 */

import java.util.Scanner;

public class Main {

    static void filterMesswerte() {

        Scanner sc = new Scanner(System.in); // neues Scanner-Objekt

        System.out.println("Geben Sie einen Messwert ein.");

        int einsCounter = 0;
        int eingabeWert = 0;
        int letzteEingabe = 0;
        int letztenZweiWerte = 0;

        int ausgabe = 0;

        while(einsCounter < 3) {
            letzteEingabe = eingabeWert;
            letztenZweiWerte = ausgabe % 10;

            eingabeWert = sc.nextInt();

            if (eingabeWert == 1) {
                einsCounter = einsCounter + 1;
            } else {
                einsCounter = 0;
            }

            if (eingabeWert < -9 || eingabeWert > 9) {
                System.out.println("Bitte ganze einstellige Zahl zwischen -9 und 9 eingeben!");
            }
            else if (eingabeWert < 0) {
                eingabeWert = eingabeWert * -1;
                ausgabe = ausgabe * 10 + eingabeWert;
            }
            else if (eingabeWert == 0 && (letzteEingabe != 0 && letztenZweiWerte != 0)) {
                ausgabe = ausgabe * 10 + eingabeWert;
            }

            System.out.println("Output: " + ausgabe);
        }

        System.out.println("--------------------");
        System.out.println("Endbedingung erreicht. Die gefilterten Messwerte sind: ");
        System.out.println("Output: " + ausgabe);


    }


    public static void main(String[] args) {
        filterMesswerte();
    }
}