package de.hska.iwi.ads.sorting;

/**
 * Abstrakter Datentyp, um in einem Feld
 * die Reihenfolge umzudrehen.
 */
public interface Reverse<E extends Comparable<E>> {

  /**
   * Dreht die Reihenfolge aller Werten <code>a[from..to]</code>
   * um. Die Bereiche <code>a[0..from-1]</code> und <code>a[to+1..a.length-1]</code>
   * bleiben unverändert. Der Bereich muss mindestens einen Wert enthalten.
   * Die Imlementierung muss in-place sein.
   * 
   * @param a    Feld, in dem die Werte umgedreht werden sollen
   * @param from Anfangsindex mit 0 <= from < to
   * @param to   Endindex mit from < to <= a.length - 1
   */
  void reverse(E [] a, int from, int to);
}
