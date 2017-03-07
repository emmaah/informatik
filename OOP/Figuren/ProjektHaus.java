import java.awt.*;

/**
 * Beschreibung
 *
 * @author
 * @version 1.0 vom 14.02.2017
 */

public class ProjektHaus {

    // Anfang Attribute
    private Quadrat wand;
    private Quadrat fenster;
    private Dreieck dach;
    private Dreieck koerper1;
    private Dreieck koerper2;
    private Kreis kopf1;
    private Kreis kopf2;
    private Quadrat wiese;
    private Kreis lampe;
    private Leinwand leinwand;


    // Ende Attribute

    public ProjektHaus() {
        this.leinwand = Leinwand.gibLeinwand();
        this.wand = new Quadrat(250, "hellgrau", -30, 50);
        this.fenster = new Quadrat(70, "schwarz", 100, 100);
        this.dach = new Dreieck(320, 100, "rot", 95, -50);
        this.wiese = new Quadrat(1000, "gruen", 0, 200);
        this.lampe = new Kreis(100, "orange", 400, -50);
        wiese.macheSichtbar();
        wand.macheSichtbar();
        fenster.macheSichtbar();
        dach.macheSichtbar();
    }

    // Anfang Methoden

    public void dachWeg() {
        int entfernung = 0;
        while (entfernung < 105) {
            wand.bewegeLangsamVertikal(-2);
            wand.aendereGroesse(250 + (entfernung * 8));
            dach.bewegeLangsamVertikal(-2);
            dach.aendereGroesse(100, 320 + (entfernung * 15));
            fenster.aendereGroesse(70 + (entfernung * 4));
            entfernung++;
        }
        dach.macheUnsichtbar();
        wiese.macheUnsichtbar();
    }


    public void zoomFenster() {
        int entfernung = 0;
        while (entfernung < 100) {
            fenster.bewegeLangsamHorizontal(-1);
            fenster.bewegeLangsamVertikal(-1);
            fenster.aendereGroesse(70 + (105 * 4) + (entfernung * 4));
            entfernung++;

        }

    }

    public void lampeEinschalten() {
        lampe.macheSichtbar();
        leinwand.warte(3000);
        fenster.aendereFarbe("weiss");
        lampe.aendereFarbe("gelb");


    }
    // Ende Methoden

    public static void main(String[] args) {
        ProjektHaus haus = new ProjektHaus();
        haus.dachWeg();
        haus.zoomFenster();
        haus.lampeEinschalten();

    }

} // end of ProjektHaus

