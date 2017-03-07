import java.awt.geom.Ellipse2D;

// Ein Kreis, der manipuliert und auf einer Leinwand gezeichnet werden kann.
public class Kreis {
  // Anfang Attribute
  private int durchmesser;
  private String farbe;
  private int xPosition;
  private int yPosition;
  private boolean istSichtbar;
  // Ende Attribute
  
  // Erzeuge einen neuen Kreis mit Standardwerten.
  public Kreis() {
    durchmesser = 30;
    farbe = "blau";
    xPosition = 20;
    yPosition = 60;
    istSichtbar = false;
  }
  
  // Erzeuge einen neuen Kreis mit Durchmesser d und Farbe f an der Position (x,y).
  public Kreis(int d, String f, int x, int y) {
    durchmesser = d;
    farbe = f;
    xPosition = x;
    yPosition = y;
    istSichtbar = false;
  }
 
  // Mache den Kreis sichtbar.
  public void macheSichtbar() {
    istSichtbar = true;
    zeichne();
  }
  
  // Mache den Kreis unsichtbar.
  public void macheUnsichtbar() {
    loesche();
    istSichtbar = false;
  }
  
  // Bewege den Kreis horizontal um 'entfernung' Bildschirmpunkte.
  public void bewegeHorizontal(int entfernung) {
    xPosition += entfernung;
    zeichne();
  }
  
  // Bewege den Kreis vertikal um 'entfernung' Bildschirmpunkte.
  public void bewegeVertikal(int entfernung) {
    yPosition += entfernung;
    zeichne();
  }
  
  // Bewege den Kreis langsam horizontal um 'entfernung' Bildschirmpunkte.
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
  
  // Bewege den Kreis Dreieck langsam vertikal um 'entfernung' Bildschirmpunkte.
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
  
  // Ändere den Durchmesser des Kreises in 'neuerDurchmesser'.
  public void aendereGroesse(int neuerDurchmesser) {
    loesche();
    durchmesser = neuerDurchmesser;
    zeichne();
  }
  
  // Ändere die Farbe des Kreises in 'neueFarbe'.
  // Gültige Angaben sind "rot", "gelb", "blau", "gruen","lila" und "schwarz".
  public void aendereFarbe(String neueFarbe) {
    farbe = neueFarbe;
    zeichne();
  }
  
  // Zeichne den Kreis mit seinen aktuellen Werten auf den Bildschirm.
  private void zeichne() {
    if (istSichtbar) {
      Leinwand leinwand = Leinwand.gibLeinwand();
      leinwand.zeichne(
      this,
      farbe,
      new Ellipse2D.Double(xPosition, yPosition, durchmesser, durchmesser));
      leinwand.warte(10);
    }
  }
  
  // Lösche den Kreis vom Bildschirm.
  private void loesche() {
    if (istSichtbar) {
      Leinwand leinwand = Leinwand.gibLeinwand();
      leinwand.entferne(this);
    }
  }
}