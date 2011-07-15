/*############################################################################
  Kodierung: UTF-8 ohne BOM - üöä
############################################################################*/

import java.util.ArrayList;

//############################################################################
/** Repräsentiert einen Flughafen mit zufälligen Eigenschften
  *
  * @author Thomas Gerlach
*/
//############################################################################
public class FlugHafen
{
  /** der Titel des Flughafen */
  private String sTitel;

  /** die Anzahl der maximal verfügbaren Gates */
  private int nMaximum;

  /** die Anzahl der aktuell verfügbaren Gates */
  private int nCurrent;

  /** die Liste der aktuellen Flugzeuge an den Gates */
  private ArrayList<FlugZeug> lGates;
  
  //##########################################################################
  /** Konstruiert einen Flughafen mit zufälligen Werten
  */
  //##########################################################################
	public FlugHafen()
	{
    sTitel = Generator.symbole(3, "A", "Z");
    nMaximum = Generator.ganzzahl(10, 39);
    nCurrent = Generator.ganzzahl(Math.round(nMaximum / 4), nMaximum - 1);
    lGates = new ArrayList<FlugZeug>(nCurrent);
    for (int i = 0; i < nCurrent; i++) {
      lGates.add(new FlugZeug());
    }
  }

  //##########################################################################
  /** Liefert den Titel des Flughafens
    *
    * @return Titel des Flughafens
  */
  //##########################################################################
  public String getTitel()
  {
    return sTitel;
  }

  //##########################################################################
  /** Liefert die aktuelle Anzahl der Flugzeuge an den Gates
    *
    * @return Anzahl der Flugzeuge
  */
  //##########################################################################
  public int getCurrent()
  {
    return lGates.size();
  }
  
  //##########################################################################
  /** Liefert die maximale Anzahl der Flugzeuge an den Gates
    *
    * @return Anzahl der Flugzeuge
  */
  //##########################################################################
  public int getMaximum()
  {
    return nMaximum;
  }
  
  //##########################################################################
  /** Liefert das erste Flugzeug im Hafen und entfernt dieses aus der Liste
    *
    * @return Flugzeug
  */
  //##########################################################################
  public FlugZeug getFlugZeug()
  {
    FlugZeug objekt = null;
    if (0 < lGates.size())
    {
      objekt = lGates.remove(0);
      objekt.laden();
    }
    return objekt;
  }

  //##########################################################################
  /** Setzt das Flugzeug im Hafen und liefert den Erfolg
    *
    * @return Erfolg
  */
  //##########################################################################
  public boolean setFlugZeug(FlugZeug objekt)
  {
    boolean ergebnis = false;
    if (objekt != null && lGates.size() < nMaximum)
    {
      lGates.add(objekt);
      ergebnis = true;
    }
    return ergebnis;
  }
}


