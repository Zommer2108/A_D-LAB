package de.hska.iwi.ads.dictionary;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class AbstractDoubleLinkedList<K extends Comparable<K>, V> extends AbstractDictionary<K,V> {

  protected ListElement head;
  
  protected class ListElement {
    public ListElement previous,
                        next;
    public Entry<K,V> entry;
    
    public ListElement(Entry<K,V> entry, ListElement previous, ListElement next) {
      this.entry = entry;
      this.previous = previous;
      this.next = next;
    }
  }

  /**
   head to tail iteration of all values
   */
  @Override
  public Iterator<Entry<K, V>> iterator() {
    
    return new Iterator<Entry<K,V>>() {
      private ListElement current = head;
      
      @Override
      public boolean hasNext() {
        return current != null;
      }

      @Override
      public Entry<K,V> next() {
        if (! hasNext()) {
          throw new NoSuchElementException();
        }
        Entry<K,V> entry = current.entry;
        current = current.next;
        return entry;
      }

    };
  }
  
}
