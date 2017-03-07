import java.awt.Polygon;

// Ein Dreieck, das manipuliert und auf einer Leinwand zeichnet werden kann.
public class Dreieck {
  // Anfang Attribute
  private int breite;
  private int hoehe;
  private String farbe;
  private int xPosition;
  private int yPosition;
  private boolean istSichtbar;
  // Ende Attribute
  
  // Erzeuge ein Dreieck mit Standardwerten.
  public Dreieck() {
    breite = 40;
    hoehe = 30;
    farbe = "gruen";
    xPosition = 50;
    yPosition = 15;
    istSichtbar = false;
  }
  
  // Erzeuge ein Dreieck mit Breite b, Höhe h und Farbe f an der Position (x,y).
  public Dreieck(int b, int h, String f, int x, int y) {
    breite = b;
    hoehe = h;
    farbe = f;
    xPosition = x;
    yPosition = y;
    istSichtbar = false;
  }
  
  // Mache das Dreieck sichtbar.
  public void macheSichtbar() {
    istSichtbar = true;
    zeichne();
  }
  
  // Mache das Dreieck unsichtbar.
  public void macheUnsichtbar() {
    loesche();
    istSichtbar = false;
  }
  
  // Bewege das Dreieck horizontal um 'entfernung' Bildschirmpunkte.
  public void bewegeHorizontal(int entfernung) {
    xPosition += entfernung;
    zeichne();
  }
  
  // Bewege das Dreieck vertikal um 'entfernung' Bildschirmpunkte.
  public void bewegeVertikal(int entfernung) {
    yPosition += entfernung;
    zeichne();
  }
  
  // Bewege das Dreieck langsam horizontal um 'entfernung' Bildschirmpunkte.
  public void bewegeLangsamHorizontal(int entfernung) {
    int delta;
    
    if (entfernung < 0) {
      delta = -1;
      entfernung = -entfernung;
    }
    else {
      delta = 1;
    }
    
    for (int i = 0; i < entfernung; i++) {
      xPosition += delta;
      zeichne();
    }
  }
  
  // Bewege das Dreieck langsam vertikal um 'entfernung' Bildschirmpunkte.
  public void bewegeLangsamVertikal(int entfernung) {
    int delta;
    
    if (entfernung < 0) {
      delta = -1;
      entfernung = -entfernung;
    }
    else {
      delta = 1;
    }
    
    for (int i = 0; i < entfernung; i++) {
      yPosition += delta;
      zeichne();
    }
  }
  
  // Ändere die Höhe in 'neueHoehe' und die Breite in 'neueBreite'.
  public void aendereGroesse(int neueHoehe, int neueBreite) {
    loesche();
    hoehe = neueHoehe;
    breite = neueBreite;
    zeichne();
  }
  
  // Ändere die Farbe des Dreiecks in 'neueFarbe'.
  // Gültige Angaben sind "rot", "gelb", "blau", "gruen", "lila" und "schwarz".
  public void aendereFarbe(String neueFarbe) {
    farbe = neueFarbe;
    zeichne();
  }
  
  // Zeichne des Dreieck mit seinen aktuellen Werten auf den Bildschirm.
  private void zeichne() {
    if (istSichtbar) {
      Leinwand leinwand = Leinwand.gibLeinwand();
      int[] xpoints =
      { xPosition, xPosition + (breite / 2), xPosition - (breite / 2)};
      int[] ypoints = { yPosition, yPosition + hoehe, yPosition + hoehe };
      leinwand.zeichne(this, farbe, new Polygon(xpoints, ypoints, 3));
      leinwand.warte(10);
    }
  }
  
  // Lösche dieses Dreieck vom Bildschirm.
  private void loesche() {
    if (istSichtbar) {
      Leinwand leinwand = Leinwand.gibLeinwand();
      leinwand.entferne(this);
    }
  }
}