import java.awt.Rectangle;

// Ein Quadrat, das manipuliert und auf einer Leinwand gezeichnet werden kann.
public class Quadrat {
  // Anfang Attribute
  private int groesse;
  private String farbe;
  private int xPosition;
  private int yPosition;
  private boolean istSichtbar;
  // Ende Attribute
  
  // Erzeuge ein neues Quadrat mit Standardwerten.
  public Quadrat() {                 
    groesse = 30;
    farbe = "rot";
    xPosition = 60;
    yPosition = 50;
    istSichtbar = false;
  }
  
  // Erzeuge ein neues Quadrat mit Größe g und Farbe f an der Position (x,y).
  public Quadrat(int g, String f, int x, int y) {
    groesse = g;
    farbe = f;
    xPosition = x;
    yPosition = y;
    istSichtbar = false;
  }
  
  // Mache das Quadrat sichtbar.
  public void macheSichtbar() {
    istSichtbar = true;
    zeichne();
  }
  
  // Mache das Quadrat unsichtbar.
  public void macheUnsichtbar() {
    loesche();
    istSichtbar = false;
  }
  
  // Bewege das Quadrat horizontal um 'entfernung' Bildschirmpunkte.
  public void bewegeHorizontal(int entfernung) {
    xPosition += entfernung;
    zeichne();
  }
  
  // Bewege das Quadrat vertikal um 'entfernung' Bildschirmpunkte.
  public void bewegeVertikal(int entfernung) {
    yPosition += entfernung;
    zeichne();
  }
  
  // Bewege das Quadrat langsam horizontal um 'entfernung' Bildschirmpunkte.
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
  
  // Bewege das Quadrat langsam vertikal um 'entfernung' Bildschirmpunkte.
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
  
  // Ändere die Größe des Quadrates in 'neueGroesse'.
  public void aendereGroesse(int neueGroesse) {
    loesche();
    groesse = neueGroesse;
    zeichne();
  }
  
  // Ändere die Farbe des Quadrates in 'neueFarbe'.
  // Gültige Angaben sind "rot", "gelb", "blau", "gruen", "lila" und "schwarz".
  public void aendereFarbe(String neueFarbe) {
    farbe = neueFarbe;
    zeichne();
  }
  
  // Zeichne das Quadrat mit seinen aktuellen Werten auf den Bildschirm.
  private void zeichne() {
    if (istSichtbar) {
      Leinwand leinwand = Leinwand.gibLeinwand();
      leinwand.zeichne(
      this,
      farbe,
      new Rectangle(xPosition, yPosition, groesse, groesse));
      leinwand.warte(10);
    }
  }
  
  // Lösche das Quadrat vom Bildschirm.
  private void loesche() {
    if (istSichtbar) {
      Leinwand leinwand = Leinwand.gibLeinwand();
      leinwand.entferne(this);
    }
  }
}