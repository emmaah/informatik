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
    //private Quadrat tuer;


    // Ende Attribute

    public ProjektHaus() {
        this.wand = new Quadrat(250, "gelb", -30, 50);
        this.fenster = new Quadrat(70, "schwarz", 100, 80);
        this.dach = new Dreieck(320, 100, "rot", 95, -50);
        //this.tuer = new Quadrat(95, "blau", 550, 285);
        wand.macheSichtbar();
        fenster.macheSichtbar();
        dach.macheSichtbar();
       // tuer.macheSichtbar();
    }

    // Anfang Methoden
    public void zoom() {
        int entfernung = 0;
       while (entfernung <170) {
           // wand.bewegeLangsamVertikal( 3);
           dach.bewegeLangsamVertikal( -5);
          dach.bewegeLangsamHorizontal(3);
           //fenster.bewegeLangsamVertikal( 1);
           fenster.bewegeLangsamHorizontal(1);
           // tuer.bewegeLangsamVertikal( 4);
            wand.aendereGroesse( 250+(entfernung*8));
            fenster.aendereGroesse( 70+(entfernung*4));
            dach.aendereGroesse(100+(entfernung*5),320+(entfernung*15));
           // tuer.aendereGroesse(95+entfernung);
            entfernung ++;
        }

    }
    // Ende Methoden

    public static void main(String [] args)
    {
       ProjektHaus haus = new ProjektHaus();
       haus.zoom();
    }

} // end of ProjektHaus

