package de.hska.iwi.ads.dictionary;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Set;

/**
 * AbstractDictionary provides a partial implementation of the {@code Map}
 * on basis of {@code AbstractMap}.
 * It restricts the type parameter K to implement {@code Comparable<K>},
 * provides an {@ code entrySet()} implementation on basis
 * of an abstract {@code iterator()} method and introduces a size attribute.
 * The size-value is returned by {@code size()}.
 */
public abstract class AbstractDictionary<K extends Comparable<K>, V> extends AbstractMap<K, V>  {

  @SuppressWarnings("serial")
  public static class DictionaryFullException extends RuntimeException {
    
  }

  /**
   * The number of key-value mappings in this Map.
   * If there are more than {@code Integer.MAX_INT} key-value mappings,
   * then size has to be {@code Integer.MAX_INT}.
   */
  protected int size;

  public int size() {
    return this.size;
  }
  
  /**
   * Iterates all {@code Entry<K, V>} 
   * stored in this Map.
   */
  public abstract Iterator<Entry<K, V>> iterator();
  
  public Set<Entry<K,V>> entrySet() {
    return new AbstractSet<Entry<K,V>>() {

      @Override
      public Iterator<Entry<K, V>> iterator() {
        return AbstractDictionary.this.iterator();
      }

      @Override
      public int size() {
        return size;
      }
      
    };
  }

}
