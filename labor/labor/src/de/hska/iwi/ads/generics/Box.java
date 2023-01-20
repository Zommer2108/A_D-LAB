package de.hska.iwi.ads.generics;


/**
 * A box with some content inside.
 * One box is larger than another if its volume is larger

 * @param <T> the type of the content in the box
 */
public abstract class Box<T> implements Comparable< Box<T> >{

  protected int volume; // no specific measure
  
  private T content;
  
  /**
   * Creates a box with the given <code>volume</code>
   * and <code>content</code>.
   */
  public Box(int volume, T content) {
    this.volume = volume;
    this.content = content;
  }
  
  /**
   * returns true if and only if this box is empty
   */
  public boolean isEmpty() {
    return content == null;
  }

  /**
   * returns the volumne of this box
   */
  public int getVolume() {
    return this.volume;
  }
  

}
