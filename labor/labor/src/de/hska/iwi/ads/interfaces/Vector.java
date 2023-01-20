package de.hska.iwi.ads.interfaces;

/**
 * A vector in two dimensional euclidian space.
 * The length of a vector can be scaled.
 */
public interface Vector extends Scaleable {

  double POSITIVE_Y_AXIS_ANGLE = Math.PI / 2.0;
  
  /**
   * returns the x-coordinate of this Vector
   */
  double getX();
  
  /**
   * returns the y-coordinate of this Vector
   */
  double getY();
  
  /**
   * returns the euclidian length of this Vector
   */
  default double getLength() {
    return Math.sqrt( getX() * getX() + getY() * getY() );
  }
  
  /**
   * Returns the direction of this vector as an angle
   * counter-clockwise from the "x-axis".
   * The angle is in the range of [-Math.PI .. Math.PI].
   * The value 0 represents a vector pointing along the positive x axis.
   * The value {@link Math.PI} / 2.0 represents a vector pointing
   * along the positive y axis.
   */
  double getDirection();
  
  /**
   * Adds the given vector <code>addend</code> to this Vector
   * and returns the sum as a new Vector.
   * <code>addend</code> and this Vector remain unchanged.
   * If <code>addend</code> is null, then addend is treated like
   * the null-vector (0,0).
   */
  Vector add(Vector addend);
}
