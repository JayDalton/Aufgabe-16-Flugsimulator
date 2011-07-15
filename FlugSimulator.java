/*############################################################################
  Kodierung: UTF-8 ohne BOM - üöä
############################################################################*/

import java.util.ArrayList;

//############################################################################
/** Repräsentiert die Simulation von Flugbewegungen
  *
  * @author Thomas Gerlach
*/
//############################################################################
public class FlugSimulator
{
  /** Zähler für die durchlaufenden Simulationen */
  private int start;

  /** Liste der Flughäfen in der Simulation */
  private ArrayList<FlugHafen> lFlugHafen;
  
  //##########################################################################
  /** Konstruiert eine Flugsimulation und initialisiert deren Flughäfen
    *
    * @param anzahl Anzahl der Flughäfen
  */
  //##########################################################################
  public FlugSimulator(int anzahl)
  {
    start = 0;
    lFlugHafen = new ArrayList<FlugHafen>();
    for (int i = 0; i < anzahl; i++) {
      lFlugHafen.add(new FlugHafen());
    }
  }

  //##########################################################################
  /** Startet die Simulation, lässt diese bewerten und startet die Ausgabe
  */
  //##########################################################################
  public void starten()
  {
    ArrayList<FlugInfo> lGeflogen = simulieren();
    
    FlugStatistik daten = new FlugStatistik(lGeflogen);
    
    System.out.format("\n---- Tag %2d ----\n", 1 + start++);
    System.out.format("\nFlüge.......: %4d\n", lGeflogen.size());

    ausgeben(daten);
  }

  //##########################################################################
  /** Simuliert die Flugbewegungen mittels zufälliger Anzahl und registriert
    * die Bewegungen und liefert diese.
    *
    * @return Liste von Flugbewegungen
  */
  //##########################################################################
  public ArrayList<FlugInfo> simulieren()
  {
    ArrayList<FlugInfo> lStatistik = new ArrayList<FlugInfo>();
    
    for (int idx = 0, max = Generator.ganzzahl(5000, 7000); idx < max; )
    {
      FlugHafen oFlugHafenAb = lFlugHafen.get(0);
      FlugHafen oFlugHafenAn = lFlugHafen.get(Generator.ganzzahl(1, lFlugHafen.size() - 1));
      while (0 < oFlugHafenAb.getCurrent() && oFlugHafenAn.getCurrent() < oFlugHafenAn.getMaximum()) 
      {
        FlugZeug flieger = oFlugHafenAb.getFlugZeug();
        lStatistik.add(new FlugInfo(oFlugHafenAb.getTitel(), flieger, oFlugHafenAn.getTitel()));
        oFlugHafenAn.setFlugZeug(flieger);
        idx++;
      }
      lFlugHafen.add(lFlugHafen.remove(0));
    }
    return lStatistik;
  }

  //##########################################################################
  /** Schreibt die ausgewerteten Bewegungen in die Standardausgabe
    *
    * @param daten Berechung der Flugbewegungen
  */
  //##########################################################################
  public void ausgeben(FlugStatistik daten)
  {
    System.out.format("\nAuslastung");
    System.out.format("\n%12s %6.2f%%", "total.:", daten.nLadungAbTotal() * 100.0 / daten.nLadungTotal());
    System.out.format("\n%12s %s->%s, %3d von %3d (%s)", "max...:", 
      daten.fMaxFlugHafenAb(), 
      daten.fMaxFlugHafenAn(), 
      daten.fMaxCurrent(), 
      daten.fMaxMaximum(), 
      daten.fMaxFlugZeug()
    );
    System.out.format("\n%12s %s->%s, %3d von %3d (%s)", "min...:", 
      daten.fMinFlugHafenAb(), 
      daten.fMinFlugHafenAn(), 
      daten.fMinCurrent(), 
      daten.fMinMaximum(), 
      daten.fMinFlugZeug()
    );
    System.out.format("\n");

    System.out.format("\nPassagiere abgeflogen");
    System.out.format("\n%12s %6d Passagiere", "total.:", daten.nLadungAbTotal());
    System.out.format("\n%12s %s, %6d Passagiere", "max...:", daten.sLadungAbMax(), daten.nLadungAbMax());
    System.out.format("\n%12s %s, %6d Passagiere", "min...:", daten.sLadungAbMin(), daten.nLadungAbMin());
    System.out.format("\n");

    System.out.format("\nPassagiere angekommen");
    System.out.format("\n%12s %6d Passagiere", "total.:", daten.nLadungAnTotal());
    System.out.format("\n%12s %s, %6d Passagiere", "max...:", daten.sLadungAnMax(), daten.nLadungAnMax());
    System.out.format("\n%12s %s, %6d Passagiere", "min...:", daten.sLadungAnMin(), daten.nLadungAnMin());
    System.out.format("\n");
  }  
}


