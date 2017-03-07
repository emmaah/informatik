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
    private Kreis kopf;
    private Dreieck koerper;
    private Quadrat wiese;
    private Kreis lampe;
    private Leinwand leinwand;
    private Quadrat boden;
    private Kreis auge1;
    private Kreis auge2;


    // Ende Attribute

    public ProjektHaus() {
        this.leinwand = Leinwand.gibLeinwand();
        this.wand = new Quadrat(250, "hellgrau", -30, 50);
        this.fenster = new Quadrat(70, "schwarz", 100, 100);
        this.dach = new Dreieck(320, 100, "rot", 95, -50);
        this.wiese = new Quadrat(1000, "gruen", 0, 200);
        this.lampe = new Kreis(100, "orange", 400, -50);
        this.boden = new Quadrat(850, "grau", 0, 400);
        this.kopf = new Kreis(50, "gelb", -50, 320);
        this.koerper = new Dreieck(50, 75, "rot", -25, 370);
        this.auge1 = new Kreis(10, "blau", 360, 333);
        this.auge2 = new Kreis(10, "blau", -20, 333);
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

    public void zimmer() {
        lampe.macheSichtbar();
        leinwand.warte(3000);
        fenster.aendereFarbe("weiss");
        lampe.aendereFarbe("gelb");
        kopf.macheSichtbar();
        koerper.macheSichtbar();
        auge2.macheSichtbar();
        boden.macheSichtbar();
        int entfernung = 0;
        while (entfernung < 400) {
            kopf.bewegeLangsamHorizontal(1);
            koerper.bewegeLangsamHorizontal(1);
            auge2.bewegeLangsamHorizontal(1);
            entfernung++;
        }
        auge1.macheSichtbar();

    }
    // Ende Methoden

    public static void main(String[] args) {
        ProjektHaus haus = new ProjektHaus();
        haus.dachWeg();
        haus.zoomFenster();
        haus.zimmer();

    }

} // end of ProjektHaus

