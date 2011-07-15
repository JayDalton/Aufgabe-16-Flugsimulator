/*############################################################################
  Kodierung: UTF-8 ohne BOM - üöä
############################################################################*/

//############################################################################
/** Repräsentiert eine Fluginformation zwischen zwei Häfen
  *
  * @author Thomas Gerlach
*/
//############################################################################
public class FlugInfo // FlugInformation
{
  /** Name des Zielflughafens */
  private String hafenAn;

  /** Name des Quellflughafens */
  private String hafenAb;

  /** Objket Flugzeug das geflogen ist */
  private FlugZeug flieger;
  
  //##########################################################################
  /** Konstruiert eine Fluginformation mittels Zielflughafen, Quellflughafen
    * und Flieger
    *
    * @param derHafenAb Name des Quellflughafens
    * @param derFlieger Objekt des Fliegers
    * @param derHafenAn Name des Zielflughafens
  */
  //##########################################################################
  public FlugInfo(String derHafenAb, FlugZeug derFlieger, String derHafenAn)
  {
    hafenAb = derHafenAb;
    hafenAn = derHafenAn;
    flieger = derFlieger;
  }

  //##########################################################################
  /** Liefert den Namen des Quellflughafens
    *
    * @return Name des Flughafens
  */
  //##########################################################################
  public String getFlugHafenAb()
  {
    return hafenAb;
  }

  //##########################################################################
  /** Liefert den Namen des Zielflughafens
    *
    * @return Name des Flughafens
  */
  //##########################################################################
  public String getFlugHafenAn()
  {
    return hafenAn;
  }

  //##########################################################################
  /** Liefert das Objekt des Fliegers
    *
    * @return Objekt des Fliegers
  */
  //##########################################################################
  public String getFlugZeug()
  {
    return flieger.getTitel();
  }

  //##########################################################################
  /** Liefert die Anzahl der aktuell enthaltenen Passagiere
    *
    * @return Anzahl der Passagiere
  */
  //##########################################################################
  public int getCurrent()
  {
    return flieger.getCurrent();
  }

  //##########################################################################
  /** Liefert die Anzahl der maximal enthaltenen Passagiere
    *
    * @return Anzahl der Passagiere
  */
  //##########################################################################
  public int getMaximum()
  {
    return flieger.getMaximum();
  }
}


