/*############################################################################
  Kodierung: UTF-8 ohne BOM - üöä
############################################################################*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//############################################################################
/** Repräsentiert die Bewertung einer gegebenen FlugStatistik
  *
  * @author Thomas Gerlach
*/
//############################################################################
public class FlugStatistik     // FlugBewertung
{
  private ArrayList<FlugInfo> statistik;

  private int nLadungTotal;
  private FlugInfo fMax;
  private FlugInfo fMin;
  private HashMap<String, Integer> lLadungAb;
  private HashMap<String, Integer> lLadungAn;

  private int nLadungAbTotal;
  private Integer nLadungAbMax;
  private Integer nLadungAbMin;
  private String sLadungAbMax;
  private String sLadungAbMin;

  private int nLadungAnTotal;
  private Integer nLadungAnMax;
  private Integer nLadungAnMin;
  private String sLadungAnMax;
  private String sLadungAnMin;
  
  //##########################################################################
  /** Konstruiert eine Berechnung mittels übergebener Liste Von Einzeldaten
    *
    * @param dieStatistik Liste von Einzelflugdaten
  */
  //##########################################################################
	public FlugStatistik(ArrayList<FlugInfo> dieStatistik)
	{
    nLadungTotal = 0;
    statistik = dieStatistik;
    fMax = dieStatistik.get(0);
    fMin = dieStatistik.get(0);
    lLadungAb = new HashMap<String, Integer>();
    lLadungAn = new HashMap<String, Integer>();
    
    calcBewegung();

    nLadungAbTotal = 0;
    nLadungAbMax = lLadungAb.values().toArray(new Integer[0])[0];
    nLadungAbMin = lLadungAb.values().toArray(new Integer[0])[0];
    sLadungAbMax = lLadungAb.keySet().toArray(new String[0])[0];
    sLadungAbMin = lLadungAb.keySet().toArray(new String[0])[0];

    nLadungAnTotal = 0;
    nLadungAnMax = lLadungAn.values().toArray(new Integer[0])[0];
    nLadungAnMin = lLadungAn.values().toArray(new Integer[0])[0];
    sLadungAnMax = lLadungAn.keySet().toArray(new String[0])[0];
    sLadungAnMin = lLadungAn.keySet().toArray(new String[0])[0];
    
    calcLadungAb();
    calcLadungAn();
  }
  
  //##########################################################################
  /** Liefert die Anzahl der gesamt transportierten Passagiere
    *
    * @return Anzahl Passagiere
  */
  //##########################################################################
	public int nLadungTotal()
  {
    return nLadungTotal;
  }

  //##########################################################################
  /** Liefert die Anzahl der abgeflogenen Passagiere
    *
    * @return Anzahl Passagiere
  */
  //##########################################################################
	public int nLadungAbTotal()
  {
    return nLadungAbTotal;
  }

  //##########################################################################
  /** Liefert die Anzahl der maximalen abgeflogenen Passagiere
    *
    * @return Anzahl Passagiere
  */
  //##########################################################################
	public int nLadungAbMax()
  {
    return nLadungAbMax;
  }

  //##########################################################################
  /** Liefert die Anzahl der maximalen angekommenen Passagiere
    *
    * @return Anzahl Passagiere
  */
  //##########################################################################
	public int nLadungAbMin()
  {
    return nLadungAbMin;
  }

  //##########################################################################
  /** Liefert den Namen des Flughafen von dem maximal abgeflogen wurde
    *
    * @return Name des Flughafen
  */
  //##########################################################################
	public String sLadungAbMax()
  {
    return sLadungAbMax;
  }

  //##########################################################################
  /** Liefert den Namen des Flughafen von dem minimal abgeflogen wurde
    *
    * @return Name des Flughafen
  */
  //##########################################################################
	public String sLadungAbMin()
  {
    return sLadungAbMin;
  }

  //##########################################################################
  /** Liefert den Namen des Flughafen von dem minimal angekommen wurde
    *
    * @return Name des Flughafen
  */
  //##########################################################################
	public String sLadungAnMin()
  {
    return sLadungAnMin;
  }

  //##########################################################################
  /** Liefert den Namen des Flughafen von dem maximal angekommen wurde
    *
    * @return Name des Flughafen
  */
  //##########################################################################
	public String sLadungAnMax()
  {
    return sLadungAnMax;
  }

  //##########################################################################
  /** Liefert die Anzahl der angekommenen Passagiere
    *
    * @return Anzahl Passagiere
  */
  //##########################################################################
	public int nLadungAnTotal()
  {
    return nLadungAnTotal;
  }

  //##########################################################################
  /** Liefert die Anzahl der angekommenen Passagiere
    *
    * @return Anzahl Passagiere
  */
  //##########################################################################
	public int nLadungAnMin()
  {
    return nLadungAnMin;
  }

  //##########################################################################
  /** Liefert die Anzahl der angekommenen Passagiere
    *
    * @return Anzahl Passagiere
  */
  //##########################################################################
	public int nLadungAnMax()
  {
    return nLadungAnMax;
  }

  //##########################################################################
  /** Liefert die Anzahl der angekommenen Passagiere
    *
    * @return Titel des Flugzeug
  */
  //##########################################################################
	public String fMaxFlugZeug()
  {
    return fMax.getFlugZeug();
  }

  //##########################################################################
  /** Liefert die Anzahl der angekommenen Passagiere
    *
    * @return Anzahl Passagiere
  */
  //##########################################################################
	public int fMaxMaximum()
  {
    return fMax.getMaximum();
  }

  //##########################################################################
  /** Liefert die Anzahl der angekommenen Passagiere
    *
    * @return Anzahl Passagiere
  */
  //##########################################################################
	public int fMaxCurrent()
  {
    return fMax.getCurrent();
  }
  
  //##########################################################################
  /** Liefert die Anzahl der angekommenen Passagiere
    *
    * @return Anzahl Passagiere
  */
  //##########################################################################
	public String fMaxFlugHafenAn()
  {
    return fMax.getFlugHafenAn();
  }
  
  //##########################################################################
  /** Liefert die Anzahl der angekommenen Passagiere
    *
    * @return Anzahl Passagiere
  */
  //##########################################################################
	public String fMaxFlugHafenAb()
  {
    return fMax.getFlugHafenAb();
  }
  
  //##########################################################################
  /** Liefert die Anzahl der angekommenen Passagiere
    *
    * @return Anzahl Passagiere
  */
  //##########################################################################
	public String fMinFlugZeug()
  {
    return fMin.getFlugZeug();
  }

  //##########################################################################
  /** Liefert die Anzahl der angekommenen Passagiere
    *
    * @return Anzahl Passagiere
  */
  //##########################################################################
	public int fMinMaximum()
  {
    return fMin.getMaximum();
  }

  //##########################################################################
  /** Liefert die Anzahl der angekommenen Passagiere
    *
    * @return Anzahl Passagiere
  */
  //##########################################################################
	public int fMinCurrent()
  {
    return fMin.getCurrent();
  }
  
  //##########################################################################
  /** Liefert den Namen des ZielFlughafen
    *
    * @return Name des Flughafen
  */
  //##########################################################################
	public String fMinFlugHafenAn()
  {
    return fMin.getFlugHafenAn();
  }
  
  //##########################################################################
  /** Liefert den Namen des QuellFlughafen
    *
    * @return Name des Flughafen
  */
  //##########################################################################
	public String fMinFlugHafenAb()
  {
    return fMin.getFlugHafenAb();
  }
  
  //##########################################################################
  /** Teilt die Flüge in Ab- und ankommende und ermittelt Max und Min
  */
  //##########################################################################
	private void calcBewegung()
	{
    for (FlugInfo daten : statistik)
    {
      nLadungTotal += daten.getMaximum();
      if (null == lLadungAb.get(daten.getFlugHafenAb()))  {
        lLadungAb.put(daten.getFlugHafenAb(), daten.getCurrent());
      } else {
        lLadungAb.put(daten.getFlugHafenAb(), lLadungAb.get(daten.getFlugHafenAb()) + daten.getCurrent());
      }
      if (null == lLadungAn.get(daten.getFlugHafenAn())) {
        lLadungAn.put(daten.getFlugHafenAn(), daten.getCurrent());
      } else {
        lLadungAn.put(daten.getFlugHafenAn(), lLadungAn.get(daten.getFlugHafenAn()) + daten.getCurrent());
      }
      if (fMax.getCurrent() * 100 / fMax.getMaximum() < daten.getCurrent() * 100 / daten.getMaximum()) {
        fMax = daten;
      }
      if (fMin.getCurrent() * 100 / fMin.getMaximum() > daten.getCurrent() * 100 / daten.getMaximum()) {
        fMin = daten;
      }
    }
  }

  //##########################################################################
  /** Berechnet die totale Ladung sowie min und max der abgehenden Flüge
  */
  //##########################################################################
  private void calcLadungAb()
  {
    for (String elem : lLadungAb.keySet())
    {
      nLadungAbTotal += lLadungAb.get(elem);
      if (nLadungAbMax < lLadungAb.get(elem)) {
        nLadungAbMax = lLadungAb.get(elem);
        sLadungAbMax = elem;
      }
      if (nLadungAbMin > lLadungAb.get(elem)) {
        nLadungAbMin = lLadungAb.get(elem);
        sLadungAbMin = elem;
      }
    }
  }

  //##########################################################################
  /** Berechnet die totale Ladung sowie min und max der ankommenden Flüge
  */
  //##########################################################################
  private void calcLadungAn()
  {
    for (String elem : lLadungAn.keySet())
    {
      nLadungAnTotal += lLadungAn.get(elem);
      if (nLadungAnMax < lLadungAn.get(elem)) {
        nLadungAnMax = lLadungAn.get(elem);
        sLadungAnMax = elem;
      }
      if (nLadungAnMin > lLadungAn.get(elem)) {
        nLadungAnMin = lLadungAn.get(elem);
        sLadungAnMin = elem;
      }
    }
  }  
}