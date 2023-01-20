package de.hska.iwi.ads.interfaces;


/**
 * Any thing that has a zero or positive dimension which can be scaled
 * by a zero or positive factor.
 */
public interface Scaleable {

  /**
   * Scales this Scaleable by the given factor.
   * @param factor >= 0
   * @throws IllegalArgumentException if factor is negative
   */
  public void scale(double factor);
  
  /**
   * Returns the positive or zero dimension of this Scaleable.
   */
  public double getDimension();
}
