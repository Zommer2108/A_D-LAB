package de.hska.iwi.ads.search;

/**
 * Provides a straight forward linear search implementation
 * of the Search interface.
 */
public class LinearSearch<E extends Comparable<E>> implements Search<E> {

  @Override
  public int search(E[] a, E key, int left, int right) {
    E x = a[right]; // force exception if a is null or left or right is out of bounds
    x = a[left];
    int i = left;
    while ( (i <= right) && (a[i].compareTo(key) < 0) )  {
      i++;
    }
    return ( (i == left) && (a[i].compareTo(key) > 0)) ? i - 1 : i;
  }
 
}
