/*############################################################################
  Kodierung: UTF-8 ohne BOM - üöä
############################################################################*/

//############################################################################
/**
*/
//############################################################################
public enum FlugZeugTypen
{
  
  TYP_01("Airbus 320", 174),
  TYP_02("Airbus 330", 325),
  TYP_03("Boeing 737", 144),
  TYP_04("Boeing 757", 209),
  TYP_05("Dornier 328", 33),
  TYP_06("Fokker F10", 100),
  TYP_07("Learjet 35", 8),
  TYP_08("McDonnell Douglas MD-88", 152),
  TYP_09("Saab 340", 33);

  /** der Titel des Flugzeuges */
  private String titel;

  /** die Anzahl der Sitze des Flugzeuges */
  private int sitze;

  //##########################################################################
  /** Konstruiert ein Flugzeug mit übergebenem Titel und Anzahl der Sitze
    *
    * @param derTitel
    * @param dieSitze
  */
  //##########################################################################
	private FlugZeugTypen(String derTitel, int dieSitze)
	{
    titel = derTitel;
    sitze = dieSitze;
  }

  //##########################################################################
  /** Liefert die Anzahl der insgesamt verfügbaren Flugzeugtypen
    *
    * @return Anzahl Flugzeugtypen
  */
  //##########################################################################
  public static int getAnzahl() 
  {
    return FlugZeugTypen.values().length;
  }
  
  //##########################################################################
  /** Liefert die Anzahl den Titel eines Flugzeuges für den übergebenen Index
    *
    * @param index Index des Flugzeugtypes
    *
    * @return Titel des Flugzeuges
  */
  //##########################################################################
  public static String getTitel(int index) 
  {
    String ergebnis = new String();
    if (0 <= index && index < FlugZeugTypen.values().length)
    {
      ergebnis = FlugZeugTypen.values()[index].getTitel();
    }
    return ergebnis;
  }
  
  //##########################################################################
  /** Liefert die Anzahl der Sitze eines Flugzeuges für den übergebenen Index
    *
    * @param index Index des Flugzeugtypes
    *
    * @return Anzahl der Sitze
  */
  //##########################################################################
  public static int getSitze(int index) 
  {
    int ergebnis = 0;
    if (0 <= index && index < FlugZeugTypen.values().length)
    {
      ergebnis = FlugZeugTypen.values()[index].getSitze();
    }
    return ergebnis;
  }
  
  //##########################################################################
  /** Liefert die Anzahl der Sitze des Flugzeuges
    *
    * @return Anzahl der Sitze
  */
  //##########################################################################
  private int getSitze() 
  {
    return sitze;
  }

  //##########################################################################
  /** Liefert den Titel des Flugzeuges
    *
    * @return Titel des Flugzeuges
  */
  //##########################################################################
  private String getTitel() 
  {
    return titel;
  }
}
