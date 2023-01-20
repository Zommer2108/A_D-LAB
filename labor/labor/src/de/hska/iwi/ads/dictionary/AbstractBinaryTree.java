package de.hska.iwi.ads.dictionary;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public abstract class AbstractBinaryTree<K extends Comparable<K>, V> extends AbstractDictionary<K, V>  {
  
  protected Node root = null;
  
  protected class Node {
    public Node left = null,
                        right = null;
    public Entry<K,V> entry;
    public Node(K key, V value) {
      this.entry = new SimpleEntry<K,V>(key, value);
    }
  }
 
  /**
   * in-order iteration of all values
   */
  public Iterator< Entry<K,V> > iterator() {
    
    return new Iterator< Entry<K,V> >() {

      private Deque<Node> stack = new LinkedList<Node>();
      
      {
        stack.push(root);
      }
      
      @Override
      public boolean hasNext() {
        return stack.size() > 0 && stack.peek() != null;
      }

      @Override
      public Entry<K,V> next() {
        if (! hasNext()) {
          throw new NoSuchElementException();
        }
        Node next = stack.pop();
        if (next.left != null) {
          stack.push(next.left);
        }
        if (next.right != null) {
           stack.push(next.right);
        }
        return next.entry;
      }
    };
  }

  
}
