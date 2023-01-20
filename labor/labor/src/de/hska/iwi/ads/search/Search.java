package de.hska.iwi.ads.search;

public interface Search<E extends Comparable<E>> {

  /**
   * Searches the lowest index position of <code>key</code> in the
   * sorted array <code>a</code> from <code>a[left]</code> up to <code>a[right]</code>, if key is an element of a.
   * If <code>key</code> does not exists in <code>a</code>, the index <code>i</code> is returned
   * in either of the following cases:
   * <ol>
   *   <li> a[i - 1] < key < a[i] with left < i < right,</li>
   *   <li> i = left - 1 if key < a[left], or</li>
   *   <li> i = right + 1 if a[right] < key</li>
   * </ol>
   * @param a  sorted in ascending order given by the Comparable<E> implementation 
   * @param key 
   * @param left start index for the search, 0 <= left <= right
   * @param right end index for the search, 0 <= left <= right < a.length
   * 
   * @throws NullPointerException if a is null
   * @throws ArrayIndexOutOfBoundsException if left or right is not within the index bounds of <code>a</code>
   */
  public int search(E [] a, E key, int left, int right);
  
  /**
   * Searches the lowest index position code>key</code> in the
   * sorted array <code>a</code>, if key is an element of a.
   * 
   * See {@link #search(Object[], Object, int, int)} with left = 0 and right = a.length - 1.
   */
  default int search(E [] a, E key) {
    return search(a, key, 0, a.length - 1);
  }
}
