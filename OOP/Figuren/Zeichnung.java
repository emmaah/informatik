/**
 * Beschreibung
 *
 * @author
 * @version 1.0 vom 14.02.2017
 */

public class Zeichnung {

    // Anfang Attribute
    private Quadrat wand;
    private Quadrat fenster;
    private Dreieck dach;
    private Kreis sonne;
    private Kreis mond;


    // Ende Attribute

    public Zeichnung() {
        this.wand = new Quadrat(100, "rot", 60, 130);
        this.fenster = new Quadrat(25, "schwarz", 75, 150);
        this.dach = new Dreieck(140, 50, "gruen", 110, 85);
        this.sonne = new Kreis(60, "gelb", 200, 50);
        this.mond = new Kreis(40, "blau", 10, 200);
        wand.macheSichtbar();
        fenster.macheSichtbar();
        dach.macheSichtbar();
        sonne.macheSichtbar();
        mond.macheSichtbar();
    }

    // Anfang Methoden
    public void inSchwarzWeiss() {
        wand.aendereFarbe("schwarz");
        dach.aendereFarbe("schwarz");
        fenster.aendereFarbe("schwarz");
        sonne.aendereFarbe("schwarz");
    }

    public void inFarbe() {
        wand.aendereFarbe("rot");
        dach.aendereFarbe("gruen");
        sonne.aendereFarbe("gelb");
        fenster.aendereFarbe("schwarz");
    }

    public void Tageswechsel() {
        int entfernung = 0;
        while (entfernung < 150) {
            sonne.bewegeLangsamVertikal(1);
            mond.bewegeLangsamVertikal(-1);
            entfernung++;
        }
    }
    // Ende Methoden
} // end of Zeichnung
