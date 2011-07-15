/*############################################################################
  Kodierung: UTF-8 ohne BOM - üöä
############################################################################*/

//############################################################################
/** Repräsentiert den Verlauf einer Flugsimulation
  *
  * @author Thomas Gerlach
*/
//############################################################################
public class FlugSimulatorMain
{
  //##########################################################################
  /** Programmaufruf zur Steuerung der Flugsimulation
  */
  //##########################################################################
  public static void main(String[] args)
  {
    if (validiereArgs(args))
    {
      Ausgabe.leere();
      Ausgabe.zeile("\n\n\tF l u g s i m u l a t i o n\n\n");

      int anzahl = Integer.parseInt(args[0]);
      FlugSimulator simulation = new FlugSimulator(anzahl);

      do {

        simulation.starten();
                    
      } while (Eingabe.auswahl("Noch einen Tag simulieren? [j/n]: ", "j", "n"));

      Ausgabe.zeile("\n\n\tAuf Wiedersehen!\n\n");

    } else {
      schreibeAnleitung();
    }
  }

  //##########################################################################
  /** Validiert die übergebenen Parameter aud Anzahl und Datentyp
    *
    * @param args Eine zu prüfende Liste von Zeichenketten
    *
    * @return Ergebnis der Prüfung
  */
  //##########################################################################
  private static boolean validiereArgs(String[] args)
  {
    boolean ergebnis = false;
    if (args.length == 1)
    {
      try {
          int anzahl = Integer.parseInt(args[0]);
          ergebnis = (5 <= anzahl) && (anzahl <= 100);
      } catch (NumberFormatException nfe) {
      }
    }
    return ergebnis;
  }

  //##########################################################################
  /** Schreibt eine Anleitung zum Programmaufruf in die Standardausgabe
  */
  //##########################################################################
  private static void schreibeAnleitung()
  {
    System.out.format("\nBenutzung   : java FlugSimulatorMain anzahl");
    System.out.format("\nanzahl      : Ganzzahl [5 <= k <= 100]");
    System.out.format("\n\n");
  }
}


