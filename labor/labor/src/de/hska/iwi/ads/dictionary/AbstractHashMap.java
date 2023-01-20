package de.hska.iwi.ads.dictionary;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * A Hashtable with fixed table size, that uses probing to
 * handle collisions.
 * The implementation must not throw a  DictionaryFullException 
 * if there are at least 50% free slots.
 */
public abstract class AbstractHashMap<K extends Comparable<K>, V> extends AbstractDictionary<K, V> {

  protected Entry<K,V> [] hashtable;
 
  @SuppressWarnings("unchecked")
  public AbstractHashMap(int capacity) {
    hashtable = (Entry[]) Array.newInstance(Entry.class, capacity);
  }
  
  /**
   * iterates all values from the first to the last slot
   */
  public Iterator< Entry<K,V> > iterator() {
    return new Iterator<Entry<K,V>>() {

      private int current = 0;

      private void moveToNextNonEmptySlot() {
        do {
          current++;
        } while (current < hashtable.length && hashtable[current] == null);
      }
      
      {
        moveToNextNonEmptySlot();
      }
      
      @Override
      public boolean hasNext() {
        return current < hashtable.length && hashtable[current] != null; 
      }

      @Override
      public Entry<K,V> next() {
        if (! hasNext()) {
          throw new NoSuchElementException();
        }
        Entry<K,V> entry = hashtable[current];
        
        moveToNextNonEmptySlot();
        
        return entry;
      }
    };
  }
}
