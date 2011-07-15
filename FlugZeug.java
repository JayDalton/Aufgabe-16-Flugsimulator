/*############################################################################
  Kodierung: UTF-8 ohne BOM - üöä
############################################################################*/

//############################################################################
/** Repräsentiert ein Flugzeug
  *
  * @author Thomas Gerlach
*/
//############################################################################
public class FlugZeug
{
  /** Der Titel des Flugzeugtypes */
  private String titel;

  /** Die maximale Auslastung der Ladung des Flugzeuges */
  private int maximum;

  /** Die aktuelle Auslastung der Ladung des Flugzeuges */
  private int current;

  //##########################################################################
  /** Konstruiert ein Objekt Flugzeug mit zufälligem Fluigtyp
  */
  //##########################################################################
	public FlugZeug()
	{
    int index = Generator.ganzzahl(0, FlugZeugTypen.getAnzahl() - 1);
    titel = FlugZeugTypen.getTitel(index);
    maximum = FlugZeugTypen.getSitze(index);
    laden();
  }

  //##########################################################################
  /** Belädt das Flugzeug mit einer zufälligen Anzahl aktueller Passagiere
    *
    * @return Anzahl der Passagiere
  */
  //##########################################################################
  public int laden()
  {
    current = Generator.ganzzahl(0, maximum);
    return current;
  }
  
  //##########################################################################
  /** Liefert den Titel des Flugzeuges
    *
    * @return Titel des Flugzeuges
  */
  //##########################################################################
  public String getTitel()
  {
    return titel;
  }

  //##########################################################################
  /** Liefert die aktuelle Anzahl der Passagiere des Flugzeuges
    *
    * @return Anzahl der Passagiere
  */
  //##########################################################################
  public int getCurrent()
  {
    return current;
  }

  //##########################################################################
  /** Liefert die maximale Anzahl der Passagiere des Flugzeuges
    *
    * @return Anzahl der Passagiere
  */
  //##########################################################################
  public int getMaximum()
  {
    return maximum;
  }
}
