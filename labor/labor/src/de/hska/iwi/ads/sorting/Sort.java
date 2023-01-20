package de.hska.iwi.ads.sorting;

public interface Sort<E extends Comparable<E>> {

  /**
   * Sorts the elements of a into ascending order.
   * The algorithm is stable.
   */
  public void sort(E [] a);
}
